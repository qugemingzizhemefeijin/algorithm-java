package com.tigerjoys.cg.algorithm.linked;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 红包
 *
 */
public class RedPackage {

	/**
	 * 二倍均值法 假设剩余红包金额为m元， 剩余人数为n， 那么有如下公式。 每次抢到的金额 = 随机区间 [0.01， m /n × 2 - 0.01]元
	 */
	public static List<Integer> divideRedPackage(Integer totalAmount, Integer totalPeopleNum) {
		List<Integer> amountList = new ArrayList<>();
		int restAmount = totalAmount;
		int restPeopleNum = totalPeopleNum;
		Random random = new Random();
		for (int i = 0; i < totalPeopleNum - 1; i++) {
			// 随机范围： [1， 剩余人均金额的2倍-1] 分
			int amount = random.nextInt(restAmount / restPeopleNum * 2 - 1) + 1;
			restAmount -= amount;
			restPeopleNum--;
			amountList.add(amount);
		}
		amountList.add(restAmount);
		return amountList;
	}

	public static void main(String[] args) {
		List<Integer> amountList = divideRedPackage(1000, 10);
		for (Integer amount : amountList) {
			System.out.println("抢到金额： " + new BigDecimal(amount).divide(new BigDecimal(100)));
		}
	}

}
