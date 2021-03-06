package com.leetcode;

/**
 * Created by admin on 2018/8/8.
 *
 28. Implement strStr()
 Implement strStr().

 Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 Input: haystack = "hello", needle = "ll"
 Output: 2
 */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.trim().length() == 0) return 0;
        if(haystack == null || haystack.trim().length() == 0) return -1;
        char[] array = haystack.toCharArray();
        int i =0;
        int index = 0;
        int tmp = -1;
        while(i < array.length && index < needle.length()){
            if(tmp != -1){
                if(array[i] == needle.charAt(index)) {
                    index++;
                }else{
                    tmp = -1;
                    i -= index;
                    index = 0;
                }
            }else{
                if(array[i] == needle.charAt(index)) {
                    tmp = i;
                    index ++;
                }
            }
            i++;
        }
        if(index != needle.length()) return -1;
        return tmp;
    }
}
