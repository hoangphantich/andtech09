package com.javabase.dao;

/**
 * 
 * @author hungtq
 * @date 15/03/2015
 *
 */
public class Discipline {
	/** Ten mon hoc */
	private String name = null;
	/** Ma mon hoc	*/
	private String code = null;
	/** Diem mon hoc */
	private float  point = 0;
	/** Hoc ky	*/
	
	
	public void setName (String name) {
		this.name = name;
	}
	
	public String getName () {
		return this.name;
	}
	
	public void setPoint (float point) {
		this.point = point;
	}
	
	public float getPoint () {
		return this.point;
	}
	
	public void setCode (String code) {
		this.code = code;
	}
	
	public String getCode () {
		return this.code;
	}
	
}
