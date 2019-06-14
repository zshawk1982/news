<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<jsp:include page="header.jsp"></jsp:include>
<script type="text/javascript">
	function jumpRegister(){
		window.location.href = "register.jsp";
	}
	function doSubmit(){
		document.getElementById("myform").submit();
	}
</script>
</head>
<body>
	<div class="container" style="padding-top: 50px;">
    <h3 class="text-center">用户登录</h3><br/>
    <form action="loginServlet" method="post" class="form-horizontal" role="form" id="myform">
        <div class="form-group">
            <label class="col-sm-offset-1 col-sm-4 control-label">用户姓名:</label>
            <div class="col-sm-3">
                <input type="text" id="uname" name="uname" class="form-control" onblur="checkUname()" placeholder="用户名长度必须大于6位" required>
            </div>
            <p class="help-block hidden" id="unameTip">用户名必须输入大于6位。</p>
        </div>
        <div class="form-group">
            <label class="col-sm-offset-1 col-sm-4 control-label">用户密码:</label>
            <div class="col-sm-3">
                <input type="password" id="pass" name="pass" onblur="checkPass()" class="form-control" placeholder="输入密码,必须大于6位" required>
            </div>
            <p class="help-block hidden" id="passTip">长度必须大于等于6，包含字母和数字以及特殊符号。</p>
        </div>
        <div class="form-group">
            <div class="row">
                <div class="col-sm-offset-6 col-sm-2">
                    <button type="submit" class="btn btn-primary" onclick="doSubmit()">登录</button>
                    <button type="reset" class="btn btn-primary">重置</button>
                    <button type="reset" class="btn btn-primary" onclick="jumpRegister()">注册</button>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>