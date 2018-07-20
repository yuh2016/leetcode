package com.codewars.yh;

public class ProdFib {
	/**
	 * Fibonacci numbers: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, ...

	such as

	F(n) = F(n-1) + F(n-2) with F(0) = 0 and F(1) = 1.
	
	Given a number, say prod (for product), we search two Fibonacci numbers F(n) and F(n+1) verifying

F(n) * F(n+1) = prod.

Your function productFib takes an integer (prod) and returns an array:

[F(n), F(n+1), true] or {F(n), F(n+1), 1} or (F(n), F(n+1), True)
depending on the language if F(n) * F(n+1) = prod.

If you don't find two consecutive F(m) verifying F(m) * F(m+1) = prodyou will return

[F(m), F(m+1), false] or {F(n), F(n+1), 0} or (F(n), F(n+1), False)
F(m) being the smallest one such as F(m) * F(m+1) > prod.


Notes: Not useful here but we can tell how to choose the number n up to which to go: 
we can use the "golden ratio" phi which is (1 + sqrt(5))/2 
knowing that F(n) is asymptotic to: phi^n / sqrt(5). 
That gives a possible upper bound to n.
	 * @param prod
	 * @return
	 */
	public static long[] productFib(long prod) {
	    // your code
		int n = 0;
		int a = fib(n);
		int b = fib(n + 1);
		int tmp = a * b;
		while(prod > tmp){
			a = b;
			b = fib(++n + 1);
			tmp = a * b;
		}
		return new long[]{a, b, tmp == prod ? 1 : 0};
	}
	
	private static int fib(int n){
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return fib(n - 1) + fib(n - 2);
		}
	}
}
