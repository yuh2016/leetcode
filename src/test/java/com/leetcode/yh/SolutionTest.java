package com.leetcode.yh;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {
	private static Solution t = new Solution();
	
	@Test
	public void testFindMedianSortedArrays(){
		int[] nums1 = new int[]{1, 3};
		int[] nums2 = new int[]{2};
		double result1 = t.findMedianSortedArrays(nums1, nums2);
		assertEquals(result1, 2.0);
		
		int[] nums3 = new int[]{1, 2};
		int[] nums4 = new int[] {3, 4};
		double result2 = t.findMedianSortedArrays(nums3, nums4);
		assertEquals(result2, 2.5);
	}
	
	@Test
	public void testLongestPalindrome(){
		String s1 = "babad";
		String result1 = t.longestPalindrome(s1);
		assertTrue("aba".equals(result1) || "bab".equals(result1));
		
		String s2 = "cbbd";
		String result2 = t.longestPalindrome(s2);
		assertEquals("bb", result2);
		
		String s3 = "d";
		String result3 = t.longestPalindrome(s3);
		assertEquals("d", result3);
		
		String s4 = "rgczcpratwyqxaszbuwwcadruayhasynuxnakpmsyhxzlnxmdtsqqlmwnbxvmgvllafrpmlfuqpbhjddmhmbcgmlyeypkfpreddyencsdmgxysctpubvgeedhurvizgqxclhpfrvxggrowaynrtuwvvvwnqlowdihtrdzjffrgoeqivnprdnpvfjuhycpfydjcpfcnkpyujljiesmuxhtizzvwhvpqylvcirwqsmpptyhcqybstsfgjadicwzycswwmpluvzqdvnhkcofptqrzgjqtbvbdxylrylinspncrkxclykccbwridpqckstxdjawvziucrswpsfmisqiozworibeycuarcidbljslwbalcemgymnsxfziattdylrulwrybzztoxhevsdnvvljfzzrgcmagshucoalfiuapgzpqgjjgqsmcvtdsvehewrvtkeqwgmatqdpwlayjcxcavjmgpdyklrjcqvxjqbjucfubgmgpkfdxznkhcejscymuildfnuxwmuklntnyycdcscioimenaeohgpbcpogyifcsatfxeslstkjclauqmywacizyapxlgtcchlxkvygzeucwalhvhbwkvbceqajstxzzppcxoanhyfkgwaelsfdeeviqogjpresnoacegfeejyychabkhszcokdxpaqrprwfdahjqkfptwpeykgumyemgkccynxuvbdpjlrbgqtcqulxodurugofuwzudnhgxdrbbxtrvdnlodyhsifvyspejenpdckevzqrexplpcqtwtxlimfrsjumiygqeemhihcxyngsemcolrnlyhqlbqbcestadoxtrdvcgucntjnfavylip";
		String result4 = t.longestPalindrome(s4);
		assertEquals("qgjjgq", result4);
	}

	@Test
	public void testConvert(){
		String result1 = t.convert("PAYPALISHIRING", 3);
		assertEquals(result1, "PAHNAPLSIIGYIR");
	}
	
	@Test
	public void testReverseInteger(){
//		int result1 = t.reverseInteger(2345);
//		assertEquals(result1, 5432);
//		
//		int result2 = t.reverseInteger(57611);
//		assertEquals(result2, 11675);
//		
//		int result3 = t.reverseInteger(0);
//		assertEquals(result3, 0);
//		
//		int result4 = t.reverseInteger(120);
//		assertEquals(result4, 21);
//		
//		int result5 = t.reverseInteger(1534236469);
//		assertEquals(result5, 0);
		
		int result6 = t.reverseInteger(-132);
		assertEquals(result6, -231);
	}
	
	@Test
	public void testIsPalindrome(){
		boolean result1 = t.isPalindrome(2345432);
		assertEquals(result1, true);
		
		boolean result2 = t.isPalindrome(12343);
		assertEquals(result2, false);
		
		boolean result3 = t.isPalindrome(-1234321);
		assertEquals(result3, false);
		
		boolean result4 = t.isPalindrome(-2147447412);
		assertEquals(result4, false);
	}
	
	@Test
	public void testMyAtoi(){
		int result1 = t.myAtoi(" +567uj ");
		assertEquals(result1, 567);
		
		int result2 = t.myAtoi(" -567uj ");
		assertEquals(result2, -567);
		
		int result3 = t.myAtoi("  567+-uj ");
		assertEquals(result3, 567);
		
		int result4 = t.myAtoi("  +87654321243456688uj ");
		assertEquals(result4, Integer.MAX_VALUE);
		
		int result5 = t.myAtoi("juyh +uj ");
		assertEquals(result5, 0);
		
		int result6 = t.myAtoi("9223372036854775809");
		assertEquals(result6, Integer.MAX_VALUE);
		
		int result7 = t.myAtoi("-9223372036854775809");
		assertEquals(result7, Integer.MIN_VALUE);
	}
	
	@Test
	public void testMaxArea(){
		int[] height1 = {2,1,3,5};
		int maxArea1 = t.maxArea(height1);
		assertEquals(maxArea1, 6);
		
		int[] height2 = {1,2,4,3};
		int maxArea2 = t.maxArea(height2);
		assertEquals(maxArea2, 4);
	}
	
	@Test
	public void testMaxArea2(){
		int[] height = new int[15000];
		for(int i = 15000; i > 0; i--){
			height[15000 - i] = i;
		}
		int maxArea = t.maxArea(height);
		System.out.println(maxArea);
//		assertEquals(maxArea, 4);
	}
	
	@Test
	public void testIntToRoman(){
		int num = 3;
		String result = t.intToRoman(num);
		assertEquals(result, "III");
		
		int num1 = 4;
		String result1 = t.intToRoman(num1);
		assertEquals(result1, "IV");
		
		int num2 = 9;
		String result2 = t.intToRoman(num2);
		assertEquals(result2, "IX");
		
		int num3 = 58;
		String result3 = t.intToRoman(num3);
		assertEquals(result3, "LVIII");
		
		int num4 = 1994;
		String result4 = t.intToRoman(num4);
		assertEquals(result4, "MCMXCIV");
	}
	
	@Test
	public void testRomanToInt(){
		String s = "III";
		int result = t.romanToInt(s);
		assertEquals(result, 3);
		
		String s1 = "IV";
		int result1 = t.romanToInt(s1);
		assertEquals(result1, 4);
		
		String s2 = "IX";
		int result2 = t.romanToInt(s2);
		assertEquals(result2, 9);
		
		String s3 = "LVIII";
		int result3 = t.romanToInt(s3);
		assertEquals(result3, 58);
		
		String s4 = "MCMXCIV";
		int result4 = t.romanToInt(s4);
		assertEquals(result4, 1994);
	}
	
	@Test
	public void testLongestCommonPrefix(){
		String[] strs = {"flower","flow","flight"};
		String prefix = t.longestCommonPrefix(strs);
		assertEquals(prefix, "fl");
		
		String[] strs1 = {"dog","racecar","car"};
		String prefix1 = t.longestCommonPrefix(strs1);
		assertEquals(prefix1, "");
		
		String[] strs2 = {"flower"};
		String prefix2 = t.longestCommonPrefix(strs2);
		assertEquals(prefix2, "flower");
		
	}
	

	@Test
	public void testLetterCombinations(){
		String str = "23";
		List<String> result = t.letterCombinations(str);
		assertEquals(result, Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"));
	}
}
