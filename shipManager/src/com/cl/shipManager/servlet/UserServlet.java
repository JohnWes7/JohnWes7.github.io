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
		//������Ӧ�ַ���
		response.setContentType("text/html;charset=utf-8");
		//����������ַ���
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//ҵ��ַ�
		String type  = request.getParameter("type");
		if("login".equals(type)){ //��¼����
    		//1:�������������
    		String username = request.getParameter("logname");
    		String pwd = request.getParameter("logpass");
    		//2:�����ݿ⵱�н����ж�
    		UserDao ud = new UserDao();
    		if(ud.login(username, pwd)){//��¼�ɹ� 
    			out.print("<script>alert('��¼�ɹ���');location.href='ship.do?type=find';</script>");
    		}else{
    			//out.print("<script>alert('�˻������������');location.href='login.jsp';</script>");
    			response.sendRedirect("login.jsp");
    		}
		}else if("reg".equals(type)){//ע������
			String username = request.getParameter("userName");
			String psd = request.getParameter("psd");
			if(ud.register(username,psd)){
				out.print("<script>alert('ע��ɹ�.');location.href='user.do?type=login'</script>");
			}else out.print("<script>alert('ע��ʧ��.');location.href='user.do?type=login'</script>");
			System.out.print("����");
		}
		
		
		
		out.flush();
		out.close();
	}

}
