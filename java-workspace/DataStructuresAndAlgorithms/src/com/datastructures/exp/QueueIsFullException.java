package com.datastructures.exp;

@SuppressWarnings("serial")
public class QueueIsFullException extends Exception{
	public QueueIsFullException(String msg){
		super(msg);
	}
}
