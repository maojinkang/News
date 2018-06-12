package cn.mao.cnm.pojo;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

/**
 * 用户信息
 * @author otom3
 * @date 2018-03-15
 */
 @Table("user")
public class User  {
	/**
	 * 用户信息
	 */
	 @Name
	private java.lang.String uid;//学号
	 @Column
	private java.lang.String name;//姓名
	 @Column
	private java.lang.String pwd;//密码
	 @Column
	private java.lang.String bj;//班级
	 @Column
	private java.lang.String role;//角色
	public java.lang.String getUid(){
		return this.uid;
	}
	public void setUid(java.lang.String uid){
		this.uid	= uid;
	}
	public java.lang.String getName(){
		return this.name;
	}
	public void setName(java.lang.String name){
		this.name	= name;
	}
	public java.lang.String getPwd(){
		return this.pwd;
	}
	public void setPwd(java.lang.String pwd){
		this.pwd	= pwd;
	}
	public java.lang.String getBj(){
		return this.bj;
	}
	public void setBj(java.lang.String bj){
		this.bj	= bj;
	}
	public java.lang.String getRole(){
		return this.role;
	}
	public void setRole(java.lang.String role){
		this.role	= role;
	}
}