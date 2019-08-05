package com.zj.clone;

public class TestClone {

	public static void main(String[] args) {
		int[] arg={1,2};
		CloneB a = new CloneB(1,"hhah",arg); 
		CloneB b=a;
		System.out.println(a+"=a");
		System.out.println(b+"=b");
		a.setAge(2);
		int[] arg2={2,2};
		a.setArg(arg2);
		System.out.println("修改之后----------------------------------");
		System.out.println(a+"=a");
		System.out.println(b+"=b");
		System.out.println("使用clone之后----------------------------------");
		CloneB a1 = new CloneB(1,"hhah",arg); 
		CloneB b1=a1.clone();
		System.out.println(a1+"=a1");
		System.out.println(b1+"=b1");
		a1.setAge(2);
		a1.setArg(arg2);
		System.out.println("修改之后----------------------------------");
		System.out.println(a1+"=a1");
		System.out.println(b1+"=b1");
	}
		
}
