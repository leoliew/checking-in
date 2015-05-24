package com.vo;

/**
 * SWorkgroup entity. @author MyEclipse Persistence Tools
 */

public class SWorkgroup implements java.io.Serializable {

	// Fields

	private Integer giD;
	private String groupname;

	// Constructors

	/** default constructor */
	public SWorkgroup() {
	}

	/** full constructor */
	public SWorkgroup(String groupname) {
		this.groupname = groupname;
	}

	// Property accessors

	public Integer getGiD() {
		return this.giD;
	}

	public void setGiD(Integer giD) {
		this.giD = giD;
	}

	public String getGroupname() {
		return this.groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

}