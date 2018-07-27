package com.codewars.yh;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

//5 kyu
public class WeightSort {
	public static String orderWeight(String string) {
		// your code
		if(string.trim().length() == 0){
			return "";
		}
		String[] strArray = string.split("\\s+");
		
		return Arrays.stream(strArray).sorted(new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				int a = o1.chars().map(ch -> Character.getNumericValue(ch)).sum();
				int b = o2.chars().map(ch -> Character.getNumericValue(ch)).sum();
				if(a < b) return -1;
				else if(a > b) return 1;
				
				//字符串比较可以用a.compareTo(b) 。。。。
				//而且这里比较的方法也写的很罗嗦
				else {
					for(int i=0; i<o1.length(); i++){
						char c1 = o1.charAt(i);
						if(i > o2.length() - 1){
							return 1;
						}
						char c2 = o2.charAt(i);
						if(c1 > c2) return 1;
						else if(c1 == c2) continue;
						else if(c1 < c2) return -1;
					}
					if(o1.length() < o2.length()){
						return -1;
					}else {
						return 0;
					}
					
				}
			}
		}).reduce((a, b) -> a + " " + b).get();
	}
	
	/**
	 * 最高赞
	 * 
	 * 字符串比较可以用a.compareTo(b)
	 * 
	 */
	public static String orderWeight2(String string) {
		String[] split = string.split(" ");
		Arrays.sort(split, new Comparator<String>() {
			public int compare(String a, String b) {
				int aWeight = a.chars().map(c -> Character.getNumericValue(c)).sum();
				int bWeight = b.chars().map(c -> Character.getNumericValue(c)).sum();
				return aWeight - bWeight != 0 ? aWeight - bWeight : a.compareTo(b);
			}
		});
		return String.join(" ", split);
	}
	
	//java 方法改写
	public int compareTo(String value, String anotherString) {
        int len1 = value.length();
        int len2 = anotherString.length();
        int lim = Math.min(len1, len2);
        char v1[] = value.toCharArray();
        char v2[] = anotherString.toCharArray();

        int k = 0;
        while (k < lim) {
            char c1 = v1[k];
            char c2 = v2[k];
            if (c1 != c2) {
                return c1 - c2;
            }
            k++;
        }
        return len1 - len2;
    }
	
	//另一个大神的方法
	public static String orderWeight3(String strng) {
	    return
	      Arrays.stream(strng.split(" "))
	        .sorted(Comparator
	          .comparing(WeightSort::sumDigits)
	          .thenComparing(String::compareTo))
	        .collect(Collectors.joining(" "));
	        
	  }

	  private static Integer sumDigits(String s) {
	    return s.chars().map(c -> c - 48).sum();
	  }
}
