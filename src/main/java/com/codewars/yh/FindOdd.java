package com.codewars.yh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class FindOdd {
	/**
	 * Find the odd in
	 * Given an array, find the int that appears an odd number of times.

		There will always be only one integer that appears an odd number of times.
		���ҳ����������������֣�ֻ��һ����
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
		
		//��set���ã�setû��remove(index)�ķ�����ֻ��remove(obj)
//		TreeSet<Integer> set = new TreeSet<>();
		
		
		//���Ͽ����ĳ����ķ���������
		//������㣺
//			���������������ص�:
//		    (1) 0^0=0,   0^1=1   0���κ�������κ���
//		    (2) 1^0=1,   1^1=0   1���κ������ =�κ���ȡ��
//		    (3) �κ�������Լ������Լ���0
//		 return Arrays.stream(a).reduce(0, (x, y) -> x ^ y);

	}
}
