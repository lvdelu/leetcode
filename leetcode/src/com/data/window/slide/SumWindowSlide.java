package com.data.window.slide;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;

public class SumWindowSlide {
	// https://www.zhihu.com/question/314669016

	public int slide(int a[], int k) {
		int max = 0;
		int temp;
		if (a == null || a.length < k) {
			return -1;
		}
		for (int i = 0; i < k; i++) {
			max = max + a[i];
		}
		// 记录了第一个值，滑动求解
		for (int i = k; i < a.length; i++) {
			temp = max + a[i] - a[i - k];
			max = max > temp ? max : temp;
		}
		return max;
	}

	public String min(String s, String t) {

		if (s == null || s.length() == 0) {
			return null;
		}

		if (t == null || t.length() == 0) {
			return null;
		}

		int right = 0;
		int left = 0;
		int count = t.length();
		int max = s.length();
		String res = s;

		int[] re = new int[256];

		for (int i = 0; i < t.length(); i++) {
			re[t.charAt(i)]++;
		}

		while (right < s.length()) {
			// (re[s.charAt(right)

			if (re[s.charAt(right)] > 0) {
				count--;
			}

			re[s.charAt(right)]--;
			right++;

			// 找到一个子串包含t,但不一定是最短的
			while (count == 0) {

				if (right - left < max) {
					res = s.substring(left, right);
					max = right - left;
				}

				re[s.charAt(left)]++;
				if (re[s.charAt(left)] > 0) {
					count++;
				}
				left++;
			}

		}
		return max == s.length() ? "" : res;
	}

	private List<Integer> maxValue(int[] value, int k) {
		System.out.println();
		List<Integer> list = new ArrayList<>();
		Deque<Integer> deque = new ArrayDeque<>(k);
		int res[] = new int[value.length - k + 1];
		// 8, 0,1,3,-1,-3,5,3,6,7
		for (int i = 0; i < value.length; i++) {

			// 保证最左边最大
			while (!deque.isEmpty() && value[deque.getLast()] < value[i]) {
				deque.removeLast();
			}
			// 入队
			deque.addLast(i);// 3

			if (i - k == deque.getFirst()) {
				deque.removeFirst();
			}
			// 2 k=3

			if (i + 1 >= k) {
				res[i - k + 1] = value[deque.getFirst()];
				list.add(value[deque.getFirst()]);
			}
		}

		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}

		return list;
	}

	// int a[] = { 400, 500, 300, 600,1,1000 };
	private int tanxin(int[] a, int k) {

		return 0;
	}

	private List<Integer> positon(String str, String p) {
		if ((str == null || str.length() == 0)) {
			return null;
		}

		if (p == null || p.length() == 0) {
			return null;
		}

		int res[] = new int[256];

		for (int i = 0; i < p.length(); i++) {
			res[p.charAt(i)]++;
		}

		// String str = "cbaebabacd";//
		// abc

		/*
		 * 
		 */
		List<Integer> list = new ArrayList<>();

		int right = 0;
		int left = 0;
		while (right < str.length()) {
			res[str.charAt(right)]--;
			while (res[str.charAt(right)] < 0) {
				res[str.charAt(left)]++;
				left++;
			}
			if (right - left == p.length() - 1) {
				list.add(left);
			}
			right++;
		}

		return list;
	}

	private int maxNoRepeatSub(String r) {

		if (r == null || r.length() < 1) {
			return 0;
		}
		int pre = -1;
		int max = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < r.length(); i++) {

			Integer index = map.get(r.charAt(i));
			if (index != null) {
				pre = pre > index ? pre : index;
				if (max > r.length() - 1 - index) {
					return max;
				}
			}
			max = max > i - pre ? max : i - pre;
			map.put(r.charAt(i), i);
		}

		return max;
	}

	public static void main(String[] args) {

		SumWindowSlide sws = new SumWindowSlide();
		// 给定一个整数数组，计算长度为 'k' 的连续子数组的最大总和
		int a[] = { 400, 500, 300, 600, 1, 1000 };

		System.out.println(sws.slide(a, 2));

		System.out.println(sws.tanxin(a, 2));

		// 给定一个字符串 S 和一个字符串 T，请在 S 中找出包含 T 所有字母的最小子串
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println(sws.min(s, t));

		// S
		String r = "vfva";
		System.out.println(sws.maxNoRepeatSub(r));

		//
		String str = "cbaebabacd";//
		// "abcbabcbabcba" //abc
		// "111"
		String p = "abc";

		List<Integer> list = sws.positon(str, p);

		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}

		// 最大值
		int value[] = { 8, 0, 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;//
		System.out.println(sws.maxValue(value, k));

		/*
		 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s
		 * 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。 输入: s = 7, nums = [2,3,1,2,4,3] 输出:
		 * 2 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
		 */
		int nums[] = { 2, 3, 1, 4, 2, 3 };
		sws.findSubArray(nums, 5);

		/**
		 * 题目来源于 LeetCode 上第 219 号问题：存在重复元素 II。题目难度为 Easy，目前通过率为 33.9% 。
		 * 题目描述给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且
		 * i 和 j 的差的绝对值最大为 k。
		 */

		System.out.println();

		int b[] = { 1, 2, 3, 1 };// 2不存在,6存在
		k = 3;
		System.out.println(sws.repeat(b, k));
		
		System.out.println(sws.repeatSlideWindow(b, k));

	}

	private boolean repeat(int[] b, int k) {
		// 1, 2, 3, 4, 2, 3
		if (b == null || b.length <= 1) {
			return false;
		}

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < b.length; i++) {

			Integer key = map.get(b[i]);

			if (key == null) {
				map.put(b[i], i);
				continue;
			} else if (i - key <= k) {
				return true;
			} else {
				map.put(b[i], i);
			}
		}

		return false;
	}

	private boolean repeatSlideWindow(int[] b, int k) {
		// 1, 2, 3, 4, 2, 3
		if (b == null || b.length <= 1) {
			return false;
		}

		Deque<Integer> queue = new ArrayDeque<>();

		for (int i = 0; i < b.length; i++) {

			while (!queue.isEmpty() && queue.contains(b[i])) {
				return true;
			}

			if (queue.isEmpty() && queue.size() <= k) {
				queue.addLast(b[i]);
			}else{
				queue.removeFirst();
				queue.addLast(b[i]);
			}	
		}

		return false;
	}

	private boolean find(int[] res, int i) {
		// TODO Auto-generated method stub
		return false;
	}

	private int[] findSubArray(int[] nums, int s) {
		if (nums == null || nums.length < 1) {
			return new int[0];
		}

		int right = 0;
		int left = 0;
		int max = nums.length;
		int sum = 0;
		int low = 0;
		int high = 0;
		// 2, 3, 1, 2, 4, 3
		while (right < nums.length) {

			sum = sum + nums[right];

			while (sum > s) {
				sum = sum - nums[left];
				left++;
			}

			while (sum == s) {
				if (right - left < max) {
					// 赋值
					low = left;
					high = right;
					max = high - low + 1;

				}
				sum = sum - nums[left];
				left++;
			}

			right++;

		}

		int[] result = new int[max];

		for (int i = low; i <= high; i++) {
			result[i - low] = nums[i];
			System.out.print(nums[i] + " ");
		}

		return result;

	}

}
