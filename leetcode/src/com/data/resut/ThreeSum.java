package com.data.resut;

import java.util.ArrayList;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {
		int nums[] = { 3, 0, -2, -1, 1, 2 };
		ThreeSum ts = new ThreeSum();
		List<List<Integer>> result = ts.threeSum(nums);
		for (List<Integer> l : result) {
			for (Integer j : l) {
				// 去重
				System.out.print(j + " ");
			}
			System.out.println();
		}

	}

	public List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> list = new ArrayList<>();
		if (nums == null || nums.length < 3) {
			return list;
		}

		quickSort(nums, 0, nums.length - 1);

		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				break;
			}

			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			int m = i + 1, n = nums.length - 1;

			while (m < n) {
				if (n < nums.length - 1 && nums[n] == nums[n + 1] || nums[i] + nums[m] + nums[n] > 0) {
					n--;
				} else if (m > i + 1 && nums[m] == nums[m - 1] || nums[i] + nums[m] + nums[n] < 0) {
					m++;
				} else {
					List<Integer> result = new ArrayList<>();
					result.add(nums[i]);
					result.add(nums[m++]);
					result.add(nums[n--]);
					list.add(result);
				}
			}
		}

		// 开始遍历

		return list;

	}

	private void quickSort(int[] nums, int low, int high) {

		int l = low;
		int h = high;
		int key = nums[l];

		while (l < h) {
			while (l < h && nums[h] > key)
				h--;
			if (l < h) {
				nums[l] = nums[h];
				l++;
			}
			while (l < h && nums[l] < key)
				l++;
			if (l < h) {
				nums[h] = nums[l];
				h--;
			}
		}
		nums[l] = key;

		if (low < l - 1)
			quickSort(nums, low + 1, l);
		if (h + 1 < high)
			quickSort(nums, h + 1, high);

	}
}
