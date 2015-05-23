package com.vo;

import java.sql.Timestamp;

/**
 * SUser entity. @author MyEclipse Persistence Tools
 */

public class SUser implements java.io.Serializable {

	// Fields

	private Integer uid;
	private Integer giD;
	private String uname;
	private String rname;
	private String pwd;
	private String position;
	private String mobile;
	private String email;
	private Timestamp creatTime;
	private String usrFlag;
	private Integer aid;

	// Constructors

	/** default constructor */
	public SUser() {
	}

	/** full constructor */
	public SUser(Integer giD, String uname, String rname, String pwd,
			String position, String mobile, String email, Timestamp creatTime,
			String usrFlag, Integer aid) {
		this.giD = giD;
		this.uname = uname;
		this.rname = rname;
		this.pwd = pwd;
		this.position = position;
		this.mobile = mobile;
		this.email = email;
		this.creatTime = creatTime;
		this.usrFlag = usrFlag;
		this.aid = aid;
	}

	// Property accessors

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getGiD() {
		return this.giD;
	}

	public void setGiD(Integer giD) {
		this.giD = giD;
	}

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getRname() {
		return this.rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getCreatTime() {
		return this.creatTime;
	}

	public void setCreatTime(Timestamp creatTime) {
		this.creatTime = creatTime;
	}

	public String getUsrFlag() {
		return this.usrFlag;
	}

	public void setUsrFlag(String usrFlag) {
		this.usrFlag = usrFlag;
	}

	public Integer getAid() {
		return this.aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

}