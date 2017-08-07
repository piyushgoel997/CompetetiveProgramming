package NumberTheory;

import java.util.*;
import java.lang.*;

/**
 * HackerRank - https://www.hackerrank.com/challenges/closest-number
 * Correct
 */
class ClosestNumber {

	/**
	 * 	 Test case -
	 10
	 540385427 0 7
	 959 0 9
	 861022531 0 10
	 674 2 6
	 635724059 0 3
	 89021457 1 8
	 653379374 1 3
	 756899538 0 10
	 1 -734575199 1
	 1 973594325 1

	 Expected Output -
	 0
	 0
	 0
	 454278
	 0
	 89021456
	 653379375
	 0
	 1
	 1

	 */

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int i = 0; i < t; i++) {
			long ans = solve(s.nextLong(), s.nextLong(), s.nextLong());
			System.out.println(ans);
		}
	}

	private static long solve(long a, long b, long x) {
		long p = (long) Math.pow(a, b);
		if (p % x <= x / 2) {
			return (p - p % x);
		} else {
			return p + (x - p % x);
		}
	}

	private static long power(long a, long b) {
		long result = 1;
		for(long i = 0; i < b; i++) {
			result *= a;
		}
		return result;
	}
}