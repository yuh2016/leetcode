package com.codewars.yh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class FindOdd {
	/**
	 * Find the odd in
	 * Given an array, find the int that appears an odd number of times.

		There will always be only one integer that appears an odd number of times.
		查找出现奇数次数的数字（只有一个）
	 * @param a
	 * @return
	 */
	public static int findIt(int[] a) {
		ArrayList<Integer> list = new ArrayList<>();
		for(int num: a){
			int inx = list.indexOf(num);
			if(inx == -1){
				list.add(num);
			}else{
				list.remove(inx);
			}
		}
		return list.get(0);
		
		//用set更好，set没有remove(index)的方法，只有remove(obj)
//		TreeSet<Integer> set = new TreeSet<>();
		
		
		//网上看到的超简洁的方法！！！
		//异或运算：
//			异或运算的三个个特点:
//		    (1) 0^0=0,   0^1=1   0与任何数异或＝任何数
//		    (2) 1^0=1,   1^1=0   1与任何数异或 =任何数取反
//		    (3) 任何数异或自己＝把自己置0
//		 return Arrays.stream(a).reduce(0, (x, y) -> x ^ y);

	}
}
