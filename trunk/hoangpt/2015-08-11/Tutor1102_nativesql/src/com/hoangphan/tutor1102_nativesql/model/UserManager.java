package com.hoangphan.tutor1102_nativesql.model;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UserManager {
	
	SQLiteDatabase db;
	
	public UserManager(SQLiteDatabase db) {
		this.db = db; 
	}

	public void addUser(User user){
		//using helper
		ContentValues values = user.toContentValue();
		db.insert("user", null, values);
	}
	
	public void updateUser(User user){
		ContentValues values = user.toContentValue();
		db.update("user", values, "id=?", new String[] {""+user.id} );
	}
	
	public User findUser(int id){
		String sql = "SELECT * FROM user WHERE id="+id;
		Cursor cursor = db.rawQuery(sql, null);
		
		//build user
		cursor.moveToNext();
		String name = cursor.getString(cursor.getColumnIndex("name"));
		int age = Integer.parseInt(cursor.getString(cursor.getColumnIndex("age")));
		int nationId = Integer.parseInt(cursor.getString(cursor.getColumnIndex("nationId")));
	
		User user = new User(id, name, age, nationId); //mapping
		return user;
	}
	
	public List<User> listUser(){
		ArrayList<User> users = new ArrayList<>();
		String sql = "SELECT * FROM user";
		Cursor cursor = db.rawQuery(sql, null);
		
		//build user
		while (cursor.moveToNext()) {
			int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
			String name = cursor.getString(cursor.getColumnIndex("name"));
			int age = Integer.parseInt(cursor.getString(cursor.getColumnIndex("age")));
			int nationId = Integer.parseInt(cursor.getString(cursor.getColumnIndex("nationId")));
		
			User user = new User(id, name, age, nationId);
			users.add(user);
		}

		return users;
	}

}
