package com.zj.clone;

import java.util.Arrays;

public class CloneB implements Cloneable{
	
	private int age;
	private String name;
	private int[] arg;
	
	
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


	@Override
	public String toString() {
		return "CloneB [age=" + age + ", name=" + name + ", arg=" + Arrays.toString(arg) + "]";
	}


	public CloneB clone() {
		CloneB b = null;
		try {
			b=(CloneB)super.clone();
			b.arg=Arrays.copyOf(this.arg, arg.length);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

}
