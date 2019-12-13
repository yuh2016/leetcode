package com.codewars;

public class Conversion {
	
	/**
	 * 
Symbol    Value
I          1
V          5
X          10
L          50
C          100
D          500
M          1,000
	 * @param n
	 * @return
	 */
	public String solution(int n) {
		StringBuilder str = new StringBuilder();
		String[] simbols = {"M","CM","D","CD","C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		int tmp = n;
		for(int i=0; i<nums.length; i++){
			if(tmp - nums[i] >= 0){
				tmp -= nums[i];
				str.append(simbols[i]);
				i--;
			}else{
				continue;
			}
		}
        return str.toString();
    }
}
