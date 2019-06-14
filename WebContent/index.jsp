<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<body>
<jsp:include page="header.jsp"></jsp:include>
<script type="text/javascript">
	window.onload=function(){
		Array.prototype.forEach.call(document.querySelectorAll("#news_navbar li a"), function(el){
		    el.addEventListener('click', function(){
		    	Array.prototype.forEach.call(document.querySelectorAll("#news_navbar li"), function(el){
		    		el.classList.remove("active");
		    	})
		    	this.parentNode.classList.add("active");
		    	document.querySelector("#miframe").setAttribute("src",this.getAttribute("data-src"));
		    });
		});
		Array.prototype.forEach.call(document.querySelectorAll(".dropdown-menu li a"), function(el){
		    el.addEventListener('click', function(){
		    	document.querySelector("#miframe").setAttribute("src",this.getAttribute("data-src"));
		    });
		});
		
	}
	
</script>
<div class="header">
    <nav class="navbar navbar-default">
        <div class="container">
            <div class="navbar-header">
                <button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a href="#" class="navbar-brand">新闻发布管理系统</a>
            </div>
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav" id="news_navbar">
                    <li class="active"><a href="javascript:void(0)" data-src="home.jsp"><span class="glyphicon glyphicon-home"></span> 后台首页</a></li>
                    <c:if test="${currentUser.type==1}">
                    	<li><a href="javascript:void(0)" data-src="userManage.jsp"><span class="glyphicon glyphicon-user"></span> 用户管理</a></li>
                    </c:if>
                    <li><a href="javascript:void(0)" data-src="newsManage.jsp"><span class="glyphicon glyphicon-list"></span> 新闻管理</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" data-toggle="dropdown">${currentUser.uname}
                            <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="javascript:void(0)"><span class="glyphicon glyphicon-user"></span> 个人首页</a></li>
                            <li><a href="javascript:void(0)" data-src="personSetting.jsp"><span class="glyphicon glyphicon-cog"></span> 个人设置</a></li>
                        </ul>
                    </li>
                    <li><a href="quitServlet"><span class="glyphicon glyphicon-off"></span> 退出</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<iframe id="miframe" src="home.jsp" width="100%" height="600px" frameborder="0" scrolling="no"></iframe>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>