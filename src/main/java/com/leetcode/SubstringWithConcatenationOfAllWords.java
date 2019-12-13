package com.leetcode;

import java.util.*;

/**
 *
 30. Substring with Concatenation of All Words
 Created by admin on 2018/8/13.
 You are given a string, s, and a list of words, words, that are all of the same length.
 Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once
 and without any intervening characters.

 各种情况没考虑清楚
 > 如果不匹配，需要一个字符一个字符往后移
 > 匹配的字符串中，还可以从字符串中的某个部分开始继续匹配
 > words中可能有重复的

 这个方法跟之前的某个方法很像，考虑各种情况的方式很像。

 519ms，太慢了。

 */
public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        if(words.length == 0) return new ArrayList<Integer>();
        int len = words[0].length();
        List<Integer> result = new ArrayList<>();

        List<String> set = new ArrayList<>(Arrays.asList(words));
        int index = 0;
        String tmpStr = null;
        Integer tmpIndex = null;

        while(index < s.length()){
            int end = index + len > s.length() ? s.length() : index + len;
            tmpStr = s.substring(index, end);
            if(set.contains(tmpStr)){
                if(tmpIndex == null){
                    tmpIndex = index;
                }
                boolean flag = set.remove(tmpStr);
                if(!flag){
                    index = tmpIndex;
                    tmpIndex = null;
                    set = new ArrayList<>(Arrays.asList(words));
                    index ++;
                }else {
                    index += len;
                }
            }else if(tmpIndex != null && !set.contains(tmpStr)){
                if(set.isEmpty()) {
                    result.add(tmpIndex);
                    index = tmpIndex;
                    tmpIndex = null;
                    set = new ArrayList<>(Arrays.asList(words));
                }else{
                    index = tmpIndex;
                    tmpIndex = null;
                    set = new ArrayList<>(Arrays.asList(words));
                }
                index ++;
            }else if(tmpIndex == null && !set.contains(tmpStr)){
                index ++;
            }
        }

        if(tmpIndex != null && set.isEmpty()) result.add(tmpIndex);
        return result;
    }


    //大神的方法  13ms
    public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> l = new ArrayList<>();
        if (null == s || 0 == s.length() || null == words || 0 == words.length)
            return l;
        int sLen = s.length(), wLen = words[0].length(), wsLen = words.length;
        if (sLen < wLen * wsLen)
            return l;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < wsLen; i++) {
            map.put(words[i], map.containsKey(words[i]) ? map.get(words[i]) + 1 : 1);
        }

        for (int i = 0; i < wLen; i++) {
            int left = i, right = i, windows = 0;
            while (right + (wsLen - windows) * wLen <= sLen && right + wLen <= sLen) {
                String word = s.substring(right, right + wLen);
                if (map.containsKey(word)) {
                    int count = map.get(word);
                    windows++;
                    if (count > 0) {
                        map.put(word, count - 1);
                    } else {
                        String removed = s.substring(left, left + wLen);
                        while (!removed.equals(word)) {
                            map.put(removed, map.get(removed) + 1);
                            windows--;
                            left += wLen;
                            removed = s.substring(left, left + wLen);
                        }
                        windows--;
                        left += wLen;
                    }
                    if (windows == wsLen)
                        l.add(left);

                } else {
                    windows = 0;
                    while (left < right){
                        String removed = s.substring(left, left + wLen);
                        map.put(removed, map.get(removed) + 1);
                        left += wLen;
                    }
                    left += wLen;
                }
                right += wLen;
            }
            while (left < right) {
                String removed = s.substring(left, left + wLen);
                map.put(removed, map.get(removed) + 1);
                left += wLen;
            }
        }

        return l;
    }
}
