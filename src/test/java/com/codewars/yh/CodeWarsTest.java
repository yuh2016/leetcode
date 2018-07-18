package com.codewars.yh;

import org.junit.Test;

import junit.framework.TestCase;

public class CodeWarsTest extends TestCase {
	private static CodeWars t = new CodeWars();
	
	@Test
    public void testSongDecoder() {
      assertEquals("ABC", t.SongDecoder("WUBWUBABCWUB"));
      assertEquals("R L", t.SongDecoder("RWUBWUBWUBLWUB"));
    }
}
