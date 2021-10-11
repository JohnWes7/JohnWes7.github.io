package com.cl.shipManager.dao;


import java.sql.*;

public class DBhelper {
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/*获得连接*/
	public Connection getConn(){
		String url ="jdbc:mysql://127.0.0.1:3306/shipmanager?useUnicode=true&characterEncoding=utf-8";	
		Connection conn = null;
		try {
			 conn = DriverManager.getConnection(url,"root","123456");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	/*通用更新的方法*/
	public boolean sqlUpdate(String sql,Object[] param){
		boolean bool = false;
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn=getConn();
			pst=conn.prepareStatement(sql);
			for(int i=0;i<param.length;i++){
				pst.setObject(i+1,param[i]);
			}
			bool =(pst.executeUpdate()>0);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{ //关闭对象
			close(conn, pst, null);
		}
		return bool;
	}
	
	
	/*关闭的方法*/
	public void close(Connection conn,PreparedStatement pst,ResultSet rs){
			try {
				if(rs != null){
					rs.close();
				}if(pst != null){
					pst.close();
				}if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
