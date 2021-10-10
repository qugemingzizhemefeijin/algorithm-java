package com.tigerjoys.cg.algorithm.test;

import org.openjdk.jol.info.ClassLayout;

public class Test {
	
	public static void main(String[] args) {
		Object obj = new Object();
		String s = ClassLayout.parseInstance(obj).toPrintable();
		System.out.println(s);
	}
	
	public static void cctv(Object o) {
		//ByteBuffer.allocateDirect(capacity)
	}

}
