package com.data.string;

public class KMP {

	// a, b 分别是主串和模式串；n, m 分别是主串和模式串的长度。
	public static int kmp(char[] a, int n, char[] b, int m) {
		int[] next = getNexts(b, m);
		int j = 0;
		for (int i = 0; i < n; ++i) {
			while (j > 0 && a[i] != b[j]) { // 一直找到 a[i] 和 b[j]
				j = next[j - 1] + 1;
			}
			if (a[i] == b[j]) {
				++j;
			}
			if (j == m) { // 找到匹配模式串的了
				return i - m + 1;
			}
		}
		return -1;
	}

	// b 表示模式串，m 表示模式串的长度
	private static int[] getNexts(char[] b, int m) {
		int[] next = new int[m];
		next[0] = -1;
		int k = -1;
		for (int i = 1; i < m; ++i) {
			while (k != -1 && b[k + 1] != b[i]) {
				k = next[k];
			}
			if (b[k + 1] == b[i]) {
				++k;
			}
			next[i] = k;
		}
		return next;
	}

	public static void main(String[] args) {
		char[] a = { 'a', '4', 'r','3', 'r', 'r', '5', 'e', 'f' };
		char[] b = { 'r','3', 'r', 'r', '5' };
		System.out.println(kmp(a, a.length, b, b.length));
		//System.out.println();
	}

	public int[] getNext(char b[], int m) {

		int next[] = new int[m];
		next[0] = 0;
		int k = 0;
		
		for(int i=0;i<b.length;i++){
			
		}
		
		return next;

	}

}
