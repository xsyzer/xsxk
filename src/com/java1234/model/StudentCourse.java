package com.java1234.model;

/**
 * 学生课程关联类
 * @author Administrator
 *
 */
public class StudentCourse {
	private Integer id;//选课编号
	private String name; //课名 1
	private Integer cno;//课号 2 
	private String t_name;//教师名3
	private String add;//地址4
	private String time;//时间5
	private Integer zhou;//周数6
	private Integer bixiu;//是否必修7
	private Integer credit;//学分8
	private Integer class1;//专业9
	private Integer num;//余量10
	private Integer sno;//学号11
	private String sname;//学生姓名12
	private Integer score;//成绩13
	
	public StudentCourse() {
		super();
		
	}
	
	
	public StudentCourse(String sname,String name, Integer cno, String t_name, String add, String time, Integer zhou, Integer bixiu,
			Integer credit, Integer class1, Integer num, Integer sno, Integer score,Integer id) {
		super();
		this.sname = sname;
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
		this.sno = sno;
		this.score = score;
		this.id=id;
	}
	
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Integer getSno() {
		return sno;
	}
	public void setSno(Integer sno) {
		this.sno = sno;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
