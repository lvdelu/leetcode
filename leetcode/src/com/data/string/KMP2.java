package com.data.string;

public class KMP2 {

	public static int[] makeNext(char b[], int m) {
		int[] next = new int[m];
		int k=0;
		next[0] = 0;// 模版字符串的第一个字符的最大前后缀长度为0
		for (int q = 1; q < m; ++q)// for循环，从第二个字符开始，依次计算每一个字符对应的next值
		{
			while (k > 0 && b[q] != b[k])// 递归的求出P[0]···P[q]的最大的相同的前后缀长度k
				k = next[k - 1]; // 不理解没关系看下面的分析，这个while循环是整段代码的精髓所在，确实不好理解
			if (b[q] == b[k])// 如果相等，那么最大相同前后缀长度加1
			{
				k++;
			}
			next[q] = k;
		}

		return next;
	}

	public static int kmp(char a[], int n, char b[], int m) {
		int[] next = makeNext(b, m);
		for (int i = 0, j = 0; i < n; i=i+1) {
			while (j > 0 && b[j] != a[i])
				j = next[j - 1];
			if (b[j] == a[i]) {
				j++;
			}
			if (j == m) {
				return i - m + 1;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		char[] a = { 'a', '4', 'r', '3', 'r', 'r', '8', 'e', 'f' };
		char[] b = { 'r', '3', 'r', 'r', '8' };
		System.out.println(kmp(a, a.length, b, b.length));
	}

}
