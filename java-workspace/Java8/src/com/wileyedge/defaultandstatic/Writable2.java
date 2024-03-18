package com.wileyedge.defaultandstatic;

public interface Writable2 {
	default void write1() {
		System.out.println("Default write1() inside Writable2 interface");
	}
	static void pqr() {
		System.out.println("Static pqr() inside Writable2 interface");
	}
}
