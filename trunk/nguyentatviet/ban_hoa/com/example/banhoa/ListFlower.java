package com.example.banhoa;

import java.util.ArrayList;

public class ListFlower {
	ArrayList<Flower> ListFlower = new ArrayList<Flower>();

	public void addKhachHang(Flower hoa) {
		ListFlower.add(hoa);
	}

	public int tongFlower() {
		return ListFlower.size();
	}
}
