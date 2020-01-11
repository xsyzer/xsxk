package com.java1234.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.java1234.model.StudentCourse;

/**
 * 学生课程Dao类
 * 
 * @author Administrator
 *
 */
public class StudentCourseDao {

	/**
	 * 1查找指定老师的学生(包括成绩)
	 * @param con
	 * @param teacherId
	 * @return
	 * @throws Exception
	 */
	public List<StudentCourse> findStudentsByTeacherId(Connection con,Integer teacherId)throws Exception{
		List<StudentCourse> studentList=new ArrayList<StudentCourse>();
		String sql="SELECT t4.id ,t2.sname ,t3.name ,t4.score FROM teacher t1,student t2,keqi t3,xk t4 WHERE t2.sno=t4.sno AND t3.cno=t4.cno AND t3.t_name=t1.tname AND t1.tno="+teacherId;
		PreparedStatement pstmt=con.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			StudentCourse student=new StudentCourse();
			student.setId(rs.getInt("id"));
			student.setSname(rs.getString("sname"));
			student.setName(rs.getString("name"));
			student.setScore(rs.getInt("score"));
			studentList.add(student);
		}
		return studentList;
	}
	
	/**
	 * 1根据ID修改成绩  录入成绩/修改成绩
	 * @param id
	 */
	public int updateScore(Connection con,int score,int id)throws Exception{
		String sql="update xk set score=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, score);
		pstmt.setInt(2, id);
		return pstmt.executeUpdate();
	}
	
	/**
	 * 1通过学生id查找课程
	 * @param con
	 * @param studentId
	 * @return
	 * @throws Exception
	 */
	public List<StudentCourse> findCourseByStudentId(Connection con,int studentId)throws Exception{
		List<StudentCourse> courseList=new ArrayList<StudentCourse>();
		String sql="SELECT t3.cno ,t4.id,t4.sno,t3.name,t3.t_name,t3.credit,t3.class1,t3.add,t3.zhou,t3.time,t3.bixiu,t3.num,t4.score FROM teacher t1,student t2,keqi t3,xk t4 WHERE t2.sno=t4.sno AND t3.cno=t4.cno AND t3.t_name=t1.tname AND t2.sno="+studentId;
		PreparedStatement pstmt=con.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			StudentCourse studentCourse=new StudentCourse();
			studentCourse.setId(rs.getInt("id"));
			studentCourse.setCno(rs.getInt("cno"));
			studentCourse.setName(rs.getString("name"));
			studentCourse.setCredit(rs.getInt("credit"));
			studentCourse.setT_name(rs.getString("t_name"));
			studentCourse.setAdd(rs.getString("add"));
			studentCourse.setZhou(rs.getInt("zhou"));
			studentCourse.setTime(rs.getString("time"));
			studentCourse.setBixiu(rs.getInt("bixiu"));
			studentCourse.setScore(rs.getInt("score"));
			courseList.add(studentCourse);
		}
		return courseList;
	}
	
	/**
	 * 1添加学生选课信息
	 * @param sc
	 * @return
	 * @throws Exception
	 */
	public int addStudentCourse(Connection con,StudentCourse sc)throws Exception{
		String sql="call cr(null,?,?,null,null,null)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		//PreparedStatement pstmt1=con.prepareStatement(sql1);
		pstmt.setInt(1, sc.getCno());
		pstmt.setInt(2, sc.getSno());
		return pstmt.executeUpdate();
	
	}
	public int addname(Connection con)throws Exception{
		
		String sql="call xk()";
		PreparedStatement pstmt=con.prepareStatement(sql);
		
		return pstmt.executeUpdate();
	
	}
	
	
	/**
	 *1 删除学生选课信息
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int deleteStudentCourse(Connection con,String id)throws Exception{
		String sql="delete from xk where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	
	
	
	
	/**
	 * 1判断指定课程是否打分
	 * @param con
	 * @param courseId
	 * @return
	 * @throws Exception
	 */
	public boolean hasScoreWithCourseId(Connection con,String id)throws Exception{
		String sql="select score from xk where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			if(rs.getString("score")==null){
				return false;
			}else{
				return true;
			}
		}else{
			return false;
		}
	}
}
