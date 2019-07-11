package com.data.sort;

public class KuaiPai {

	public static void KuaiPai(int a[], int low, int high) {

		int l = low;
		int h = high;
		int p = a[l];

		while (l < h) {
			while (l < h && a[h] > p)
				h--;
			if (l < h) {
				a[l] = a[h];
				l++;
			}
			Common.print(a);
			while (l < h && a[l] < p)
				l++;

			if (l < h) {
				a[h] = a[l];
				h--;
			}
			Common.print(a);
		}
		
		
		
		a[l]=p;
		
		System.out.println("************");
		Common.print(a);

		if (low < l - 1) {
			System.out.println("1");
			KuaiPai(a, low, l - 1);
		}

		if (h + 1 < high) {
			KuaiPai(a, h + 1, high);
		}
		
		

	}

	public static void main(String[] args) {
		int a[] = {2, -1 ,-2, 0, 1 ,3 };
		Common.print(a);
		System.out.println("****kauipai******");
		KuaiPai(a, 0, a.length - 1);
		Common.print(a);
	}

}
