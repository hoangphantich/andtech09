package com.hoangphan.tutor1102_nativesql.model;

import java.io.Serializable;

import android.content.ContentValues;

public class User implements Serializable {
	
	public int id;
	public String name;
	public int age;
	public int nationId;
	@Override
	public String toString() {
		return name;
	}
	public User(int id, String name, int age, int nationId) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.nationId = nationId;
	}
	public ContentValues toContentValue() {
		ContentValues v = new ContentValues();
		v.put("name", name);
		v.put("age", age);
		v.put("nationId", nationId);
		
		return v;
	}
}
