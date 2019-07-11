package com.data.find;

public class FindMedianSortedArrays {
	// 并且要求算法的时间复杂度为 O(log(m + n))
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		if (nums1 == null || nums2 == null) {
			return -1;// 不能合并
		}

		// 合并后的数组大小
		int size = nums1.length + nums2.length;
		if (size < 3) {
			return -1;// 3个数以下无中位数
		}

		int nums[] = new int[size];

		// 合并有序数组
		int i = 0;// nums1数组
		int j = 0;// nums2数组
		int k = 0;

		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				nums[k] = nums1[i];
				i++;

			} else {
				nums[k] = nums2[j];
				j++;
			}

			k++;
		}

		while (i < nums1.length) {
			nums[k++] = nums1[i++];
		}

		while (j < nums2.length) {
			nums[k++] = nums2[j++];
		}

		if (nums.length % 2 == 0) {
			return (nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2.0;
		} else {
			return nums[nums.length / 2];
		}

	}

	public static void main(String[] args) {

		// int a[]={1,3,5};int b[]={2,4,6};  1,2,3,4,5,6
		// 4 偶数 4/2 length/2 length/2-1 为中位数
		// 奇数 length/2
		// int a[]={1,2};int b[]={3,4};中位数为(2+3)/2=2.5
		int a[]={1,3};int b[]={2}; 
		FindMedianSortedArrays fsa=new FindMedianSortedArrays();
		System.out.println(fsa.findMedianSortedArrays(a,b));
	}

}
