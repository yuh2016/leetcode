package com.leetcode.yh;

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
}
