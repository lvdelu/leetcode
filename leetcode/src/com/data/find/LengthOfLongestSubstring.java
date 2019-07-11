package com.data.find;

import java.util.HashMap;
import java.util.Map;

//最长子字符串
public class LengthOfLongestSubstring {

	public int lengthOfLongestSubstring(String s) {

		if (s == null || s.length() < 1) {
			return 0;
		}
		int max = 0;
		//滑动窗口法
		int pre = -1;// 重复字符串出现的位置
		Map<Character, Integer> map = new HashMap<>();// 记录字符上次出现的位置
		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			Integer repeat = map.get(c);
			if (repeat != null) {
				pre = repeat > pre ? repeat : pre;
				if (max > s.length() - 1 - repeat) {
					return max;
				}
			}
			max = max > i - pre ? max : i - pre;
			map.put(c, i);
		}

		return max;
	}

	public static void main(String[] args) {
		// abcdeacbcedf
		String str = "k";
		LengthOfLongestSubstring lp = new LengthOfLongestSubstring();
		System.out.println(lp.lengthOfLongestSubstring(str));
	}
}
