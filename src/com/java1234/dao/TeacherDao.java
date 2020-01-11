package com.java1234.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.java1234.model.Teacher;
import com.java1234.model.User;

/**
 * 教师Dao类
 * @author Administrator
 *
 */
public class TeacherDao {

	/**
	 * 教师登录
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User login(Connection con,User user)throws Exception{
		User resultUser=null;
		String sql="select * from teacher where tname=? and psw=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getPassword());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			resultUser=new User();
			resultUser.setUserId(rs.getInt("tno"));
			resultUser.setUserName(rs.getString("tname"));
			resultUser.setPassword(rs.getString("psw"));
			resultUser.setUserType("教师");
		}
		return resultUser;
	}
	


	
	/**
	 * 1根据ID查询教师
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Teacher loadTeacherById(Connection con,String id)throws Exception{
		String sql="select * from teacher where tno=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs=pstmt.executeQuery();
		Teacher teacher=new Teacher();
		while(rs.next()){
			teacher.setTno(rs.getInt("tno"));
			teacher.setTname(rs.getString("tname"));
			teacher.setPsw(rs.getInt("psw"));
			teacher.setSex(rs.getString("sex"));
			teacher.setRank(rs.getString("rank"));
			teacher.setDep(rs.getString("dep"));
		}
		return teacher;
	}
	
}
