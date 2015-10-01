package com.javabase.maths;

import java.util.ArrayList;
import java.util.List;

public class EratosPrimeStrategy implements PrimeStrategy {

	@Override
	public List<Integer> algorithm (Integer n) {
		// TODO Auto-generated method stub
		boolean[] a = new boolean[n+1];
		a[0] = false;
		a[1] = false;
		for (int k = 2; k <= n; k++) {
			a[k] = true;
		}
		
		for (int k = 2; k <= n/2; k++) {
			for (int l = 2; l <= n/k; l++) {
				a[l*k] = false;
			}
		}
		List<Integer> ret_val = new ArrayList<Integer>();
		for (int k = 1; k <= n; k++) {
			if (a[k]) {
				ret_val.add(k);
			}
		}
		
		return ret_val;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Eratosthenes";
	}

}
