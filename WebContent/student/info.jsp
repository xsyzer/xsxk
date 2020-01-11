<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">个人信息</h3>
  </div>
  <div class="panel-body">
  		 <form class="form-horizontal" role="form" action="">
		  <div class="form-group">
		    <label  class="col-md-2 control-label">用户名：</label>
		    <div class="col-md-10">
		      <input type="text" class="form-control" id="userName"  name="userName" style="width: 300px;"  value="${student.sname}"  readonly="readonly">
		    </div>
		  </div>
		  <div class="form-group">
		    <label  class="col-md-2 control-label">密码：</label>
		    <div class="col-md-10">
		      <input type="text" class="form-control" id="password"  name="password" style="width: 300px;"  value="${student.psw}"  readonly="readonly">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-md-2 control-label">性别：</label>
		    <div class="col-md-10">
		      <input type="text" class="form-control" id="trueName"  name="trueName" style="width: 300px;"  value="${student.sex }" readonly="readonly" >
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-md-2 control-label">学号：</label>
		    <div class="col-md-10">
			      <input type="text" class="form-control" id="stuNo"  name="stuNo" style="width: 300px;"  value="${student.sno }"  readonly="readonly">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-md-2 control-label">专业：</label>
		    <div class="col-md-10">
			      <input type="text" class="form-control" id="professional"  name="professional" style="width: 300px;"  value="${student.major }"  readonly="readonly">
		    </div>
		  </div>
		   <div class="form-group">
		    <label class="col-md-2 control-label">年级：</label>
		    <div class="col-md-10">
			      <input type="text" class="form-control" id="class1"  name="class1" style="width: 300px;"  value="${student.class1 }"  readonly="readonly">
		    </div>
		  </div>
		   <div class="form-group">
		    <label class="col-md-2 control-label">年龄：</label>
		    <div class="col-md-10">
			      <input type="text" class="form-control" id="age"  name="age" style="width: 300px;"  value="${student.age}"  readonly="readonly">
		    </div>
		  </div>
		  </form>
  </div>
</div>

