package com.codewars.yh;

import java.util.Set;
import java.util.stream.Collectors;

public class PangramChecker {
	
	/**
	 * A pangram is a sentence that contains every single letter of the alphabet at least once. For example, the sentence "The quick brown fox jumps over the lazy dog" is a pangram, because it uses the letters A-Z at least once (case is irrelevant).

Given a string, detect whether or not it is a pangram. Return True if it is, False if not. Ignore numbers and punctuation.
	 * @param sentence
	 * @return
	 */
	public boolean check(String sentence) {
		// code
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		Set<Character> set = alphabet.chars().mapToObj(c -> (char)c).collect(Collectors.toSet());
		sentence.toLowerCase().chars().mapToObj(c -> (char)c).forEach(c -> set.remove(c));
		
		return set.isEmpty();
	}
	/**
	 * 想复杂了。
	 * 直接比较每个字符，>a, <z就行了
	 */
	
	//简洁方法
	public boolean check2(String sentence) {
		//Character的工具方法很有用！！
//		Character.isAlphabetic(c)
//		Character.isLetter(c)
		// code
		return sentence.toLowerCase().chars().filter(e -> Character.isAlphabetic(e)).distinct().count() == 26;
	}
}
