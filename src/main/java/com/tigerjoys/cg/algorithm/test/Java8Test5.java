package com.tigerjoys.cg.algorithm.test;

import java.util.concurrent.atomic.AtomicLong;

public class Java8Test5 {
	
	static AtomicLong i = new AtomicLong();
	static Thread t = new Thread(i::getAndIncrement);
	
	static {
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Over");
	}
	
	public static void main(String[] args) {
		System.out.println("Test");
	}

}
