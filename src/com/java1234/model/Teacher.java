package com.java1234.model;

/**
 * ��ʦʵ��
 * @author Administrator
 *
 */
public class Teacher {
	private Integer tno ;  // ����
	private String tname; // �û���
	private Integer psw; // ����
	private String dep; // Ժϵ
	private String rank; // ְ��
	private String sex; //�Ա�
	
	public Teacher() {
		super();
	}
	public Teacher(Integer tno, String tname, Integer psw, String dep, String rank, String sex) {
		super();
		this.tno = tno;
		this.tname = tname;
		this.psw = psw;
		this.dep = dep;
		this.rank = rank;
		this.sex = sex;
	}
	public Integer getTno() {
		return tno;
	}
	public void setTno(Integer tno) {
		this.tno = tno;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public Integer getPsw() {
		return psw;
	}
	public void setPsw(Integer psw) {
		this.psw = psw;
	}
	public String getDep() {
		return dep;
	}
	public void setDep(String dep) {
		this.dep = dep;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
}
