package com.learn.algo;

public class CommonUtil {
	
	public static boolean[][] initializeBool(int row,int col){
		boolean dp[][] = new boolean[row+1][col+1];
		for(int j=0;j<row+1;j++) {
			dp[0][j]=false;
		}
		for(int i=0;i<col+1;i++) {
			dp[i][0]=true;
		}
		return dp;
	}
	
	
	public static int[][] initializeInt(int row,int col){
		int dp[][] = new int[row+1][col+1];
		for(int j=0;j<row+1;j++) {
			dp[0][j]=0;
		}
		for(int i=0;i<col+1;i++) {
			dp[i][0]=1;
		}
		return dp;
	}

}
