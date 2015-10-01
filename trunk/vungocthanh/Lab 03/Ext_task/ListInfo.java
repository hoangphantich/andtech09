package com.example.ext_task;

import java.io.Serializable;
import java.util.ArrayList;

public class ListInfo  implements Serializable{
	ArrayList<Information> myArray ;

	public ArrayList<Information> getMyArray() {
		return myArray;
	}

	public void setMyArray(ArrayList<Information> myArray) {
		this.myArray = myArray;
	}

	
}
