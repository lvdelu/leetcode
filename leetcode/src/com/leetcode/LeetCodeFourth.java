package com.leetcode;

public class LeetCodeFourth {

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

		if (nums1 == null) {
			return result(nums2, nums2.length);
		}

		if (nums2 == null) {
			return result(nums1, nums1.length);
		}

		int length1 = nums1.length;

		int length2 = nums2.length;

		int length = length1 + length2;

		int nums[] = new int[length];

		for (int i = 0, i1 = 0, i2 = 0; i < length; i++) {

			
			
			if(i1!=length1 && i2!=length2){
				if (nums1[i1] < nums2[i2]) {
					nums[i] = nums1[i1++];
				} else {
					nums[i] = nums2[i2++];
				}
			}else{
				if(i1==length1){
					nums[i]=nums2[i2++];
				}else if(i2==length2){
					nums[i]=nums1[i1++];
				}
				
				
			}

		}
		
		return result(nums, length);

	}

	public static double result(int nums[], int length) {
		if (length % 2 != 0) {
			
			return nums[length / 2];
			
		} else {
			
			int l = length / 2;

			return (nums[l - 1] + nums[l]) * 1.0 / 2;
		}

	}

	public static void main(String[] args) {

		int nums1[] = new int[] { 1, 2 };

		int nums2[] = new int[] { 3, 4 };

		System.out.println(findMedianSortedArrays(nums1, nums2));
	}

}
