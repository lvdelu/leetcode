package com.data.division;

public class MaxSubArray {

    /**
     * 输入: [-2,1,-3,4,-1,2,1,-5,4], 输出: 6 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     */

    public int maxSubArray(int s[]) {

        int max = s[0];

        int sum = s[0];

        for (int i = 1; i < s.length; i++) {

            if (sum >0) {
                sum = sum + s[i];
            } else {
                sum = s[i];
            }

            max = max > sum ? max : sum;

        }
        return max;

    }

    public int division(int s[]){

        return  0;
    }

    public static void main(String[] args) {

        MaxSubArray msa=new MaxSubArray();

        int a[]={-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(msa.maxSubArray(a));


    }

}
