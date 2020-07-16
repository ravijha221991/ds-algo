package com.learn.algo.dp.knapsack;

import java.util.Arrays;

public class EqualSumPartition {
	
	public static void main(String[] args) {
		int[] array = new int[] {3,5,2,7,8};
		int sum  =Arrays.stream(array).sum();
		boolean flag = false;
		if(sum%2 == 0) {
			int n = array.length;
			int W = sum/2;
			flag = SubsetSum.topDown(array,W,n);
		}
		System.out.println("Partition Possible:"+flag);
	}

}
