<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户注册</title>
    <script type="text/javascript">
    	function sub(){
    		 //1:获取船名
    		 var userName = document.getElementById("userName").value;
    		 var psd = document.getElementById("psd").value;
    		 var ensurePsd = document.getElementById("ensurePsd").value;
    		
    		 if(userName.length>20){ //判断船名长度
    		 	return;
    		 }
    		 if(psd==ensurePsd){ //判断船名长度
    		 }else{
    		 alert("两次输入密码不一致");
    		 	return;
    		 }
    		 
    		 document.getElementsByTagName("form")[0].submit();
    	}
    </script>
    <style type="text/css">
    body{
    background-size: cover;
    background-repeat: no-repeat;
    background-image: url("https://gimg2.baidu.com/image_search/src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20180922%2F83bee5c3a43b4ecebc10528081b173f0.jpeg&refer=http%3A%2F%2F5b0988e595225.cdn.sohucs.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1628215058&t=dcbb4178df5aabf5ba8b9d8f091cdef4");
    }
    #bodys{
    height: 250px;
        width: 1000px;
    margin: 0 auto;
    }
    
    </style>
  </head>
  <body>
  <div id="bodys">
  	<h1>用户注册</h1>
  	<form action="user.do?type=reg" method="post">
  	用户名：<input type="text" name="userName" id="userName" placeholder="长度小于20的任意字符数字组合" class="content"/><br>
  	密码：<input type="text" name="psd" id="psd" class="content"/>  <br>
  	确认密码：<input type="text" name="ensurePsd" id="ensurePsd" class="content"/>  <br>
  	
  	
  	<input type="button" value="注册" onclick="sub()"/>
  	
  	</form>
  	<a href="user.do?type=login">返回</a>
  	</div>

  </body>
</html>
