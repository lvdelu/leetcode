package com.data.resut;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {

		if (nums == null || nums.length == 0) {
			return new int[2];
		}

		Map<Integer, Integer> set = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int k = target - nums[i];
			if (set.containsKey(k)) {
				return new int[] { set.get(k), i };
			} else {
				set.put(nums[i], i);
			}
		}

		return new int[2];

	}

	public static void main(String[] args) {
		int nums[] = { 2 };
		TwoSum ts = new TwoSum();
		int result[] = ts.twoSum(nums, 9);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
}