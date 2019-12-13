package com.codewars;

import static org.junit.Assert.*;

import org.junit.Test;


public class ProdFibTest {

	@Test
	public void test1() {
		long[] r = new long[] {55, 89, 1};
		assertArrayEquals(r, ProdFib.productFib(4895));
	}
	@Test
	public void test2() {
		long[] r = new long[] {89, 144, 0};
		assertArrayEquals(r, ProdFib.productFib(5895));
	}
	@Test
	public void test3() {
		long[] test = ProdFib.productFib(998876545665545555L);
		for(int i=0; i<test.length; i++){
			System.out.println(test[i]);
		}
	}
}
