package com.java1234.model;

/**
 * ѧ����
 * @author Administrator
 *
 */
public class Student {

	private Integer sno ;  // ѧ��
	private String sname; // �û���
	private String psw; // ����
	private Integer class1; // �꼶
	private String major; // רҵ
	private Integer age; // ����
	private String sex; //�Ա�
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student(Integer sno, String sname, String psw, Integer class1, String major, Integer age, String sex) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.psw = psw;
		this.class1 = class1;
		this.major = major;
		this.age = age;
		this.sex = sex;
	}
	public Integer getSno() {
		return sno;
	}
	public void setSno(Integer sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	public Integer getClass1() {
		return class1;
	}
	public void setClass1(Integer class1) {
		this.class1 = class1;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	

	
}
