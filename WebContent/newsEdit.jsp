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
             <h2>修改新闻</h2>
         </div>
         <div class="panel-body">
             <form action="newsEditServlet" method="post" class="form-horizontal" role="form" id="myform">
		        <div class="form-group">
		        	<div class="row">
			            <label class="col-sm-offset-1 col-sm-2 control-label">新闻标题:</label>
			            <div class="col-sm-6">
			                <input type="text" id="title" name="title" class="form-control" value=${news.title} required>
			            </div>
		            </div>
		        </div>
		        <div class="form-group">
		        	<div class="row">
			            <label class="col-sm-offset-1 col-sm-2 control-label">新闻正文:</label>
			            <div class="col-sm-6">
			            	<textarea class="form-control" rows="8" cols="5" name="content">${news.content}</textarea>
			            </div>
		            </div>
		        </div>
		        <div class="form-group">
		        	<div class="row">
			            <label class="col-sm-offset-1 col-sm-2 control-label">发布时间:</label>
			            <div class="col-sm-6">
			                <input type="text" id="pubtime" name="pubtime" class="form-control" value=${news.pubtime} required>
			            </div>
		            </div>
		        </div>
		        <div class="form-group">
		            <div class="row">
		                <div class="col-sm-offset-6 col-sm-2">
		                    <button type="submit" class="btn btn-primary" onclick="doSubmit()">提交</button>
		                    <button type="reset" class="btn btn-primary">重置</button>
		                </div>
		            </div>
		        </div>
		        <input type="hidden" name="type" value="edit">
   				<input type="hidden" name="nid" value="${news.nid}">
    		</form>
         </div>
     </div>
  </body>
</html>
