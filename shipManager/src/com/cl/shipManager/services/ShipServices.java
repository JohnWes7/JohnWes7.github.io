package com.cl.shipManager.services;

import java.util.List;

import com.cl.shipManager.entity.Ship;

public interface ShipServices {
	/*查询所有*/
	public List<Ship> findAll(String shipId);
	/*船只出港*/
	public boolean delShip(int id);
	/*船只信息修改*/
	public boolean updShip(Ship ship);
	/*船只入港*/
	public boolean addShip(Ship ship);
	/*条件查询船只信息*/

}
