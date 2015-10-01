package com.hoangphan.check03g_resfinder.service;

import java.util.HashMap;
import java.util.Hashtable;

public class MockDataService {
	
	Hashtable<City, HashMap<Integer, District>> datas = new Hashtable<>();
	
	Hashtable<City, HashMap<Integer, District>> getData(){
		Hashtable<City, HashMap<Integer, District>> datas = new Hashtable<City, HashMap<Integer, District>>();
		City hanoi = new City("Hanoi");
		
		HashMap<Integer, District> districs = new HashMap<>();
		District dongda = new District(1, "Dongda"); //bean
		districs.put(1, dongda);
		
		
		datas.put(hanoi, districs);
		
		return datas;
	}

}
