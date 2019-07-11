package com.data.sort;

public class ChaRu {

	public static void main(String[] args) {
		int a[] = chaRu(Common.data());
		Common.println(a);
	}

	private static int[] chaRu(int[] data) {
		if (data.length < 1) {
			return data;
		}
		
		for(int i=1;i<data.length;i++){
			int value=data[i];
			for(int j=i-1;j >=0 ;j--){
				if(data[j]>data[j+1]){
					data[j+1]=data[j];
				}else{
					break;
				}
				data[j]=value;
			}
		}
		return data;
	}

}
