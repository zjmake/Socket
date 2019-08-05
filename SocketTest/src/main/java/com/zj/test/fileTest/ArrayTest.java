package com.zj.test.fileTest;

import java.util.*;




public class ArrayTest {
	

	enum Test{Head,HAPP}
	public static <T extends Comparable<T>>  T aa(T x, T a) {
		T max=x;
		if(x.compareTo(a)>0) {
			a=x;
		}
		return a;
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		Integer aa = aa(2,1);
	
		System.out.println(aa);
	
	}
}
