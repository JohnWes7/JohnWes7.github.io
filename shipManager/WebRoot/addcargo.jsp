<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>货物装船</title>
    <script type="text/javascript">
    	function sub(){
    		 //1:获取船名
    		 var cargoName = document.getElementById("cargoName").value;
    		
    		 if(cargoName.length>20){ //判断船名长度
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
  	<h1>货物装船</h1>
  	<form action="cargo.do?type=add1" method="post">
  	货物编号<input type="text" name="cargoId" /><br>
  	货物名：<input type="text" name="cargoName" id="cargoName" />  <br>
  	重量：<input type="text" name="cargoWeight" id="cargoWeight" />  <br>
  	船只编号：<select name="shipId">
  				<c:forEach items="${ships}" var="c">
  					<c:choose>
  						<c:when test="${c.shipId!=null}">
  							<option selected value="${c.shipId}">${c.shipId}</option>
  						</c:when>
  						<c:otherwise>
  							<option value="${c.shipId}">${c.shipId}</option>
  						</c:otherwise>
  					</c:choose>
  				</c:forEach>
  		   </select>
  	
  	<input type="button" value="提交" onclick="sub()"/>
  	</form>
  	<a href="cargo.do?type=find">返回</a>
  	</div>
  </body>
</html>
