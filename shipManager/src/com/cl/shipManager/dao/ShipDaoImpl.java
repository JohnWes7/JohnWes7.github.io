package com.cl.shipManager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cl.shipManager.entity.Ship;


public class ShipDaoImpl extends DBhelper implements ShipDao{

	@Override
	public List<Ship> findAll(String shipId) {
		List<Ship> list = new ArrayList<Ship>();
		Connection conn = null;
		PreparedStatement pst =null;
		ResultSet rs = null;
		String sql = "select shipId,shipName,shipDeparture,shipDestination,shipLoad,shipVolume from Ship ";
		if(shipId != null && shipId.length()>0){
			sql += " where shipId = "+Integer.parseInt(shipId);
		}
		try {
			conn = 	getConn();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
			
				//2:将船只信息存入对象
				Ship s = new Ship
					(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
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
	public boolean delShip(int id) {
		String sql="delete from Ship where shipId =?";
		Object[] param={id};
		return sqlUpdate(sql, param);
	}

	@Override
	public boolean updShip(Ship ship) {
		String sql = "update Ship set shipName=?,shipDeparture=?,shipDestination=?,shipVolume=? where shipId=?";
		Object[] param ={ship.getShipName(),ship.getShipDeparture(),ship.getShipDestination(),ship.getShipVolume(),ship.getShipId()};
		return sqlUpdate(sql, param);
	}

	@Override
	public boolean addShip(Ship ship) {
		String sql = "insert into Ship values(?,?,?,?,?,?)";
		System.out.print(ship.getShipId()+ship.getShipName()+ship.getShipDeparture()+ship.getShipDestination()+ship.getShipLoad()+ship.getShipVolume());
		Object[] param ={ship.getShipId(),ship.getShipName(),ship.getShipDeparture(),ship.getShipDestination(),ship.getShipLoad(),ship.getShipVolume()};
		return sqlUpdate(sql, param);
	}

}
