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
		      <input type="text" class="form-control" id="userName"  name="userName" style="width: 300px;"  value="${teacher.tname }"  readonly="readonly">
		    </div>
		  </div>
		  <div class="form-group">
		    <label  class="col-md-2 control-label">密码：</label>
		    <div class="col-md-10">
		      <input type="text" class="form-control" id="password"  name="password" style="width: 300px;"  value="${teacher.psw }"  readonly="readonly">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-md-2 control-label">性别：</label>
		    <div class="col-md-10">
		      <input type="text" class="form-control"  style="width: 300px;"  value="${teacher.sex }" readonly="readonly" >
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-md-2 control-label">职称：</label>
		    <div class="col-md-10">
			      <input type="text" class="form-control"  style="width: 300px;"  value="${teacher.rank }"  readonly="readonly">
		    </div>
		  </div>
		    <div class="form-group">
		    <label class="col-md-2 control-label">学院：</label>
		    <div class="col-md-10">
			      <input type="text" class="form-control"  style="width: 300px;"  value="${teacher.dep }"  readonly="readonly">
		    </div>
		  </div>
		  </form>
  </div>
</div>

