package com.sist.spring2;

public interface Hello {
	
	public void display();
	public default void sayHello(){}
	public static void sayHello2(){}
}
