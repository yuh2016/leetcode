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
	 * 2, 3, 5是I里面的数包含的素数 2能被12整除，2是12的素数因子；3能被12整除，3也是12的素数因子 包含素数因子2的数之和是12，
	 * 包含素数因子3的数之和是12+15=27， 包含素数因子5的数之和是15 返回结果：(2 12)(3 27)(5 15)
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
		 判断一个数是否为素数，只需要判断到√x就行了
		 因为：如果x不是素数，那么一定有x = a * b，a和b必定一个大于√x，一个小于√x。
		 所以：只用判断到√x向下取整就行了，必定会有要给小于√x的数能够被x整除
		 */
		for (int i = 2; i < num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
	
	//网上的方法
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
