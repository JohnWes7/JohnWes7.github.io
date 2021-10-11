<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 导入标签库 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>所有学员信息</title>
    <style type="text/css">
    	table {
			border-collapse: collapse;
			width: 60%;
			margin-left: 20%;
			font-size: 18px;
		}
		table,td{
			border: 1px solid black;	
			text-align: center;
		}
		#add{
		margin-left: 77%;
		font-size: 18px;
		}
    </style>
  </head>
  <body>
  	<table>
  			<tr>
  				<td>船只编号</td>
  				<td>船名</td>
  				<td>出发地</td>
  				<td>目的地</td>
  				<td>当前载重</td>
  				<td>最大载荷</td>
  				<td>操作</td>
  			</tr>
  		<c:forEach items="${list}" var="s">
  			<tr>
  				<td>${s.shipId}</td>
  				<td>${s.shipName}</td>
  				<td>${s.shipDeparture}</td>
  				<td>${s.shipDestination}</td>
  				<td>${s.shipLoad}</td>
  				<td>${s.shipVolume}</td>
  				<td><a href="javascript:if(confirm('是否出港？')){location.href='ship.do?type=del&shipId=${s.shipId}'}">船只出港</a> 
  					<a href="ship.do?type=findById&shipId=${s.shipId}">编辑</a>
  					<a href="cargo.do?type=find&shipId=${s.shipId}">查看货物</a>
  				</td>
  			</tr>
  		</c:forEach>
  	
  	</table>
  	<div id="add"><a href="addship.jsp">船只入港</a></div>
  </body>
</html>