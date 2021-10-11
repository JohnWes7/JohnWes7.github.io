package com.cl.shipManager.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cl.shipManager.entity.Cargo;
import com.cl.shipManager.entity.Ship;
import com.cl.shipManager.services.CargoServices;
import com.cl.shipManager.services.CargoServicesImpl;
import com.cl.shipManager.services.ShipServices;
import com.cl.shipManager.services.ShipServicesImpl;


public class CargoServlet extends HttpServlet{

	CargoServices cs = new CargoServicesImpl();
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
		if("find".equals(type) || type==null){//查询操作  将list的值显示到jsp页面
			String shipId = request.getParameter("shipId");
			List<Cargo> list = cs.findAllByShip(shipId);
			//存值
			request.setAttribute("list", list);
			//跳转
			request.getRequestDispatcher("cargos.jsp").forward(request, response);
		}else if("del".equals(type)){
			int cargoId=Integer.parseInt(request.getParameter("cargoId"));
			if(cs.delCargo(cargoId)){
				out.print("<script>alert('删除成功.');location.href='cargo.do?type=find'</script>");
			}else out.print("<script>alert('修改失败.');location.href='cargo.do?type=find'</script>");
		}else if("findById".equals(type)){//通过编号查询学员信息
			String cargoId = request.getParameter("cargoId");
			Cargo cargo = cs.findAll(cargoId).get(0);
			request.setAttribute("cargo", cargo);
			request.getRequestDispatcher("cargoupdate.jsp").forward(request, response);
		}else if("update".equals(type)){
			String cargoId = request.getParameter("cargoId");
			String cargoName = request.getParameter("cargoName");
			String cargoWeight = request.getParameter("cargoWeight");
			String shipId= request.getParameter("shipId");
			Cargo cargo = new Cargo(Integer.parseInt(cargoId), cargoName, Integer.parseInt(cargoWeight), Integer.parseInt(shipId));
			if(cs.updCargo(cargo)){
				out.print("<script>alert('修改成功.');location.href='cargo.do?type=find'</script>");
			}else out.print("<script>alert('修改失败.');location.href='cargo.do?type=find'</script>");
		}else if("add".equals(type)){
			request.setAttribute("ships", ss.findAll(null));
			request.getRequestDispatcher("addcargo.jsp").forward(request, response);
		}
			else if("add1".equals(type)){
		
			String cargoId = request.getParameter("cargoId");
			String cargoName = request.getParameter("cargoName");
			String cargoWeight = request.getParameter("cargoWeight");
			String shipId= request.getParameter("shipId");
			Cargo cargo = new Cargo(Integer.parseInt(cargoId), cargoName, Integer.parseInt(cargoWeight), Integer.parseInt(shipId));
			if(cs.addCargo(cargo)){
				out.print("<script>alert('装货成功.');location.href='cargo.do?type=find'</script>");
			}else out.print("<script>alert('装货失败.');location.href='cargo.do?type=find'</script>");
			}
		out.flush();
		out.close();

}}
