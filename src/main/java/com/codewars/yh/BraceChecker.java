package com.codewars.yh;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BraceChecker {
	public boolean isValid(String braces) {
		Map<Character, Character> braceMap = new HashMap<>();
		braceMap.put('[', ']');
		braceMap.put('(', ')');
		braceMap.put('{', '}');

		Stack<Character> stack = new Stack<>();
		for (char c : braces.toCharArray()) {
			if (braceMap.containsKey(c)) {
				stack.push(braceMap.get(c));
			} else {
				if (stack.isEmpty())
					return false;
				char ch = stack.pop();
				if (ch != c) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	//clever methos
	public boolean isValid2(String s) {
	    String lastIteration = s;
	    String currentIteration = s;
	    do {
	        lastIteration = currentIteration;
	        currentIteration = lastIteration.replace("[]" , "").replace("{}", "").replace("()" , "");
	    } while(currentIteration.length() < lastIteration.length());
	    return currentIteration.equals("");
	  }

}
