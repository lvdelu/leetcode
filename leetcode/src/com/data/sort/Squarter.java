package com.data.sort;

public class Squarter {

	public static double quarter(int a, double precise) {

		double low = 0;
		double high = a;
		double middle = (low + high) / 2;
		while (Math.abs(low - high) >= precise) {

			if (middle * middle > a) {
				high = middle;
			} else if (middle * middle < a) {
				low = middle;
			} else if (Math.abs(middle * middle - a) < precise) {
				return middle;
			}
			middle = (low + high) / 2;
		}

		return middle;
	}

	public static void main(String[] args) {

		System.out.println(quarter(5, 0.000001));
	}

}
