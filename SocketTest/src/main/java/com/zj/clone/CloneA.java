package com.zj.clone;

public class CloneA implements Cloneable{

	
	
	
	public CloneA clone() {
		CloneA a = null;
		try {
			 a=(CloneA)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
}
