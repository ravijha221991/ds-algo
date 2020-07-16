package com.learn.algo.dp.knapsack;

import java.util.Arrays;

public class MinSubsetDiff {
	
	public static void main(String[] args) {
		int[] array = new int[] {3,4,7,6,5};
		int sum = Arrays.stream(array).sum();
		int n = array.length;
		boolean dp[][] = topDown(array,sum,n);
		
		int min = Integer.MAX_VALUE;
		int mid = sum/2;
		for(int j=1;j<=mid;j++) {
			if(dp[n-1][j]) {
				min = Math.min(Math.abs(sum-2*j), min);
			}
		}
		System.out.println("Min Difference:"+min);
	}
	
	
	
public static boolean[][] topDown(int[] array, int SUM, int N) {
		
		boolean dp[][] = new boolean[N+1][SUM+1];
		for(int j=0;j<SUM+1;j++) {
			dp[0][j]=false;
		}
		for(int i=0;i<N+1;i++) {
			dp[i][0]=true;
		}
		
		for(int i=1;i<N+1;i++) {
			for(int j=1;j<SUM+1;j++) {
				if(array[i-1]<=j) {
					dp[i][j]=dp[i-1][j-array[i-1]] || dp[i-1][j];
				}else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		return dp;
	}

}
