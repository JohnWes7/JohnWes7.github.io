<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改货物信息</title>
    <script type="text/javascript">
    	function sub(){
    		 //1:获取货物名
    		 var cargoName = document.getElementById("cargoName").value;
    		 //2:获取货物重量
    		 var cargoWeight = document.getElementById("cargoWeight").value;
    		
    		 
    		 if(cargoName.length>20){ //判断货物名长度
    		 	alert("名称长度输入有误");
    		 	return;
    		 }
    		 document.getElementsByTagName("form")[0].submit();
    	}
    </script>
    <style type="text/css">
    #bodys{
    height: 250px;
        width: 1000px;
    margin: 0 auto;
    }
    </style>
  </head>
  <body>
  <div id="bodys">
  	<h1>修改货物信息</h1>
  	<form action="cargo.do?type=update" method="post">
  		<input type="hidden" name="cargoId" value="${cargo.cargoId}"/>
  	货物名：<input type="text" name="cargoName" id="cargoName" value="${cargo.cargoName}"/>  <br>
  	货物重量：<input type="text" name="cargoWeight" id="cargoWeight" value="${cargo.cargoWeight}"/>  <br>
  	船只编号：<input type="text" name="shipId" id="shipId" value="${cargo.shipId}"/>  <br>

  	
  	<input type="button" value="提交" onclick="sub()"/>
  	</form>

    	<a href="cargo.do?type=find">返回</a>
    	</div>
  </body>
</html>
