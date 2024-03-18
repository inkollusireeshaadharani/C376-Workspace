package com.wileyedge.defaultandstatic;

public class WritableImpl implements Writable1, Writable2 {

	//compulsory to override since it is abstract
	@Override
	public void abc() {
		System.out.println("This is overridden abc() inside WritableImpl");
	}

	@Override
	public void write1() {
//		Writable1.super.write1();
		System.out.println("This is overridden write1() inside WritableImpl");
	}

}
