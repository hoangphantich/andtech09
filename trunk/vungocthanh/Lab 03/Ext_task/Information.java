package com.example.ext_task;

import java.io.Serializable;

public class Information implements Serializable{
	private String work;
	private int hour;
	private int minute;
	private int second;
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		this.second = second;
	}
	
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	
	
	public String print() {
		return this.work + "\n" + this.hour + ":" + this.minute + ":" + this.second;
	}
	
	public String show() {
		return this.hour + ":" + this.minute + ":" + this.second + " - " + this.work + "\n";
	}
}
