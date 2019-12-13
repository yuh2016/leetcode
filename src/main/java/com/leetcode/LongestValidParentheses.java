package com.leetcode;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        char[] strs = s.toCharArray();

        int tmp = 0;
        int max = 0;
        boolean flag = false;
        Stack<Character> stack = new Stack<>();
        for (char c : strs) {
            if(c == ')' && !stack.isEmpty() && stack.peek().equals('(')){
                stack.pop();
                tmp += 2;
                flag = true;
            }else if (c == '('){
                stack.push(c);
            }else if (c == ')'){
                max = tmp;
                tmp = 0;
            } else{
                System.out.println("²ÎÊý´íÎó");
            }
        }
        if(tmp > max){
            max = tmp;
        }
        return max;
    }

    public int longestValid(String str) {
        String tmpStr = str.replaceAll("\\(\\)", "00");
//        String tmpStr = str;
        String pattern = "\\([0]*\\)";
        Pattern r = Pattern.compile(pattern);
        boolean flag = Pattern.matches(pattern, tmpStr);
        while (Pattern.matches(pattern, tmpStr)) {
            Matcher m = r.matcher(tmpStr);
            while (m.find()) {
                String s = m.group();
                String tmpS = s.replaceAll("\\(", "0").replaceAll("\\)", "0");
                tmpStr = tmpStr.replaceAll(s, tmpS);
            }
        }

        char[] chars = tmpStr.toCharArray();
        int tmp = 0, max = 0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '0'){
                tmp ++;
            }else{
                if (max < tmp) {
                    max = tmp;
                }
                tmp = 0;
            }
        }
        if (max < tmp) {
            max = tmp;
        }
        return max;
    }

    public int longestValid2(String str) {
        if (str.length() <= 1) {
            return 0;
        }
        char[] chars = str.toCharArray();
        int left = 0, right = 1;
        for (int i = 0, j = 0; i < chars.length - 1 && j < chars.length; ) {
            char m = chars[i];
            char n = chars[j];
            if (m == '(' && n == ')') {
                chars[m] = '0';
                chars[n] = '0';
                m += 2;
                n += 2;
            }
        }
        return 0;
    }
}
