package com.codewars.yh;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

public class ParseMolecule {
	//"H2O"  return [H: 2, O: 1]
	//"Mg(OH)2"  return ["Mg": 1, "O": 2, "H": 2]
	//"K4[ON(SO3)2]2"  return ["K": 4, "O": 14, "N": 2, "S": 4]
	// throw an IllegalArgumentException
	//C6H12O6
	//Au5(C2H5[OH)3Li]3	//wrong formula
	//Mg(OH]2
	public static Map<String,Integer> getAtoms(String formula) {
		formula.toLowerCase();
		
		
        // Your code here!
		String reverse = new StringBuilder(formula).reverse().toString();
		Map<String, Integer> result = new HashMap<>();
		
		Stack<Character> multiStack = new Stack<>();
		Stack<Integer> onceStack = new Stack<>();
		int multi = 1;
		int i = 0;
		StringBuilder tmp = new StringBuilder();
		Map<Character, Character> charMap = new HashMap<>();
		charMap.put(']', '[');
		charMap.put(')', '(');
		charMap.put('}', '{');
		while(i < reverse.length()){
			char c = reverse.charAt(i);
			if(Character.isDigit(c)){
				int cnt  =  Character.getNumericValue(c);
				
				if(i - 1 >= 0){
					char preCh = reverse.charAt(i - 1);
					if(Character.isDigit(preCh)){
						cnt = cnt * 10 + Character.getNumericValue(preCh);
					}
				}
				
				char nextCh = reverse.charAt(i + 1);
				//如果数字下一个字母是括号，则放入multiStack
				if(nextCh == ']' || nextCh == ')' || nextCh == '}'){
					multiStack.push(c);
					multiStack.push(charMap.get(nextCh));
					multi *= cnt;
				}else if(Character.isLetter(nextCh)){
					onceStack.push(cnt);
				}
			}else if(Character.isUpperCase(c)){
				//如果是大写字母，则统计之前的tmp
				tmp.append(c);
				tmp.reverse();
				String str = tmp.toString();
				int once = 1;
				if(!onceStack.isEmpty()){
					once = onceStack.pop();
				}
				if(result.containsKey(str)){
					result.put(str, result.get(str) + multi * once);
				}else{
					result.put(str, multi * once);
				}
				
				tmp = new StringBuilder();
				if(i + 1 < reverse.length()){
					char nextCh = reverse.charAt(i + 1);
					if(nextCh == ']' || nextCh == ')' || nextCh == '}'){
						multiStack.push('1');
						multiStack.push(charMap.get(nextCh));
					}
				}
			}else if(Character.isLowerCase(c)){
				tmp.append(c);
			}else if(c == '[' || c == '(' || c == '{'){
				if(multiStack.isEmpty()){
					throw new IllegalArgumentException();
				}
				char left = multiStack.pop();
				if(left != c){
					throw new IllegalArgumentException();
				}
				char charCnt = multiStack.pop();
				multi /= Character.getNumericValue(charCnt);
			}
			i++;
		}
		
		if(!multiStack.isEmpty()){
			throw new IllegalArgumentException();
		}
        
        return result;
    }
	
	
	public Map<String, Integer> getAtoms2(String formula){
		int i=0;
		StringBuilder tmp = null;
		int cnt = 1;
		HashMap<String, Integer> map = new HashMap<>();
		while(i < formula.length()){
			char c = formula.charAt(i);
			if(Character.isUpperCase(c)){
				if(tmp != null){
					String str = tmp.toString();
					map.put(str, map.containsKey(str) ? map.get(str) + cnt : cnt);
				}
				tmp = new StringBuilder();
				tmp.append(c);
			}else if(Character.isLowerCase(c)){
				tmp.append(c);
			}else if(Character.isDigit(c)){
				cnt = c;
			}else if(c == '(' || c == '{' || c == '['){
				
			}
		}
		return null;
	}
	
	public Map<String, Integer> multiAtoms(Map<String, Integer> map, int cnt){
		Map<String, Integer> result = new HashMap<>();
		for(Entry<String, Integer> entry : map.entrySet()){
			int total = entry.getValue();
			result.put(entry.getKey(), total * cnt);
		}
		return result;
	}
}
