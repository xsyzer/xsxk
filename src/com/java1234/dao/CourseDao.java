package com.java1234.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.java1234.model.PageBean;
import com.java1234.model.Course;
import com.java1234.util.StringUtil;

/**
 * 课程Dao类
 * @author Administrator
 *
 */
public class CourseDao {

	/**
	 * 1课程信息查询
	 * @param con
	 * @param pageBean
	 * @param s_course
	 * @return
	 * @throws Exception
	 */
	public List<Course> courseList(Connection con,PageBean pageBean,Course s_course)throws Exception{
		List<Course> courseList=new ArrayList<Course>();
		StringBuffer sb=new StringBuffer("select * from keqi t1,teacher t2 where t1.t_name=t2.tname ");
		if(s_course!=null){
			if(StringUtil.isNotEmpty(s_course.getName())){
				sb.append(" and t1.name like '%"+s_course.getName()+"%'");
			}
			if(s_course.getT_name()!=null){
				sb.append(" and t1.t_name like '%"+s_course.getT_name()+"%'");
			}
		}
		if(pageBean!=null){
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getPageSize());
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			Course course=new Course();
			course.setCno(rs.getInt("cno"));
			course.setName(rs.getString("name"));
			course.setCredit(rs.getInt("credit"));
			course.setT_name(rs.getString("t_name"));
			course.setAdd(rs.getString("add"));
			course.setZhou(rs.getInt("zhou"));
			course.setTime(rs.getString("time"));
			course.setBixiu(rs.getInt("bixiu"));
			course.setClass1(rs.getInt("class1"));
			course.setNum(rs.getInt("num"));
			courseList.add(course);
		}
		return courseList;
	}
	
}
