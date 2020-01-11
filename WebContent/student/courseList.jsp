<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
	<table class="table table-hover  table-bordered table-striped" style="margin-bottom: 0px;">
	
		<tr>
		  	<th>序号</th>
		  	<th>课程名称</th>
		  	<th>学分</th>
		  	<th>授课老师</th>
		  	<th>地点</th>
			  	<th>周几</th>
			  	<th>时间</th>
		  </tr>
		  <c:forEach var="course" items="${courseList }" varStatus="status">
		  	<tr>
		  	    <td>${status.index+1 }</td>
		  		<td>${course.name }</td>
		  		<td>${course.credit }</td>
		  		<td>${course.t_name }</td>
		  		<td>${course.add }</td>
		  		<td>${course.zhou }</td>
		  		<td>${course.time }</td>
		  	</tr>
		  </c:forEach>
	</table>
</div>



