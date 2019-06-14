<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="header.jsp"></jsp:include>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                		<h2 class="col-sm-2">用户列表</h2>
	                    <form class="form-inline col-sm-10" role="form" action="userListServlet" method="post" style="margin-top: 20px">
						  <div class="form-group">
						    <label class="sr-only" for="title">用户名</label>
						    <input type="text" class="form-control" id="uname" name="uname" placeholder="请输入要查询的用户名">
						  </div>
						  <div class="form-group">
						    <label class="sr-only" for="profession">职业</label>
						    <select class="form-control" name="profession" id="profession">
						      <option value="student" selected>学生</option>
							  <option value="teacher">教师</option>
						    </select>
						  </div>
						  <button type="submit" class="btn btn-default">查询</button>
						</form>
                	</div>
                </div>
                <div class="panel-body">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>用户ID</th>
                                <th>用户名</th>
                                <th>性别</th>
                                <th>职业</th>
                                <th>个人爱好</th>
                                <th>用户类型</th>
                                <th>个人说明</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${userlist}" var="u">
                            <tr>
                                <td>${u.uid}</td>
                                <td>${u.uname}</td>
                                <td>${u.sex==1?'男':'女'}</td>
                                <td>${u.profession=='student'?'学生':'教师'}</td>
                                <td>${u.favourite}</td>
                                <td>${u.type==1?'管理员':'普通用户'}</td>
                                <td>${u.note}</td>
                                <td>
                                	<a href="userDetailServlet?uid=${u.uid}" type="button" class="btn btn-success">查看</a>
                                    <a href="userEditServlet?uid=${u.uid}&&type=query" type="button" class="btn btn-info">修改</a>
                                    <a href="userDeleteServlet?uid=${u.uid}" class="btn btn-danger" onclick="deleteAlert()">删除</a>
                                </td>
                            </tr>
                         </c:forEach>
                        </tbody>
                    </table>
                    <div class="pull-right">
                        <ul class="pagination">
                            <li class="disabled">
		                        <a href="userListServlet?currentPage=${p.prevPage}&&uname=${uname}&&profession=${profession}"><span>&laquo;</span></a>
		                    </li>
		                    <c:forEach begin="1" end="${p.totalPage}" var="cp">
								<li class="page"><a href="userListServlet?currentPage=${cp}&&uname=${uname}&&profession=${profession}"><span>${cp}</span></a></li>
							</c:forEach>
		                    <li>
		                        <a href="userListServlet?currentPage=${p.nextPage}&&uname=${uname}&&profession=${profession}"><span>&raquo;</span></a>
		                    </li>
                        </ul>
                    </div>
                </div>
            </div>


<div class="modal fade" id="myModal" tabindex="-1" role="dialog">
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
	</div>
	
	<script>
function deleteAlert(){
	$('#myModal').modal();
}
</script>
		
		
		
