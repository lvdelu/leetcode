package com.data.sort;

public class Common {

	public static void swap(int a[], int i, int j) {
		int temp = a[i] + a[j];
		a[i] = temp - a[i];
		a[j] = temp - a[j];
	}

	public static void print(int a[]) {
		for (int k = 0; k < a.length; k++) {
			System.out.print(a[k] + " ");
		}
		System.out.println();
	}

	public static void println(int b[]) {
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
	}

	public static int[] data() {
		return new int[] { 0, 5, 8, 7, 9, 10, -1, 11, 13, 3 };
	}
	
	public static int[] yxData() {
		return new int[] { 1,2,3,4,5,6,7,8 };
	}
}
