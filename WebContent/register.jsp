<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>注册页面</title>
<jsp:include page="header.jsp"></jsp:include>
<script type="text/javascript">
	//验证用户名
	function checkUname(){
		let result = true;
		let uname = document.getElementById("uname").value;
		if(uname.length<6){
			document.getElementById("unameTip").classList.remove("hidden");
			result = false;
		}
		return result;
	}
	//验证密码
	function checkPass(){
		let result  =  true;
		let pass = document.getElementById("pass").value;
		if(pass.length<6){
			document.getElementById("passTip").classList.remove("hidden");
			result = false;
		}
		return result;
	}
	//验证确认密码
	function checkrePass(){
		let result  =  true;
		let pass = document.getElementById("pass").value;
		let repass = document.getElementById("repass").value;
		if(pass!=repass){
			document.getElementById("repassTip").classList.remove("hidden");
			result = false;
		}
		return result;
	}
	//表单提交
	function doSubmit(){
		if(checkUname()&&checkPass()&&checkrePass()){
			document.getElementById("myform").submit();
		}
	}
</script>
</head>
<body>
	<div class="container" style="padding-top: 50px;">
    <h3 class="text-center">用户注册</h3><br/>
    <form action="registerServlet" method="post" class="form-horizontal" role="form" id="myform">
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
            <label class="col-sm-offset-1 col-sm-4 control-label">确认密码:</label>
            <div class="col-sm-3">
                <input type="password" id="repass" name="repass" onblur="checkrePass()" class="form-control" placeholder="两次密码必须一致" required>
            </div>
            <p class="help-block hidden" id="repassTip">两次输入密码必须一致</p>
        </div>
        <div class="form-group">
            <label class="col-sm-offset-1 col-sm-4 control-label">性别:</label>
            <div class="col-sm-3">
            	<label class="radio-inline">
			        <input type="radio" name="sex" value="1" checked>男
			    </label>
			    <label class="radio-inline">
			        <input type="radio" name="sex" value="0">女
			    </label>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-offset-1 col-sm-4 control-label">职业:</label>
            <div class="col-sm-3">
            	<select class="form-control" name="profession">
			      <option value="student" selected>学生</option>
				  <option value="teacher">老师</option>
			    </select>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-offset-1 col-sm-4 control-label">个人爱好:</label>
            <div class="col-sm-3">
            	<div class="checkbox">
				    <label><input type="checkbox" name="favourite" value="电脑网络" checked>电脑网络</label>
				</div>
				<div class="checkbox">
				    <label><input type="checkbox" name="favourite" value="影视娱乐">影视娱乐</label>
				</div>
				<div class="checkbox">
				    <label><input type="checkbox" name="favourite" value="棋牌娱乐">棋牌娱乐</label>
				</div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-offset-1 col-sm-4 control-label">个人说明:</label>
            <div class="col-sm-3">
            	<textarea class="form-control" rows="3" name="note"></textarea>
            </div>
        </div>
        <div class="form-group">
            <div class="row">
                <div class="col-sm-offset-6 col-sm-2">
                    <button type="submit" class="btn btn-primary" onclick="doSubmit()">注册</button>
                    <button type="reset" class="btn btn-primary">重置</button>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>