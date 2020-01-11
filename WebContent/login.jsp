<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
</head>
<body style="text-align:center;">


<form action="user?action=login" method=post >
<h1 style="text-align:center;" >登录</h1>
        <p style="text-align:center;"><input type="text" id="userName" name="userName" value="${user.userName }" placeholder="账号"></p>
        <p style="text-align:center;"><input type="text" id="password" name="password" value="${user.password }" placeholder="密码"></p>
  <div >     
      
						
							<select   id="userType" name="userType" >
								<option  value="">请选择用户类型...</option>
								<option value="教师"  ${'教师'==user.userType?'selected':'' }>教师</option>
								<option value="学生"  ${'学生'==user.userType?'selected':'' }>学生</option>
							</select>
					
					</div>
					 <p style="text-align:center;"><input type="submit" name="btnLogin" value="登  录"></p>
</form>
<script type="text/javascript">
	if('${error}'!=''){
		alert('${error}');
	}
</script>
</body>
</html>
