package cn.mao.cnm.pojo;

import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * news
 * @author otom3
 * @date 2018-04-03
 */
 @Table("news")
public class News  {
	/**
	 * news
	 */
	 @Id
	private java.lang.Integer id;//����id
	 @Column
	private java.lang.String title;//����
	 @Column
	private java.lang.String content;//����
	 @Column
	private Date tjdate;//����ʱ��
	 @Column
	private java.lang.String cruser;//������
	 @Column
	private java.lang.Integer hitnum;//�����
	public java.lang.Integer getId(){
		return this.id;
	}
	public void setId(java.lang.Integer id){
		this.id	= id;
	}
	public java.lang.String getTitle(){
		return this.title;
	}
	public void setTitle(java.lang.String title){
		this.title	= title;
	}
	public java.lang.String getContent(){
		return this.content;
	}
	public void setContent(java.lang.String content){
		this.content	= content;
	}
	public Date getTjdate(){
		return this.tjdate;
	}
	public void setTjdate(Date tjdate){
		this.tjdate	= tjdate;
	}
	public java.lang.String getCruser(){
		return this.cruser;
	}
	public void setCruser(java.lang.String cruser){
		this.cruser	= cruser;
	}
	public java.lang.Integer getHitnum(){
		return this.hitnum;
	}
	public void setHitnum(java.lang.Integer hitnum){
		this.hitnum	= hitnum;
	}
}