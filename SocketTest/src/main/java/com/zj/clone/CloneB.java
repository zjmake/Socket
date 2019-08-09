package com.zj.clone;

import java.util.Arrays;

public class CloneB implements Cloneable{
	
	private int age;
	private String name;
	private int[] arg;
	private Integer h=3;
	
	
	public Integer getH() {
		return h;
	}


	public void setH(Integer h) {
		this.h = h;
	}


	public CloneB() {
		super();
	}


	public CloneB(int age, String name, int[] arg) {
		super();
		this.age = age;
		this.name = name;
		this.arg = arg;
	}

	
	


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int[] getArg() {
		return arg;
	}


	public void setArg(int[] arg) {
		this.arg = arg;
	}


	


	public CloneB clone() {
		CloneB b = null;
		try {
			b=(CloneB)super.clone();
			b.arg=this.arg.clone();
			
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}


	@Override
	public String toString() {
		return "CloneB [age=" + age + ", name=" + name + ", arg=" + Arrays.toString(arg) + ", h=" + h + "]";
	}

}
