package com.java1234.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.java1234.model.Student;
import com.java1234.model.User;

/**
 * 学生Dao类
 * @author Administrator
 *
 */
public class StudentDao {

	/**
	 * 学生登录
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User login(Connection con,User user)throws Exception{
		User resultUser=null;
		String sql="select * from student where sname=? and psw=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getPassword());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			resultUser=new User();
			resultUser.setUserId(rs.getInt("sno"));
			resultUser.setUserName(rs.getString("sname"));
			resultUser.setPassword(rs.getString("psw"));
			resultUser.setUserType("学生");
		}
		return resultUser;
	}

	
	/**
	 * 1根据ID查询学生
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Student loadStudentById(Connection con,String id)throws Exception{
		String sql="select * from student where sno=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs=pstmt.executeQuery();
		Student student=new Student();
		while(rs.next()){
			student.setSno(rs.getInt("sno"));
			student.setSname(rs.getString("sname"));
			student.setPsw(rs.getString("psw"));
			student.setClass1(rs.getInt("class1"));
			student.setMajor(rs.getString("major"));
			student.setAge(rs.getInt("age"));
			student.setSex(rs.getString("sex"));
		}
		return student;
	}
	
	/**
	 * 1查找制定老师的学生
	 * @param con
	 * @param teacherId
	 * @return
	 * @throws Exception
	 */
	public List<Student> findStudentsByTeacherId(Connection con,Integer teacherId)throws Exception{
		List<Student> studentList=new ArrayList<Student>();
		String sql="SELECT t2.sno AS sno,t2.sname AS sname,t2.major AS major,t2.class1 FROM teacher t1,student t2,keqi t3,xk t4 WHERE t2.sno=t4.sno AND t3.cno=t4.cno AND t3.t_name=t1.tname and t1.tno="+teacherId;
		PreparedStatement pstmt=con.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			Student student=new Student();
			student.setSno(rs.getInt("sno"));
			student.setSname(rs.getString("sname"));
			student.setMajor(rs.getString("major"));
			student.setClass1(rs.getInt("class1"));
			studentList.add(student);
		}
		return studentList;
	}
}
