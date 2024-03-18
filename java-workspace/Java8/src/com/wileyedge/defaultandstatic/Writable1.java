package com.wileyedge.defaultandstatic;

@FunctionalInterface
public interface Writable1 {
	void abc();
	//since, version>8
	default void write1() {
		System.out.println("Default write1() inside Writable1 interface");
	}
	
	default void write2() {
		System.out.println("Default write2() inside Writable1 interface");
	}
	
	static void pqr() {
		System.out.println("Static pqr() inside Writable1 interface");
	}
}
