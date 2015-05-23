package com.vo;

/**
 * SActor entity. @author MyEclipse Persistence Tools
 */

public class SActor implements java.io.Serializable {

	// Fields

	private Integer aid;
	private String aname;

	// Constructors

	/** default constructor */
	public SActor() {
	}

	/** full constructor */
	public SActor(String aname) {
		this.aname = aname;
	}

	// Property accessors

	public Integer getAid() {
		return this.aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public String getAname() {
		return this.aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

}