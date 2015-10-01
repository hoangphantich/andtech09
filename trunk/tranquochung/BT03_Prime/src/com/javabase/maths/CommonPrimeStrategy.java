package com.javabase.maths;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author hungtq
 *
 */
public class CommonPrimeStrategy implements PrimeStrategy {

	@Override
	public List<Integer> algorithm(Integer n) {
		// TODO Auto-generated method stub
		List<Integer> retsult = new ArrayList<Integer>();
		for (int i = 2; i <= n; i++) {
			if (checkPrime(i)) {
				retsult.add(i);
			}
		}
		return retsult;
	}
	
	/**
	 * Ham kiem tra so ngyen to
	 * @author hungtq
	 * @param n
	 * @return
	 */
	private boolean checkPrime(int n) {
		boolean result = true;
		//
		for (int i = 2; i <= n/2; i++) {
			if (n%i == 0) {
				result = false;
				break;	
			}
		}
		
		return result;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Common";
	}

}
