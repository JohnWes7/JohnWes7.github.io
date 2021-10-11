<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改船只信息</title>
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
  	<h1>修改船只信息</h1>
  	<form action="ship.do?type=update" method="post">
  		<input type="hidden" name="shipId" value="${ship.shipId}"/>
  		<input type="hidden" name="shipLoad" value="${ship.shipLoad}"/>
  	船名：<input type="text" name="shipName" id="shipName" value="${ship.shipName}"/>  <br>
  	出发地：<input type="text" name="shipDeparture" id="shipDeparture" value="${ship.shipDeparture}"/>  <br>
  	目的地：<input type="text" name="shipDestination" id="shipDestination" value="${ship.shipDestination}"/>  <br>
  	最大载荷：<input type="text" name="shipVolume" id="shipVolume" value="${ship.shipVolume}"/>  <br>
  	
  	<input type="button" value="提交" onclick="sub()"/>
  	</form>
  	<a href="ship.do?type=find">返回</a>
  	</div>
  </body>
</html>
