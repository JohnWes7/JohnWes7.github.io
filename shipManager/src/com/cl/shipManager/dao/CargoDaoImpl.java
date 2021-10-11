package com.cl.shipManager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cl.shipManager.entity.Cargo;


public class CargoDaoImpl extends DBhelper implements CargoDao{

	@Override
	public List<Cargo> findAll(String cargoId) {
		List<Cargo> list = new ArrayList<Cargo>();
		Connection conn = null;
		PreparedStatement pst =null;
		ResultSet rs = null;
		String sql = "select cargoId,cargoName,cargoWeight,shipId from Cargo ";
		if(cargoId != null && cargoId.length()>0){
			sql += " where cargoId = "+Integer.parseInt(cargoId);
		}
		try {
			conn = 	getConn();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
			
				//2:将船只信息存入对象
				Cargo s = new Cargo
					(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				//3:再将所有船只对象存入集合
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(conn, pst, rs);
		}
		return list;
	}

	@Override
	public List<Cargo> findAllByShip(String shipId){
		List<Cargo> list = new ArrayList<Cargo>();
		Connection conn = null;
		PreparedStatement pst =null;
		ResultSet rs = null;
		String sql = "select cargoId,cargoName,cargoWeight,shipId from Cargo ";
		if(shipId != null && shipId.length()>0){
			sql += " where shipId = "+Integer.parseInt(shipId);
		}
		try {
			conn = 	getConn();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
			
				//2:将船只信息存入对象
				Cargo s = new Cargo
					(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				//3:再将所有船只对象存入集合
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(conn, pst, rs);
		}
		return list;
	}
	public boolean delCargo(int id) {
		String sql="delete from Cargo where cargoId =?";
		Object[] param={id};
		return sqlUpdate(sql, param);
	}

	@Override
	public boolean updCargo(Cargo cargo) {
		String sql = "update Cargo set cargoName=?,cargoWeight=?,shipId=? where cargoId=?";
		Object[] param ={cargo.getCargoName(),cargo.getCargoWeight(),cargo.getShipId(),cargo.getCargoId()};
		return sqlUpdate(sql, param);
	}

	@Override
	public boolean addCargo(Cargo cargo) {
		String sql = "insert into Cargo values(?,?,?,?)";
		Object[] param ={cargo.getCargoId(),cargo.getCargoName(),cargo.getCargoWeight(),cargo.getShipId()};
		return sqlUpdate(sql, param);
	}

}
