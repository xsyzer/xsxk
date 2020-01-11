package com.java1234.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import com.java1234.dao.CourseDao;
import com.java1234.dao.StudentCourseDao;
import com.java1234.dao.StudentDao;
import com.java1234.dao.TeacherDao;
import com.java1234.model.Course;
import com.java1234.model.Student;
import com.java1234.model.StudentCourse;
import com.java1234.model.Teacher;
import com.java1234.model.User;
import com.java1234.util.DbUtil;
import com.java1234.util.ResponseUtil;

/**
 * 教师Servlet类
 * @author Administrator
 *
 */
public class TeacherServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DbUtil dbUtil=new DbUtil();
	private TeacherDao teacherDao=new TeacherDao();
	private CourseDao courseDao = new CourseDao();
	private StudentDao studentDao=new StudentDao();
	private StudentCourseDao studentCourseDao=new StudentCourseDao();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action=request.getParameter("action");
		 if("showCourse".equals(action)){
			this.showCourse(request, response);
		}else if("showStudent".equals(action)){
			this.showStudent(request, response);
		}else if("showInfo".equals(action)){
			this.showInfo(request, response);
		}else if("scoreInfo".equals(action)){
			this.scoreInfo(request,response);
		}else if("updateScore".equals(action)){
			this.updateScore(request,response);
		}
	}
	
	
	

	/**
	 * 查看当前老师的课程
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void showCourse(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		HttpSession session=request.getSession();
		User currentUser=(User) session.getAttribute("currentUser");
		Course s_course=new Course();
		s_course.setT_name(currentUser.getUserName());
		Connection con=null;
		try{
			con=dbUtil.getCon();
			List<Course> courseList=courseDao.courseList(con, null, s_course);
			request.setAttribute("courseList", courseList);
			request.setAttribute("modeName", "查看所授课程");
			request.setAttribute("mainPage", "teacher/courseList.jsp");
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 查看当前老师的学生
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void showStudent(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		HttpSession session=request.getSession();
		User currentUser=(User) session.getAttribute("currentUser");
		Connection con=null;
		try{
			con=dbUtil.getCon();
			List<Student> studentList=studentDao.findStudentsByTeacherId(con, currentUser.getUserId());
			request.setAttribute("studentList", studentList);
			request.setAttribute("modeName", "查看所带学生");
			request.setAttribute("mainPage", "teacher/studentList.jsp");
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 查看个人信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void showInfo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		HttpSession session=request.getSession();
		User currentUser=(User) session.getAttribute("currentUser");
		Connection con=null;
		try{
			con=dbUtil.getCon();
			Teacher teacher=teacherDao.loadTeacherById(con, String.valueOf(currentUser.getUserId()));
			request.setAttribute("teacher", teacher);
			request.setAttribute("modeName", "查看个人信息");
			request.setAttribute("mainPage", "teacher/info.jsp");
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 查看当前老师的学生(带成绩)
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void scoreInfo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		HttpSession session=request.getSession();
		User currentUser=(User) session.getAttribute("currentUser");
		Connection con=null;
		try{
			con=dbUtil.getCon();
			List<StudentCourse> studentCourseList=studentCourseDao.findStudentsByTeacherId(con, currentUser.getUserId());
			request.setAttribute("studentCourseList",studentCourseList);
			request.setAttribute("modeName", "成绩录入");
			request.setAttribute("mainPage", "teacher/scoreInfo.jsp");
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void updateScore(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String score=request.getParameter("score");
		String id=request.getParameter("id");
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int resultNum=studentCourseDao.updateScore(con, Integer.parseInt(score), Integer.parseInt(id));
			JSONObject result=new JSONObject();
			if(resultNum>0){
				result.put("success", true);				
			}else{
				result.put("errorInfo", "删除失败！");
			}
			ResponseUtil.write(result, response);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
