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

        //ƥ����ַ����У������Դ��ַ������濪ʼ����ƥ��
        List<Integer> result4 = t.findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"});
        System.out.println(result4.toString());

        //words�п������ظ���
        List<Integer> result5 = t.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"});
        System.out.println(result5.toString());

        //�ַ���s��һ����list���ַ������ȵ����������Դ���Ҫһ���ַ�һ���ַ����ƶ�
        List<Integer> result6 = t.findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[]{"fooo","barr","wing","ding","wing"});
        System.out.println(result6.toString());
    }
}