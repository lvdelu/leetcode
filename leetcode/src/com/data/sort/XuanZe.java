package com.data.sort;

public class XuanZe {

	public static int[] xuanze(int a[]) {
		if (a.length < 1) {
			return a;
		}
		
		for(int i=0;i<a.length;i++){
			int min=a[i];
			int index=i;
			for(int j=i+1;j<a.length;j++ ){
				if(min>a[j]){
					min=a[j];
					index=j;
				}
			}
			Common.swap(a, i, index);
		}
		return a;
	}

	public static void main(String[] args) {
		int a[]=xuanze(Common.data());
		Common.println(a);
	}

}
