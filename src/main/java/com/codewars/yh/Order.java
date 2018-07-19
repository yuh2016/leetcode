package com.codewars.yh;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Order {

	/**
Your task is to sort a given string. Each word in the String will contain a single number. This number is the position the word should have in the result.

Note: Numbers can be from 1 to 9. So 1 will be the first word (not 0).

If the input String is empty, return an empty String. The words in the input String will only contain valid consecutive numbers.

For an input: "is2 Thi1s T4est 3a" the function should return "Thi1s is2 3a T4est"

your_order("is2 Thi1s T4est 3a")
[1] "Thi1s is2 3a T4est"

	 * @param words
	 * @return
	 */
	public static String order(String words) {
		String[] strs = words.split(" ");
		String[] result = new String[strs.length];
		
		Pattern pattern = Pattern.compile("\\d{1}");
		for(String w : strs){
			Matcher matcher = pattern.matcher(w);
			if (matcher.find()) {
				result[Integer.parseInt(matcher.group()) - 1] = w;
			}
		}
		//sb了。。。
		//正则也可以匹配非数字呀。。。
		//String.join(" ", result);
		return Arrays.stream(result).reduce("", (x,y) -> (x == null ? "" : x) + " " + (y == null ? "" : y)).trim(); 
	}
	
	//大神的方法。。。
	public static String order2(String words){
		return Arrays.stream(words.split(" "))
		//第一个
		.sorted(Comparator.comparing(s -> Integer.valueOf(s.replaceAll("\\D", ""))))
//			.reduce((a, b) -> a + " " + b).get();
		//第二个
//			.sorted((a, b) -> {
//                return a.replaceAll("\\D+", "").compareTo(b.replaceAll("\\D+", ""));
//             })
		.collect(Collectors.joining(" "));
	}
}
