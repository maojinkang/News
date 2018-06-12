package cn.mao.cnm.bean;

import javax.persistence.Entity;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
public class User implements java.io.Serializable {

	// Fields

	private String uid;
	private String name;
	private String pwd;
	private String bj;
	private String role;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String uid, String name, String pwd, String bj, String role) {
		this.uid = uid;
		this.name = name;
		this.pwd = pwd;
		this.bj = bj;
		this.role = role;
	}

	// Property accessors

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getBj() {
		return this.bj;
	}

	public void setBj(String bj) {
		this.bj = bj;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}