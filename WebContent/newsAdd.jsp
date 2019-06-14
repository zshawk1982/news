<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <jsp:include page="header.jsp"></jsp:include>
  <!-- ueditor设置 -->
  <link href="js/ueditor/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
  <script type="text/javascript" charset="utf-8" src="js/ueditor/umeditor.config.js"></script>
  <script type="text/javascript" charset="utf-8" src="js/ueditor/umeditor.min.js"></script>
  <script type="text/javascript" src="js/ueditor/lang/zh-cn/zh-cn.js"></script>
  <!-- ueditor设置 -->
  
  <body>
  	<div class="panel panel-default">
         <div class="panel-heading">
             <h2>添加新闻</h2>
         </div>
         <div class="panel-body">
         	 <!-- <div class="alert alert-success">发布成功。</div> -->
             <form action="newsAddServlet" method="post" class="form-horizontal" role="form" id="myform">
		        <div class="form-group">
		        	<div class="row">
			            <label class="col-sm-offset-1 col-sm-2 control-label">新闻标题:</label>
			            <div class="col-sm-6">
			                <input type="text" id="title" name="title" class="form-control"  required>
			            </div>
		            </div>
		        </div>
		        <div class="form-group">
		        	<div class="row">
			            <label class="col-sm-offset-1 col-sm-2 control-label">新闻正文:</label>
			            <div class="col-sm-6">
			            	<!-- <textarea class="form-control" rows="8" cols="5" name="content"></textarea> -->
			            	 <script type="text/plain" id="myEditor" style="width:100%;height:100px;">
    							<p>这里我可以写一些输入提示</p>
							</script>
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
    		</form>
         </div>
     </div>
  </body>
  <script type="text/javascript">
  	  var um = UM.getEditor('myEditor');
	  function doSubmit(){
			document.getElementById("myform").submit();
		}
  </script>
</html>
