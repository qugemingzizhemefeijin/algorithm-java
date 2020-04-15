package com.tigerjoys.cg.algorithm.linked;

import java.util.Arrays;
import java.util.Random;
import java.util.Set;

import com.google.common.collect.Sets;

/**
 * 在一个无序数组里有99个不重复的正整数， 范围是1～100， 唯独缺少1个1～100中的整数。 如何找出这个缺失的整数？
 *
 */
public class SearchLackInt {
	
	/**
	 * 创建一个哈希表， 以1到100这100个整数为Key。 然后遍历整个数组， 每读到一个整数， 就定位到哈希表中对应的Key， 然后删除这个Key。
	 * 由于数组中缺少1个整数， 哈希表最终一定会有99个Key被删除， 从而剩下1个唯一的Key。 这个剩下的Key就是那个缺失的整数。
	 * 假设数组长度是n， 那么该解法的时间复杂度是O(n)， 空间复杂度是O(n)
	 * @param array
	 * @return
	 */
	public static int soulte1(int[] array) {
		Set<Integer> s = Sets.newHashSet();
		for(int i=1;i<=100;i++) {
			s.add(i);
		}
		
		for(int i : array) {
			s.remove(i);
		}
		
		return s.iterator().next();
	}
	
	/**
	 * 先把数组元素从小到大进行排序， 然后遍历已经有序的数组， 如果发现某两个相邻元素并不连续， 说明缺少的就是这两个元素之间的整数。
	 * 假设数组长度是n， 如果用时间复杂度为O(nlogn)的排序算法进行排序， 那么该解法的时间复杂度是O(nlogn)， 空间复杂度是O(1)。
	 * @param array
	 * @return
	 */
	public static int soulte2(int[] array) {
		Arrays.sort(array);
		for(int i=0;i<array.length-1;i++) {
			if(array[i+1] - array[i] > 1) {
				return array[i+1]-1;
			}
		}
		//如果没有匹配到，则代表要么头没有，要么尾没有
		if(array[0] != 1) {
			return 1;
		} else {
			return 100;
		}
	}
	
	/**
	 * 先算出1+2+3+…+100的和， 然后依次减去数组里的元素， 最后得到的差值， 就是那个缺失的整数。
	 * 假设数组长度是n， 那么该解法的时间复杂度是O(n)， 空间复杂度是O(1)。
	 * @param array
	 * @return
	 */
	public static int soulte3(int[] array) {
		int total = 5050;
		int sum = 0;
		for(int i : array) {
			sum += i;
		}
		return total - sum;
	}
	
	private static int[] create() {
		Random ran = new Random();
		int r = ran.nextInt(100) + 1;
		int[] array = new int[99];
		int idx = 0;
		for(int i=1;i<=100;i++) {
			if(i == r) {
				continue;
			}
			array[idx++] = i;
		}
		
		for(int i=0;i<array.length;i++) {
			int dx = ran.nextInt(array.length);
			int temp = array[i];
			array[i] = array[dx];
			array[dx] = temp;
		}
		return array;
	}
	
	public static void main(String[] args) {
		int[] array = create();
		System.out.println(Arrays.toString(array));
		System.out.println("残缺的整数数解法1：" + soulte1(array));
		System.out.println("残缺的整数数解法2：" + soulte2(array));
		System.out.println("残缺的整数数解法3：" + soulte3(array));
	}

}
