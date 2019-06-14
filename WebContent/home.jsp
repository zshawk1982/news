<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<body>
<jsp:include page="header.jsp"></jsp:include>
<script type="text/javascript" src="http://mockjs.com/bower_components/mockjs/dist/mock.js"></script>
<script>
window.onload=function(){
	//利用mock.js动态生成轮播图
	var Random = Mock.Random;
	var carousel = document.querySelector(".carousel-inner");
	for(let i=0;i<=4;i++){
		var divel = document.createElement("div");
		divel.classList.add("item");
		if(i==0){
			divel.classList.add("active");
		}
		var imgel = document.createElement("img");
		imgel.setAttribute("src",Random.image('1250x350', '#FF6600'));
		imgel.classList.add("img-responsive");
		//imgel.style.width="100%";
		divel.appendChild(imgel);
		carousel.appendChild(divel);
	}
}
</script>
<div class="container" >
	<div id="myCarousel" class="carousel slide">
	    <!-- 轮播（Carousel）指标 -->
	    <ol class="carousel-indicators">
	        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
	        <li data-target="#myCarousel" data-slide-to="1"></li>
	        <li data-target="#myCarousel" data-slide-to="2"></li>
	        <li data-target="#myCarousel" data-slide-to="3"></li>
	        <li data-target="#myCarousel" data-slide-to="4"></li>
	    </ol>   
	    <!-- 轮播（Carousel）项目 -->
	    <div class="carousel-inner">
	        
	    </div>
	    <!-- 轮播（Carousel）导航 -->
	    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
		    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
		    <span class="sr-only">Previous</span>
		</a>
		<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
		    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
		    <span class="sr-only">Next</span>
		</a>
	</div>
	<div class="row" style="margin-top:15px">
		<div class="col-xs-6">
			<div class="list-group">
			    <a href="#" class="list-group-item active">
			        <h4 class="list-group-item-heading">最新新闻</h4>
			    </a>
			    <a href="#" class="list-group-item">
			        <h4 class="list-group-item-heading">最年轻中将亮相军委大会 曾带15架歼10飞跃天安门</h4>
			    </a>
			    <a href="#" class="list-group-item">
			        <h4 class="list-group-item-heading">李克强欢迎马来西亚总理马哈蒂尔访华</h4>
			    </a>
			    <a href="#" class="list-group-item">
			        <h4 class="list-group-item-heading">地球上最新最豪华专机 卡塔尔王室说不要就不要</h4>
			    </a>
			    <a href="#" class="list-group-item">
			        <h4 class="list-group-item-heading">结婚都拖拉还怎么生孩子？这省平均婚龄已达34岁</h4>
			    </a>
			</div>
		</div>
		<div class="col-xs-6">
			<div class="list-group">
			    <a href="#" class="list-group-item active">
			        <h4 class="list-group-item-heading">热点新闻</h4>
			    </a>
			    <a href="#" class="list-group-item">
			        <h4 class="list-group-item-heading">最年轻中将亮相军委大会 曾带15架歼10飞跃天安门</h4>
			    </a>
			    <a href="#" class="list-group-item">
			        <h4 class="list-group-item-heading">李克强欢迎马来西亚总理马哈蒂尔访华</h4>
			    </a>
			    <a href="#" class="list-group-item">
			        <h4 class="list-group-item-heading">地球上最新最豪华专机 卡塔尔王室说不要就不要</h4>
			    </a>
			    <a href="#" class="list-group-item">
			        <h4 class="list-group-item-heading">结婚都拖拉还怎么生孩子？这省平均婚龄已达34岁</h4>
			    </a>
			</div>
		</div>
	</div>
</div>
</body>
</html>