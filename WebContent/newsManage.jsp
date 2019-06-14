<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-2 col-md-2">
            <div class="list-group">
                <a href="javascript:void(0)" class="list-group-item" data-src="newsListServlet">新闻列表</a>
                <a href="javascript:void(0)" class="list-group-item" data-src="newsAdd.jsp">添加新闻</a>
            </div>
        </div>
        <div class="col-xs-12 col-sm-10 col-md-10">
            <iframe id="niframe"src="newsListServlet" width="100%" height="80%" frameborder="0" scrolling="no"></iframe>
        </div>
    </div>
</div>
<script type="text/javascript">
	$(function(){
		$(".list-group a").click(function(){
			$("#niframe").attr("src",$(this).attr("data-src"));
		})
	})
</script>



