package com.learn.algo.dp.knapsack;

public class SubsetSum {

	public static void main(String[] args) {
		
		int[] array = new int[] {5,8,9,3};
		int SUM = 10;
		int N = array.length;
		System.out.println("Recursive Approach:"+subsetSumRecursive(array,SUM,N));
		
		
		boolean dp[][] = new boolean[N+1][SUM+1];
		for(int j=0;j<SUM+1;j++) {
			dp[0][j]=false;
		}
		for(int i=0;i<N+1;i++) {
			dp[i][0]=true;
		}
			
		
		System.out.println("Top Down Approach:"+topDown(array,SUM,N,dp));
		
	}

	private static boolean subsetSumRecursive(int[] array, int SUM, int N) {
		if(SUM==0) {
			return true;
		}
		if(N==0) {
			return false;
		}
		
		if(array[N-1]<=SUM) {
			return subsetSumRecursive(array,SUM-array[N-1],N-1)||subsetSumRecursive(array,SUM,N-1);
		}else {
			return subsetSumRecursive(array,SUM,N-1);
		}
	}
	
	
	private static boolean topDown(int[] array, int SUM, int N, boolean[][] dp) {
		for(int i=1;i<N+1;i++) {
			for(int j=1;j<SUM+1;j++) {
				if(array[i-1]<=j) {
					dp[i][j]=dp[i-1][j-array[i-1]] || dp[i-1][j];
				}else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		return dp[N][SUM];
	}
	
	

}
