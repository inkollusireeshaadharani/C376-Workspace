package com.datastructures.exp;

//unchecked exception -- not a compulsion to handle/declare
@SuppressWarnings("serial")
public class ListIndexOutOfBounds extends RuntimeException {
	public ListIndexOutOfBounds (String msg){
		super(msg);
	}
}
