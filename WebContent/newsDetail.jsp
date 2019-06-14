<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<jsp:include page="header.jsp"></jsp:include>
<script type="text/javascript">
	function jumpback(){
		//event.preventDefault();
		window.history.go(-1);
	}
</script>
<body>
	<div class="panel panel-default">
         <div class="panel-heading">
             <h2>${cnews.title}</h2>
         </div>
         <div class="panel-body">
            <h5>作者:${cnews.uname}----日期:${cnews.pubtime}</h5>
			<p>${cnews.content}</p>
			<a href="javascript:void(0)" onclick="jumpback()" class="pull-right">返回</a>
         </div>
     </div>
</body>
</html>
