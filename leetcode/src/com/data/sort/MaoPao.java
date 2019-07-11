package com.data.sort;

public class MaoPao {

	public static int[] mPao(int a[]) {

		if (a.length < 1) {
			return a;
		}
		boolean flag = false;
		for (int i = a.length - 1; i >= 0; i--) {
			for (int j = i - 1; j >= 0; j--) {
				if (a[i] < a[j]) {
					Common.swap(a, i, j);
					flag = true;
				}
			}

			Common.print(a);
			if (!flag) {
				System.out.println("break");
				break;
			}
		}
		return a;
	}

	public static void main(String[] args) {

		int a[] = { 4, 5, 6, 3, 2, 1 };
		int b[] = mPao(a);
		Common.print(b);
	}

}
