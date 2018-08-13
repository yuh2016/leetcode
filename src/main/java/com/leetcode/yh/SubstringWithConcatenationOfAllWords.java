package com.leetcode.yh;

import java.util.*;

/**
 *
 30. Substring with Concatenation of All Words
 Created by admin on 2018/8/13.
 You are given a string, s, and a list of words, words, that are all of the same length.
 Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once
 and without any intervening characters.

 �������û�������
 > �����ƥ�䣬��Ҫһ���ַ�һ���ַ�������
 > ƥ����ַ����У������Դ��ַ����е�ĳ�����ֿ�ʼ����ƥ��
 > words�п������ظ���

 ���������֮ǰ��ĳ���������񣬿��Ǹ�������ķ�ʽ����28�� ImplementStrStr
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
}
