package com.codewars.yh;

import org.junit.Test;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {
	private static Solution t = new Solution();
	
	@Test
    public void testSongDecoder() {
      assertEquals("ABC", t.SongDecoder("WUBWUBABCWUB"));
      assertEquals("R L", t.SongDecoder("RWUBWUBWUBLWUB"));
    }
}
