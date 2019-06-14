<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
             <h2>修改用户</h2>
         </div>
         <div class="panel-body pre-scrollable" style="overflow-x: hidden;">
         <div class="alert alert-success">恭喜，修改成功！</div>
             <form action="userEditServlet" method="post" class="form-horizontal" role="form" id="myform">
		        <div class="form-group">
		            <label class="col-sm-offset-1 col-sm-4 control-label">用户姓名:</label>
		            <div class="col-sm-3">
		                <input type="text" id="uname" name="uname" class="form-control" placeholder="用户名长度必须大于6位" required value="${user.uname}">
		            </div>
		            <p class="help-block hidden" id="unameTip">用户名必须输入大于6位。</p>
		        </div>
		        <div class="form-group">
		            <label class="col-sm-offset-1 col-sm-4 control-label">用户密码:</label>
		            <div class="col-sm-3">
		                <input type="password" id="pass" name="pass" class="form-control" placeholder="输入密码,必须大于6位" required value="${user.pass}">
		            </div>
		            <p class="help-block hidden" id="passTip">长度必须大于等于6，包含字母和数字以及特殊符号。</p>
		        </div>
		        <div class="form-group">
		            <label class="col-sm-offset-1 col-sm-4 control-label">确认密码:</label>
		            <div class="col-sm-3">
		                <input type="password" id="repass" name="repass" class="form-control" placeholder="两次密码必须一致" required value="${user.pass}">
		            </div>
		            <p class="help-block hidden" id="repassTip">两次输入密码必须一致</p>
		        </div>
		        <div class="form-group">
		            <label class="col-sm-offset-1 col-sm-4 control-label">性别:</label>
		            <div class="col-sm-3">
            			<label class="radio-inline">
			        		<input type="radio" name="sex" value="1" <c:if test="${user.sex==1}">checked</c:if>>男
			    		</label>
           
            			<label class="radio-inline">
			        		<input type="radio" name="sex" value="0" <c:if test="${user.sex==0}">checked</c:if>>女
			    		</label>
		            </div>
		        </div>
		        <div class="form-group">
		            <label class="col-sm-offset-1 col-sm-4 control-label">职业:</label>
		            <div class="col-sm-3">
		            	<select class="form-control" name="profession">
					      <option value="student" <c:if test="${user.profession=='student'}">selected</c:if>>学生</option>
						  <option value="teacher" <c:if test="${user.profession=='teacher'}">selected</c:if>>老师</option>
					    </select>
		            </div>
		        </div>
		        <div class="form-group">
		            <label class="col-sm-offset-1 col-sm-4 control-label">个人爱好:</label>
		            <div class="col-sm-3">
		            	<div class="checkbox">
						    <label><input type="checkbox" name="favourite" value="电脑网络"  <c:if test="${user.favourite.contains('电脑网络')}">checked</c:if>>电脑网络</label>
						</div>
						<div class="checkbox">
						    <label><input type="checkbox" name="favourite" value="影视娱乐" <c:if test="${user.favourite.contains('影视娱乐')}">checked</c:if>>影视娱乐</label>
						</div>
						<div class="checkbox">
						    <label><input type="checkbox" name="favourite" value="棋牌娱乐" <c:if test="${user.favourite.contains('棋牌娱乐')}">checked</c:if>>棋牌娱乐</label>
						</div>
		            </div>
		        </div>
		        <div class="form-group">
		            <label class="col-sm-offset-1 col-sm-4 control-label">个人说明:</label>
		            <div class="col-sm-3">
		            	<textarea class="form-control" rows="3" name="note">${user.note}</textarea>
		            </div>
		        </div>
		        <div class="form-group">
		            <div class="row">
		                <div class="col-sm-offset-6 col-sm-2">
		                    <button type="submit" class="btn btn-primary" onclick="doSubmit()">修改</button>
		                    <button type="reset" class="btn btn-primary">重置</button>
		                </div>
		            </div>
		        </div>
		        <input type="hidden" name="type" value="edit">
   				<input type="hidden" name="uid" value="${user.uid}">
		    </form>
         </div>
     </div>
  </body>
</html>
