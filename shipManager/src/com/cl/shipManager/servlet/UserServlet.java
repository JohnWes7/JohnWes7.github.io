package com.cl.shipManager.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cl.shipManager.dao.UserDao;
import com.cl.shipManager.entity.Cargo;



public class UserServlet extends HttpServlet  {
	UserDao  ud = new UserDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置响应字符集
		response.setContentType("text/html;charset=utf-8");
		//设置请求的字符集
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//业务分发
		String type  = request.getParameter("type");
		if("login".equals(type)){ //登录请求
    		//1:接收请求的数据
    		String username = request.getParameter("logname");
    		String pwd = request.getParameter("logpass");
    		//2:在数据库当中进行判断
    		UserDao ud = new UserDao();
    		if(ud.login(username, pwd)){//登录成功 
    			out.print("<script>alert('登录成功。');location.href='ship.do?type=find';</script>");
    		}else{
    			//out.print("<script>alert('账户名或密码错误。');location.href='login.jsp';</script>");
    			response.sendRedirect("login.jsp");
    		}
		}else if("reg".equals(type)){//注册请求
			String username = request.getParameter("userName");
			String psd = request.getParameter("psd");
			if(ud.register(username,psd)){
				out.print("<script>alert('注册成功.');location.href='user.do?type=login'</script>");
			}else out.print("<script>alert('注册失败.');location.href='user.do?type=login'</script>");
			System.out.print("有了");
		}
		
		
		
		out.flush();
		out.close();
	}

}
