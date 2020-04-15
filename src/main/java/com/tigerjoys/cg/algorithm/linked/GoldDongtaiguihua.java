package com.tigerjoys.cg.algorithm.linked;

/**
 * 
 * 很久很久以前， 有一位国王拥有5座金矿， 每座金矿的黄金储量不同， 需要参与挖掘的工人人数也不同。 例如有的金矿储量是500kg黄金，
 * 需要5个工人来挖掘； 有的金矿储量是200kg黄金， 需要3个工人来挖掘……
 *  
 * 如果参与挖矿的工人的总数是10。 每座金矿要么全挖， 要么不挖，不能派出一半人挖取一半的金矿。 要求用程序求出， 要想得到尽可能多
 * 的黄金， 应该选择挖取哪几座金矿？
 * 
 *
 */
public class GoldDongtaiguihua {
	
	/**
	* 获得金矿最优收益
	* @param w 工人数量
	* @param n 可选金矿数量
	* @param p 金矿开采所需的工人数量
	* @param g 金矿储量
	* @return int
	*/
	public static int getBestGoldMining(int w, int n, int[] p, int[] g) {
		if (w == 0 || n == 0) {
			return 0;
		}
		if (w < p[n - 1]) {
			return getBestGoldMining(w, n - 1, p, g);
		}
		return Math.max(getBestGoldMining(w, n - 1, p, g), getBestGoldMining(w - p[n - 1], n - 1, p, g) + g[n - 1]);
	}
	
	/**
	 * 获得金矿最优收益
	 * @param w - 工人数量
	 * @param p - 金矿开采所需的工人数量
	 * @param g - 金矿储量
	 * @return int
	 */
	public static int getBestGoldMiningV2(int w, int[] p, int[] g) {
		// 创建表格
		int[][] resultTable = new int[g.length + 1][w + 1];
		// 填充表格
		for (int i = 1; i <= g.length; i++) {
			for (int j = 1; j <= w; j++) {
				if (j < p[i - 1]) {
					resultTable[i][j] = resultTable[i - 1][j];
				} else {
					resultTable[i][j] = Math.max(resultTable[i - 1][j], resultTable[i - 1][j - p[i - 1]] + g[i - 1]);
				}
			}
		}
		// 返回最后1个格子的值
		return resultTable[g.length][w];
	}
	
	/**
	 * 获得金矿最优收益
	 * @param w - 工人数量
	 * @param p - 金矿开采所需的工人数量
	 * @param g - 金矿储量
	 * @return int
	 */
	public static int getBestGoldMiningV3(int w, int[] p, int[] g) {
		// 创建当前结果
		int[] results = new int[w + 1];
		// 填充一维数组
		for (int i = 1; i <= g.length; i++) {
			for (int j = w; j >= 1; j--) {
				if (j >= p[i - 1]) {
					results[j] = Math.max(results[j], results[j - p[i - 1]] + g[i - 1]);
				}
			}
		}
		// 返回最后1个格子的值
		return results[w];
	}
	
	public static void main(String[] args) {
		int w = 10;
		int[] p = { 5, 5, 3, 4, 3 };
		int[] g = { 400, 500, 200, 300, 350 };
		System.out.println("最优收益： " + getBestGoldMiningV3(w, p, g));
	}

}
