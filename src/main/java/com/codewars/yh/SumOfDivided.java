package com.codewars.yh;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SumOfDivided {
	/**
	 * I = {12, 15}; // result = "(2 12)(3 27)(5 15)"
	 * 
	 * 2, 3, 5��I����������������� 2�ܱ�12������2��12���������ӣ�3�ܱ�12������3Ҳ��12���������� ������������2����֮����12��
	 * ������������3����֮����12+15=27�� ������������5����֮����15 ���ؽ����(2 12)(3 27)(5 15)
	 * 
	 * 
	 * Given an array of positive or negative integers
	 * 
	 * I= [i1,..,in]
	 * 
	 * you have to produce a sorted array P of the form
	 * 
	 * [ [p, sum of all ij of I for which p is a prime factor (p positive) of
	 * ij] ...]
	 * 
	 * P will be sorted by increasing order of the prime numbers. The final
	 * result has to be given as a string in Java, C#, C, C++ and as an array of
	 * arrays in other languages.
	 * 
	 * @param l
	 * @return
	 */

	public static String sumOfDivided(int[] l) {
		Arrays.sort(l);

		Set<Integer> set = new TreeSet<>();
		for (int i = 2; i < l[l.length - 1]; i++) {
			if (isPrime(i)) {
				set.add(i);
			}
		}

		TreeMap<Integer, Integer> map = new TreeMap<>();
		set.stream().forEach(prime -> {
			Arrays.stream(l).forEach(num -> {
				if (num % prime == 0) {
					map.put(prime, map.containsKey(prime) ? map.get(prime) + num : num);
				}
			});
		});
		
		return map.entrySet().stream().map(entry -> "(" + entry.getKey() + " " + entry.getValue() + ")").reduce((a,b) -> a + b).get();
	}

	public static boolean isPrime(int num) {
		//int maxCheck = (int) Math.ceil(Math.sqrt(n));
		//i < maxCheck
		/*
		 �ж�һ�����Ƿ�Ϊ������ֻ��Ҫ�жϵ���x������
		 ��Ϊ�����x������������ôһ����x = a * b��a��b�ض�һ�����ڡ�x��һ��С�ڡ�x��
		 ���ԣ�ֻ���жϵ���x����ȡ�������ˣ��ض�����Ҫ��С�ڡ�x�����ܹ���x����
		 */
		for (int i = 2; i < num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
	
	//���ϵķ���
	public static String sumOfDivided2(int[] l) {
        final int maxValue = Arrays.stream(l).map(num -> Math.abs(num)).max().getAsInt();
        return eratosteneSieve(maxValue).stream()
                .reduce("",
                        (resultString, primeNum) -> {
                            List<Integer> divisibleNum = Arrays.stream(l).filter(num -> num % primeNum == 0).boxed().collect(Collectors.toList());
                            return divisibleNum.size() > 0
                                    ? resultString + String.format("(%d %d)", primeNum, divisibleNum.stream().mapToInt(Integer::intValue).sum())
                                    : resultString;
                        },
                        (not, used) -> null);
    }

    public static List<Integer> eratosteneSieve(final int x) {
        final List<Integer> candidates = IntStream.rangeClosed(2, x).boxed().collect(Collectors.toList());
        return candidates.stream()
                .filter(num -> num <= Math.sqrt(x))
                .reduce(candidates,
                        (resList, currNum) -> resList.stream()
                        .filter(num -> num % currNum != 0 || num.equals(currNum))
                        .collect(Collectors.toList()),
                        (not, used) -> null);
    }
}
