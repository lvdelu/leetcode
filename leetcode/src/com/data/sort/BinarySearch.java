package com.data.sort;

public class BinarySearch {

	public static int binarySeach(int a[], int num) {
		
		if (a == null || a.length == 0) {
			return -1;
		}

		int low = 0;
		int high = a.length - 1;

		while (low <= high) {

			int middle = (low + high) / 2;

			if (a[middle] == num) {
				return middle;
			} else if (a[middle] > num) {
				high = middle - 1;
			} else {
				low = middle + 1;
			}
		}

		return -1;

	}

	public static void main(String[] args) {
		System.out.println(binarySeach(Common.yxData(), 100));

	}

}
