package com.learn.algo.dp.knapsack;

public class KnapSack01 {
	
	public static void main(String[] args) {
		int[] weights = new int[]{1,5,3,7,9,2};
		int[] profits = new int[]{10,50,30,70,90,20};
		int W = 12;
		int n = weights.length;
		System.out.println(recursive(weights,profits,W,n));
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

}
