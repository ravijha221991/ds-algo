package com.learn.algo.dp.knapsack;

public class KnapSack01 {
	
	public static void main(String[] args) {
		int[] weights = new int[]{1,5,3,7,9,2};
		int[] profits = new int[]{10,50,30,70,90,20};
		int W = 12;
		int n = weights.length;
		System.out.println("*****Recursive Test************");
		System.out.println(recursive(weights,profits,W,n));
		
		System.out.println("*****Memoized Test************");
		int dp[][] = new int[101][1001];
		for(int i=0;i<101;i++) {
			for(int j=0;j<1001;j++) {
				dp[i][j]=-1;
			}
		}
		
		System.out.println(memoized(weights,profits,W,n,dp));
		
		System.out.println("*****Top Down Test************");
		 dp = new int[n+1][W+1];
		for(int i=0;i<n+1;i++) {
			dp[i][0]=0;
		}
		for(int j=0;j<W+1;j++) {
			dp[0][j]=0;
		}
		System.out.println(topdown(weights,profits,W,n,dp));
		
	}


	private static int recursive(int[] weights, int[] profits, int W, int n) {
		if(W==0||n==0) {
			return 0;
		}
		
		if(weights[n-1]<=W) {
			return Math.max(profits[n-1]+recursive(weights,profits,W-weights[n-1],n-1), recursive(weights,profits,W,n-1));
		}else {
			return recursive(weights,profits,W,n-1);
		}
	}
	
	private static int memoized(int[] weights,int[] profits,int W,int n,int[][] dp) {
		if(W==0||n==0) {
			return 0;
		}
		if(dp[n][W] != -1) {
			return dp[n][W];
		}
		if(weights[n-1]<=W) {
			dp[n][W]= Math.max(profits[n-1]+recursive(weights,profits,W-weights[n-1],n-1), recursive(weights,profits,W,n-1));
		}else {
			dp[n][W]=recursive(weights,profits,W,n-1);
		}
		
		return dp[n][W];
	}
	
	private static int topdown(int[] weights, int[] profits, int W, int n, int[][] dp) {
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<W+1;j++) {
				if(weights[i-1]<=j) {
					dp[i][j]=Math.max(profits[i-1]+dp[i-1][j-weights[i-1]], dp[i-1][j]);
				}else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		return dp[n][W];
	}

}
