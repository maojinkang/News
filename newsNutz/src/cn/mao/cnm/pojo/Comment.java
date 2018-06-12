package cn.mao.cnm.pojo;

import java.util.Date;



public class Comment  {
	/**
	 * comment
	 */
	 
	private java.lang.Integer id;//id
	 
	private java.lang.Integer nid;//nid
	 
	private java.lang.String neirong;//neirong
	 
	private Date shijian;//shijian
	 
	private java.lang.String nicheng;//nicheng
	public java.lang.Integer getId(){
		return this.id;
	}
	public void setId(java.lang.Integer id){
		this.id	= id;
	}
	public java.lang.Integer getNid(){
		return this.nid;
	}
	public void setNid(java.lang.Integer nid){
		this.nid = nid;
	}
	public java.lang.String getNeirong(){
		return this.neirong;
	}
	public void setNeirong(java.lang.String neirong){
		this.neirong = neirong;
	}
	public Date getShijian(){
		return this.shijian;
	}
	public void setShijian(Date shijian){
		this.shijian = shijian;
	}
	public java.lang.String getNicheng(){
		return this.nicheng;
	}
	public void setNicheng(java.lang.String nicheng){
		this.nicheng	= nicheng;
	}
}