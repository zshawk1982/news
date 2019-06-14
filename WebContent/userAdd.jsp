<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <jsp:include page="header.jsp"></jsp:include>
  <script type="text/javascript">
	  function doSubmit(){
			document.getElementById("myform").submit();
	  }
  </script>
  <body>
  	<div class="panel panel-default">
         <div class="panel-heading">
             <h2>添加用户</h2>
         </div>
         <div class="panel-body pre-scrollable" style="overflow-x: hidden;">
             <form action="userAddServlet" method="post" class="form-horizontal" role="form" id="myform">
		        <div class="form-group">
		            <label class="col-sm-offset-1 col-sm-4 control-label">用户姓名:</label>
		            <div class="col-sm-3">
		                <input type="text" id="uname" name="uname" class="form-control" placeholder="用户名长度必须大于6位" required>
		            </div>
		            <p class="help-block hidden" id="unameTip">用户名必须输入大于6位。</p>
		        </div>
		        <div class="form-group">
		            <label class="col-sm-offset-1 col-sm-4 control-label">用户密码:</label>
		            <div class="col-sm-3">
		                <input type="password" id="pass" name="pass" class="form-control" placeholder="输入密码,必须大于6位" required>
		            </div>
		            <p class="help-block hidden" id="passTip">长度必须大于等于6，包含字母和数字以及特殊符号。</p>
		        </div>
		        <div class="form-group">
		            <label class="col-sm-offset-1 col-sm-4 control-label">确认密码:</label>
		            <div class="col-sm-3">
		                <input type="password" id="repass" name="repass" class="form-control" placeholder="两次密码必须一致" required>
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
		                    <button type="submit" class="btn btn-primary" onclick="doSubmit()">添加</button>
		                    <button type="reset" class="btn btn-primary">重置</button>
		                </div>
		            </div>
		        </div>
		    </form>
         </div>
     </div>
  </body>
</html>
