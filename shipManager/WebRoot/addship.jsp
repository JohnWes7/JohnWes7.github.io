<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>船只入港</title>
    <script type="text/javascript">
    	function sub(){
    		 //1:获取船名
    		 var shipName = document.getElementById("shipName").value;
    		 //2:获取出发地
    		 var shipDeparture = document.getElementById("shipDeparture").value;
    		 //3:获取目的地
    		 var shipDestination = document.getElementById("shipDestination").value;
    		 //5:获取最大载荷
    		 var shipVolume = document.getElementById("shipVolume").value;
    		 if(shipName.length>20){ //判断船名长度
    		 	alert("名称长度输入有误");
    		 	return;
    		 }
    		 if(shipDeparture.length>20){ //判断出发地名长度
    		 	alert("出发地长度输入有误");
    		 	return;
    		 }
    		 if(shipDestination.length>20){ //判断目的地名长度
    		 	alert("目的地长度输入有误");
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
  	<h1>船只入港</h1>
  	<form action="ship.do?type=add" method="post">
  	船只编号<input type="text" name="shipId" /><br>
  	船名：<input type="text" name="shipName" id="shipName" />  <br>
  	出发地：<input type="text" name="shipDeparture" id="shipDeparture" />  <br>
  	目的地：<input type="text" name="shipDestination" id="shipDestination" />  <br>
  	<input type="hidden" name="shipLoad"/ value="0">
  	最大载荷：<input type="text" name="shipVolume" id="shipVolume" />  <br>
  	
  	<input type="button" value="提交" onclick="sub()"/>
  	</form>
  	<a href="ship.do?type=find">返回</a>
  	</div>
  </body>
</html>
