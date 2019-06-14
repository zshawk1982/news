<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <jsp:include page="header.jsp"></jsp:include>
  <body>
  	<div class="panel panel-default">
         <div class="panel-heading">
             <h2>查看用户</h2>
         </div>
         <div class="panel-body pre-scrollable" style="overflow-x: hidden;">
             <form class="form-horizontal" role="form" id="myform">
		        <div class="form-group">
		            <label class="col-sm-offset-1 col-sm-4 control-label">用户姓名:</label>
		            <div class="col-sm-3">
		                <input type="text" id="uname" name="uname" class="form-control" value="${cuser.uname}">
		            </div>
		        </div>
		        <div class="form-group">
		            <label class="col-sm-offset-1 col-sm-4 control-label">性别:</label>
		            <div class="col-sm-3">
		            	<input type="text" name="sex" class="form-control" value="${cuser.sex==1?'男':'女'}">
		            </div>
		        </div>
		        <div class="form-group">
		            <label class="col-sm-offset-1 col-sm-4 control-label">职业:</label>
		            <div class="col-sm-3">
		            	<input type="text" name="profession" class="form-control" value="${cuser.profession}">
		            </div>
		        </div>
		        <div class="form-group">
		            <label class="col-sm-offset-1 col-sm-4 control-label">个人爱好:</label>
		            <div class="col-sm-3">
		            	<input type="text" name="favourite" class="form-control" value="${cuser.favourite}">
		            </div>
		        </div>
		        <div class="form-group">
		            <label class="col-sm-offset-1 col-sm-4 control-label">个人说明:</label>
		            <div class="col-sm-3">
		            	<textarea class="form-control" rows="3" name="note">${cuser.note}</textarea>
		            </div>
		        </div>
		    </form>
         </div>
     </div>
  </body>
</html>
