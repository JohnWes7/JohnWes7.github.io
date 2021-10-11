package com.cl.shipManager.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cl.shipManager.entity.Cargo;

public class UserDao extends DBhelper {
	//����������
	static{ //��̬�� ����ִ�У���һ��
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("�ף��������أ�");
			e.printStackTrace();
		}	
	}
	/* ��¼ true=�ɹ� false=ʧ��  */
	public boolean login(String username,String pwd){
		boolean bool = false;
		String sqlconn ="jdbc:mysql://127.0.0.1:3306/shipmanager";		
		try {	
			//1:������Ӷ���
			Connection conn = DriverManager
			.getConnection(sqlconn,"root","123456");
			//2:������������
			String sql = "select * from Userinfo where userName=? AND pwd=?";
			PreparedStatement pst = 
			conn.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2,pwd);
			//3:���������������ղ�ѯ���
			ResultSet rs = pst.executeQuery();
			//4:ѭ����ȡ��������
			while(rs.next()){//�Ƿ�����һ������
				bool = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bool;
	}
	public boolean register(String userName,String psd) {
		String sql = "insert into userinfo values(?,?)";
		Object[] param ={userName,Integer.parseInt(psd)};
		return sqlUpdate(sql, param);
	}
}
