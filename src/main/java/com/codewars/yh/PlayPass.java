package com.codewars.yh;

public class PlayPass {
	public static String playPass(String s, int n) {
		// your code
		char[]	array = s.toCharArray();
		for(int i=0; i<array.length; i++){
			char c = array[i];
			if(Character.isLetter(c)){
				char newc = (char) (c + n > 'Z' ? c + n - 'Z' + 'A' - 1 : c + n);
				if(i % 2 == 0){
					array[i] = Character.toUpperCase(newc);
				}else{
					array[i] = Character.toLowerCase(newc);
				}
			}else if(Character.isDigit(c)){
				array[i] = Character.forDigit('9' - c, 10);
			}
		}
		
		return new StringBuilder().append(array).reverse().toString();
	}
}
