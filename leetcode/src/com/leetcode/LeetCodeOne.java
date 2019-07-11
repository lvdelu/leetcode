package com.leetcode;

import java.util.HashMap;

class LeetCodeOne {
    public static int[] twoSum(int[] nums, int target) {
        
        if(nums==null || nums.length<2){
            return new int[]{0};
        }
        
        HashMap<Integer,Integer> map =new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            
            int data=target-nums[i];
            
            if(map.containsKey(data)){
                return new int[]{map.get(data),i};
            }
            map.put(nums[i],i);
        }
        
        return new int[]{0};
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 0, 4, 3, 0 };

		int[] result = twoSum(nums, 0);

		for (int i = 0; i < result.length; i++) {
			System.out.print(i + "  ");
		}
		
		System.out.println(Integer.MAX_VALUE);
		
		System.out.println(Integer.MIN_VALUE);
	}
}