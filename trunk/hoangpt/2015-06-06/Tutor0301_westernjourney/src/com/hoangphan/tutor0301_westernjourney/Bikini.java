package com.hoangphan.tutor0301_westernjourney;

import java.io.Serializable;

public class Bikini implements Serializable {
	String type = "Victoria";

	@Override
	public String toString() {
		return type;
	}
}
