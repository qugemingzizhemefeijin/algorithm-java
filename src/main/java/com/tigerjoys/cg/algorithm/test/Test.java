package com.tigerjoys.cg.algorithm.test;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import org.openjdk.jol.info.ClassLayout;

import java.util.HashMap;

public class Test {
	
	public static void main(String[] args) {
		Object obj = new Object();
		String s = ClassLayout.parseInstance(obj).toPrintable();
		System.out.println(s);

		long cc = ObjectSizeCalculator.getObjectSize(new HashMap<>());
		System.out.println(cc);
	}
	
	public static void cctv(Object o) {
		//ByteBuffer.allocateDirect(capacity)
	}

}
