package com.codewars.yh;

import java.util.HashMap;

public class CodeWars {
	public static String SongDecoder(String song) {
		// Your code is here...
		String initial = song.replaceAll("WUB", " ");
		String str = initial.trim();
		char[] result = new char[str.length()];
		int index = -1;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == ' ' && index >= 0 && result[index] == ' ') {
				continue;
			}
			index++;
			result[index] = c;
		}
		return new String(result).trim();
	}
	
	//strings passed in will consist of only letters and spaces. Spaces will be included only when more than one word is present.
	
	public String spinWords(String sentence) {
		String[] words = sentence.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < words.length; i++) {
			if (words[i].length() >= 5) {
				words[i] = reverse(words[i]);
			}
			sb.append(words[i]);
		}
		return sb.toString();
	}
	
	public String reverse(String str){
		int len = str.length();
		char[]	chs = str.toCharArray();
		char[] strs = new char[len];
		for(int i = len-1; i>=0; i--){
			strs[len - i - 1] = chs[i];
		}
		return new String(strs);
	}
}
