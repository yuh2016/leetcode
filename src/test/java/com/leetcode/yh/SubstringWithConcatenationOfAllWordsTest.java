package com.leetcode.yh;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by admin on 2018/8/13.
 */
public class SubstringWithConcatenationOfAllWordsTest {
    SubstringWithConcatenationOfAllWords t = new SubstringWithConcatenationOfAllWords();

    @Test
    public void testFindSubstring() throws Exception {
        List<Integer> result = t.findSubstring("barfoothefoobarman", new String[]{"foo","bar"});
        System.out.println(result.toString());

        List<Integer> result2 = t.findSubstring("wordgoodstudentgoodword", new String[]{"word","student"});
        System.out.println(result2.toString());


        List<Integer> result3 = t.findSubstring("barbarfoofoothefoobarman", new String[]{"foo","bar"});
        System.out.println(result3.toString());

        //匹配的字符串中，还可以从字符串后面开始继续匹配
        List<Integer> result4 = t.findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"});
        System.out.println(result4.toString());

        //words中可能有重复的
        List<Integer> result5 = t.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"});
        System.out.println(result5.toString());

        //字符串s不一定是list中字符串长度的整数，所以代码要一个字符一个字符的移动
        List<Integer> result6 = t.findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[]{"fooo","barr","wing","ding","wing"});
        System.out.println(result6.toString());
    }
}