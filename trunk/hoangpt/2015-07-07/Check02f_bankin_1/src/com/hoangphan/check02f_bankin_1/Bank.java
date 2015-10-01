package com.hoangphan.check02f_bankin_1;

import java.util.ArrayList;

public class Bank {
	
	long money;
	int nrMonth;
	float interest;
	
	public Bank(long money, int nrMonth) {
		this.money = money;
		this.nrMonth = nrMonth;
		setInterest();
	}

	void setInterest(){
		//check money > 1B 10%; < 1B 8%
		float i1 = 0.08f;
		if(money > 1000000) {
			i1 = 0.1f;
		}
		
		//check nr month
		float i2 = 0.06f;
		if(nrMonth>36){
			i2 = 0.12f;
		} else if(nrMonth>12) {
			i2 = 0.09f;
		} else {
			i2 = 0.06f;
		}
		
		interest = (i1>i2)?i1:i2;
	}
	
	ArrayList<String> getHardcodeListMoney(){
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < 12; i++) {
			list.add("T"+(1+i)+": "+1000*i);
		}
		
		return list;
	}
	
	ArrayList<String> getListMoney(){
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < 12; i++) {
			double total = money*Math.pow(1+interest/12, (i+1));
			list.add("T"+(1+i)+": "+total);
		}
		
		return list;
	}
}
