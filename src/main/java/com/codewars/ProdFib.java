package com.codewars;

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
		long a = 0;	//f(0)
		long b = 1;	//f(1);
		long tmp = a * b;
		while(prod > tmp){
			b = a + b;
			a = b - a;
			tmp = a * b;
		}
		return new long[]{a, b, tmp == prod ? 1 : 0};
	}
	
	/**
	 * ���⣺��ʼa,b���õ�int�ͣ�����ύ��ʱ��
	 * �²�ԭ��prod > int.maxʱ�� tmpΪint,����<int.max����prod����>tmp����ѭ��
	 */
}
