package com.tigerjoys.cg.algorithm.linked;

/**
 * 给出两个很大的整数， 要求实现程序求出两个整数之和，数字可能会超过long型长度
 * 解题：
 * 创建两个整型数组， 数组长度是较大整数的位数+1。 把每一个整数倒序存储到数组中， 整数的个位存于数组下标为0的位置， 最高位存于数组的尾部。 之所以倒序存储， 是因为这样更符合从左到右访问数组的习惯。
 * 创建结果数组， 结果数组的长度同样是较大整数的位数+1， +1的目的很明显， 是给最高位进位预留的。
 * 遍历两个数组， 从左到右按照对应下标把元素两两相加，就像小学生计算竖式一样。
 *
 */
public class TwoNumberAdd {
	
	public static void main(String[] args) {
		String bigNumberA = "123456789" , bigNumberB = "987654321";
		System.out.println(bigNumberSum(bigNumberA, bigNumberB));
	}
	
	public static String bigNumberSum(String bigNumberA, String bigNumberB) {
		//1.把两个大整数用数组逆序存储， 数组长度等于较大整数位数+1
		int maxLength = bigNumberA.length() > bigNumberB.length() ? bigNumberA.length() : bigNumberB.length();
		int[] arrayA = new int[maxLength+1];
		int[] arrayB = new int[maxLength+1];
		for(int i=0;i<bigNumberA.length();i++) {
			arrayA[i] = bigNumberA.charAt(bigNumberA.length() - 1 - i) - '0';
		}
		for(int i=0;i<bigNumberB.length();i++) {
			arrayB[i] = bigNumberB.charAt(bigNumberB.length() - 1 - i) - '0';
		}
		
		//2.构建result数组， 数组长度等于较大整数位数+1
		int[] result = new int[maxLength + 1];
		
		//3.遍历数组， 按位相加
		for(int i=0;i<arrayA.length;i++) {
			int temp = arrayA[i] + arrayB[i] + result[i];
			if(temp >= 10) {
				temp = temp - 10;
				result[i+1] = 1;
			}
			result[i] = temp;
		}
		
		//4.把result数组再次逆序并转成String
		StringBuilder buf = new StringBuilder(result.length);
		for(int i=result.length-1;i>=0;i--) {
			buf.append(result[i]);
		}
		
		return buf.toString();
	}

}
