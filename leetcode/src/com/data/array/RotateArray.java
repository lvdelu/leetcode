package com.data.array;

public class RotateArray {

	public void rotate(int[] nums, int k) {

		if (nums == null || nums.length < 1) {
			return;
		}

		k = k % nums.length;

		// 没错
		if (k != 0) {
			// 整个翻转,值对nums.lenth-k位逆序
			
			for (int i = 0, j = 1; i < nums.length; i++, j++) {
				if (i < nums.length - j) {
					int temp = nums[i];
					nums[i] = nums[nums.length - 1 - i];
					nums[nums.length - 1 - i] = temp;
				}
			}

			// int size = (k + nums.length) / 2;
			// 后size-k个翻转
			for (int i = k, j = 1; i < nums.length; i++, j++) {
				if (i < nums.length - j) {
					int temp = nums[i];
					nums[i] = nums[nums.length - j];
					nums[nums.length - j] = temp;
				}
			}

			for (int i = 0; i < nums.length; i++) {
				System.out.print(nums[i] + "*");
			}
			System.out.println();

			// 前k个翻转

			for (int i = 0, j = 1; i < k; i++, j++) {
				if (i < k - j) {
					int temp = nums[i];
					nums[i] = nums[k - j];
					nums[k - j] = temp;
				}
			}

		}

	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 6;
		RotateArray ra = new RotateArray();
		ra.rotate(a, k);

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

	}

}
