package com.java1234.model;

/**
 * �γ�ʵ����
 * @author Administrator
 *
 */
public class Course {
	private String name; //����
	private Integer cno;//�κ�
	private String t_name;//��ʦ��
	private String add;//��ַ
	private String time;//ʱ��
	private Integer zhou;//����
	private Integer bixiu;//�Ƿ����
	private Integer credit;//ѧ��
	private Integer class1;//רҵ
	private Integer num;//����
	public Course() {
		super();
	}
	public Course(String name, Integer cno, String t_name, String add, String time, Integer zhou, Integer bixiu,
			Integer credit, Integer class1, Integer num) {
		super();
		this.name = name;
		this.cno = cno;
		this.t_name = t_name;
		this.add = add;
		this.time = time;
		this.zhou = zhou;
		this.bixiu = bixiu;
		this.credit = credit;
		this.class1 = class1;
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCno() {
		return cno;
	}
	public void setCno(Integer cno) {
		this.cno = cno;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Integer getZhou() {
		return zhou;
	}
	public void setZhou(Integer zhou) {
		this.zhou = zhou;
	}
	public Integer getBixiu() {
		return bixiu;
	}
	public void setBixiu(Integer bixiu) {
		this.bixiu = bixiu;
	}
	public Integer getCredit() {
		return credit;
	}
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	public Integer getClass1() {
		return class1;
	}
	public void setClass1(Integer class1) {
		this.class1 = class1;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}


	
}
