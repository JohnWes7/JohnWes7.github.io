package com.cl.shipManager.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cl.shipManager.entity.Ship;

import com.cl.shipManager.services.ShipServices;
import com.cl.shipManager.services.ShipServicesImpl;

public class ShipServlet extends HttpServlet {
	ShipServices ss = new ShipServicesImpl();


	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String type = request.getParameter("type");
		if("find".equals(type) || type==null){//��ѯ����  ��list��ֵ��ʾ��jspҳ��
			List<Ship> list = ss.findAll(null);
			//��ֵ
			request.setAttribute("list", list);
			//��ת
			request.getRequestDispatcher("ships.jsp").forward(request, response);
		}else if("del".equals(type)){
			int shipId=Integer.parseInt(request.getParameter("shipId"));
			if(ss.delShip(shipId)){
				out.print("<script>alert('ɾ���ɹ�.');location.href='ship.do?type=find'</script>");
			}else out.print("<script>alert('�޸�ʧ��.');location.href='ship.do?type=find'</script>");
		}else if("findById".equals(type)){//ͨ����Ų�ѯѧԱ��Ϣ
			String shipId = request.getParameter("shipId");
			Ship ship = ss.findAll(shipId).get(0);
			request.setAttribute("ship", ship);
			request.getRequestDispatcher("shipupdate.jsp").forward(request, response);
		}else if("update".equals(type)){
			String shipId = request.getParameter("shipId");
			String shipName = request.getParameter("shipName");
			String shipDeparture = request.getParameter("shipDeparture");
			String shipDestination= request.getParameter("shipDestination");
			String shipLoad = request.getParameter("shipLoad");
			String shipVolume = request.getParameter("shipVolume");
			Ship ship = new Ship(Integer.parseInt(shipId), shipName, shipDeparture, shipDestination, Integer.parseInt(shipLoad),Integer.parseInt(shipVolume));
			if(ss.updShip(ship)){
				out.print("<script>alert('�޸ĳɹ�.');location.href='ship.do?type=find'</script>");
			}else out.print("<script>alert('�޸�ʧ��.');location.href='ship.do?type=find'</script>");
		}else if("add".equals(type)){
			String shipId = request.getParameter("shipId");
			String shipName = request.getParameter("shipName");
			String shipDeparture = request.getParameter("shipDeparture");
			String shipDestination= request.getParameter("shipDestination");
			String shipLoad = request.getParameter("shipLoad");
			String shipVolume = request.getParameter("shipVolume");
			Ship ship = new Ship(Integer.parseInt(shipId), shipName, shipDeparture, shipDestination, Integer.parseInt(shipLoad),Integer.parseInt(shipVolume));
			if(ss.addShip(ship)){
				out.print("<script>alert('��۳ɹ�.');location.href='ship.do?type=find'</script>");
			}else out.print("<script>alert('���ʧ��.');location.href='ship.do?type=find'</script>");
		}
		out.flush();
		out.close();
	}

}
