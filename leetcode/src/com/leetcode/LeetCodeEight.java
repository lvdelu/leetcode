package com.leetcode;

public class LeetCodeEight {

	// public static int myAtoi(String str) {
	// int result = 0;
	// int status = 0;//0代表未开始 1代表是正数 2代表是负数
	// for (int i = 0; i < str.length(); i++) {
	// // '0' = 48 '9' = 57
	// char thisC = str.charAt(i);
	// if (thisC > 47 && thisC < 58) {
	// status = status == 2 ? status : 1;
	// int thisNum = thisC - 48;
	// if (result > Integer.MAX_VALUE / 10) { // 当大于Integer最大数/10取整部分时候
	// if (status == 2) {
	// return Integer.MIN_VALUE;
	// } else {
	// return Integer.MAX_VALUE;
	// }
	// } else if (result == Integer.MAX_VALUE / 10) {// 当直接等于Integer最大数/10取整部分时候
	// if (status == 2 && thisNum > 8) {// 当为负数的时候
	// return Integer.MIN_VALUE;
	// } else if (status != 2 && thisNum > 7){// 当为正数的时候
	// return Integer.MAX_VALUE;
	// }
	// }
	// result = result * 10 + thisNum;
	// } else if (status > 0) {// 一旦开始了只要中途断一下就结束
	// break;
	// } else if (thisC == '+') {
	// status = 1;
	// } else if (thisC == '-') {
	// status = 2;
	// } else if (thisC == ' ') {
	// status = 0;
	// } else {
	// return 0;
	// }
	// }
	// return result * (status == 2 ? -1 : 1);
	// }

	// public static int myAtoi(String str) {
	//
	// int result=0;
	//
	// int status = 0;//未开始
	//
	// int max=Integer.MAX_VALUE;
	//
	// int min=Integer.MIN_VALUE;
	//
	// for(int i=0;i<str.length();i++){
	//
	// char data=str.charAt(i);
	//
	// if(data > 47 && data < 58){
	// status = status==2 ? status : 1;
	// int a=data - 48;
	// //负数
	//
	// if(result > max /10){
	// if(status==2){
	// return min;
	// }else{
	// return max;
	// }
	// }
	//
	// if(result==max/10){
	// if(status == 2 && a>8){
	// return min;
	// }
	// if(status ==1 && a>7){
	// return max;
	// }
	// }
	// result =result * 10 +a;
	//
	// }else if(status>0){
	// break;
	// }
	// else if(data == ' '){
	// status=0;
	// }else if(data == '+'){
	// status = 1;
	// }else if(data == '-'){
	// status = 2;
	// }
	// }
	//
	// return result * status;
	//
	// }

	public static int myAtoi(String str) {

		int result = 0;

		int status = 0;// 未开始

		int max = Integer.MAX_VALUE;

		int min = Integer.MIN_VALUE;

		for (int i = 0; i < str.length(); i++) {

			char data = str.charAt(i);

			if (data > 47 && data < 58) {
				status = status == 2 ? status : 1;
				// 负数
				int a = data - 48;
				if (result > max / 10) {
					if (status == 2)
						return min;
					else {
						return max;
					}
				}

				if (result == max / 10) {
					if (status == 2 && a > 8) {
						return min;
					} else if(status !=2 && a>7){
						return max;
					}
				}
				result = result * 10 + a;

			} else if (status > 0) {
				break;
			} else if (data == ' ') {
				status = 0;
			} else if (data == '+') {
				status = 1;
			} else if (data == '-') {
				status = 2;
			}else{
				break;
			}
		}

		return result * (status == 2 ? -1 : 1);

	}

	public static void main(String[] args) {
		//System.out.println(myAtoi("42"));
		//System.out.println(myAtoi("   -42"));
		//System.out.println(myAtoi("4193 with words"));
		System.out.println(myAtoi("2147483646"));
		//System.out.println(myAtoi("-91283472332"));

	}

}
