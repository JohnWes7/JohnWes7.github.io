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
		.div1{
            float: left;
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
  				<td>货物编号</td>
  				<td>货物名</td>
  				<td>货物重量</td>
  				<td>船只编号</td>
  				<td>操作</td>
  			</tr>
  		<c:forEach items="${list}" var="s">
  			<tr>
  				<td>${s.cargoId}</td>
  				<td>${s.cargoName}</td>
  				<td>${s.cargoWeight}</td>
  				<td>${s.shipId}</td>

  				<td><a href="javascript:if(confirm('是否删除？')){location.href='cargo.do?type=del&cargoId=${s.cargoId}'}">删除</a> 
  					<a href="cargo.do?type=findById&cargoId=${s.cargoId}">编辑</a>
  				</td>
  			</tr>
  		</c:forEach>
  	</table>
  	<div class="div1"><a href="ship.do?type=find">返回</a></div> <div id="add" class="div1"><a href="cargo.do?type=add">货物装船</a></div>
  </body>
</html>