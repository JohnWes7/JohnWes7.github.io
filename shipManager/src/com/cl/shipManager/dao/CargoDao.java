package com.cl.shipManager.dao;

import java.util.List;

import com.cl.shipManager.entity.Cargo;


public interface CargoDao {
	/*查询所有*/
	public List<Cargo> findAll(String cargoId);
	public List<Cargo> findAllByShip(String shipId);
	/*卸货*/
	public boolean delCargo(int id);
	/*货物信息修改*/
	public boolean updCargo(Cargo cargo);
	/*装货*/
	public boolean addCargo(Cargo cargo);
	/*条件查询货物信息*/

}
