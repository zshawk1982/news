<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<jsp:include page="header.jsp"></jsp:include>

<body>
	<div class="panel panel-default">
	   <div class="panel-heading">
	      <div class="row">
	        <h2 class="col-sm-2">新闻列表</h2>
	        <form class="form-inline col-sm-10" role="form" action="newsListServlet" method="post" style="margin-top: 20px">
	  			<div class="form-group">
	    			<label class="sr-only" for="title">新闻标题</label>
	    			<input type="text" class="form-control" id="title" name="title" placeholder="请输入要查询的标题">
	  			</div>
	  			<button type="submit" class="btn btn-default">查询</button>
			</form>
	       </div>
	     </div>
          <div class="panel-body">
              <table class="table" style="table-layout:fixed">
                  <thead>
                      <tr>
                        <th>新闻编号</th>
						<th>新闻标题</th>
						<th>发布人</th>
						<th>发布时间</th>
						<th>操作</th>
                      </tr>
                  </thead>
                  <tbody>
                  	<c:forEach items="${newslist}" var="n">
                       <tr>
                       	<td>${n.nid}</td>
                           <td title="${n.title}" style="overflow: hidden;text-overflow:ellipsis;white-space: nowrap;">${n.title}</td>
                           <td>${n.uname}</td>
                           <td>${n.pubtime}</td>
                           <td style="white-space: nowrap;">
                           	<a href="newsDetailServlet?nid=${n.nid}" type="button" class="btn btn-success">查看</a>
                               <c:choose>
                               	<c:when test="${currentUser.type==1}">
                               		<a href="newsEditServlet?nid=${n.nid}&&type=query" type="button" class="btn btn-info">修改</a>
                                	<a href="newsDeleteServlet?nid=${n.nid}" class="btn btn-danger">删除</a>
                               	</c:when>
                               	<c:otherwise>
                               		<c:if test="${currentUser.uid==n.uid}">
                               			<a href="newsEditServlet?nid=${n.nid}&&type=query" type="button" class="btn btn-info">修改</a>
                               		</c:if>
                               	</c:otherwise>
                               </c:choose>
                               
                           </td>
                       </tr>
                      </c:forEach>
                  </tbody>
              </table>
              <div class="pull-right">
                  <ul class="pagination">
                      <li class="disabled">
                          <a href="newsListServlet?currentPage=${p.prevPage}&&title=${title}"><span>&laquo;</span></a>
                      </li>
                      <c:forEach begin="1" end="${p.totalPage}" var="cp">
							<li class="page"><a href="newsListServlet?currentPage=${cp}&&title=${title}"><span>${cp}</span></a></li>
					  </c:forEach>
                      <li>
                          <a href="newsListServlet?currentPage=${p.nextPage}&&title=${title}"><span>&raquo;</span></a>
                      </li>
                  </ul>
              </div>
          </div>
	</div>
	
	<!-- <div class="modal fade" id="myModal" tabindex="-1" role="dialog">
	       <div class="modal-dialog" role="document">
	           <div class="modal-content">
	               <div class="modal-header">
	                   <h4 class="modal-title" id="myModalLabel">删除记录</h4>
	               </div>
	               <div class="modal-body">
					确认要删除么？
	               </div>
	               <div class="modal-footer">
	                   <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>取消</button>
	                   <button type="button" id="btn_submit" class="btn btn-primary" data-dismiss="modal"><span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>确定</button>
	               </div>
	           </div>
	       </div>
	</div> -->
</body>
<script>
//function deleteAlert(){
//	$('#myModal').modal();
//}
</script>
</html>
