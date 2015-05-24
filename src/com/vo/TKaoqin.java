package com.vo;

import java.sql.Timestamp;

/**
 * TKaoqin entity. @author MyEclipse Persistence Tools
 */

public class TKaoqin implements java.io.Serializable {

	// Fields

	private Integer kid;
	private Integer uid;
	private String kd;
	private String kt;
	private Timestamp kqdate;
	private String exp01;
	private Integer spuid;
	private String spCtnt;
	private Timestamp spdate;

	// Constructors

	/** default constructor */
	public TKaoqin() {
	}

	/** minimal constructor */
	public TKaoqin(String kd) {
		this.kd = kd;
	}

	/** full constructor */
	public TKaoqin(Integer uid, String kd, String kt, Timestamp kqdate,
			String exp01, Integer spuid, String spCtnt, Timestamp spdate) {
		this.uid = uid;
		this.kd = kd;
		this.kt = kt;
		this.kqdate = kqdate;
		this.exp01 = exp01;
		this.spuid = spuid;
		this.spCtnt = spCtnt;
		this.spdate = spdate;
	}

	// Property accessors

	public Integer getKid() {
		return this.kid;
	}

	public void setKid(Integer kid) {
		this.kid = kid;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getKd() {
		return this.kd;
	}

	public void setKd(String kd) {
		this.kd = kd;
	}

	public String getKt() {
		return this.kt;
	}

	public void setKt(String kt) {
		this.kt = kt;
	}

	public Timestamp getKqdate() {
		return this.kqdate;
	}

	public void setKqdate(Timestamp kqdate) {
		this.kqdate = kqdate;
	}

	public String getExp01() {
		return this.exp01;
	}

	public void setExp01(String exp01) {
		this.exp01 = exp01;
	}

	public Integer getSpuid() {
		return this.spuid;
	}

	public void setSpuid(Integer spuid) {
		this.spuid = spuid;
	}

	public String getSpCtnt() {
		return this.spCtnt;
	}

	public void setSpCtnt(String spCtnt) {
		this.spCtnt = spCtnt;
	}

	public Timestamp getSpdate() {
		return this.spdate;
	}

	public void setSpdate(Timestamp spdate) {
		this.spdate = spdate;
	}

}