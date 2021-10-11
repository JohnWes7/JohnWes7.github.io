package com.cl.shipManager.services;

import java.util.List;

import com.cl.shipManager.dao.ShipDao;
import com.cl.shipManager.dao.ShipDaoImpl;
import com.cl.shipManager.entity.Ship;

public class ShipServicesImpl  implements ShipServices{
	ShipDao sd = new ShipDaoImpl();

	@Override
	public List<Ship> findAll(String shipId) {
		return sd.findAll(shipId);
	}

	@Override
	public boolean delShip(int id) {
		return sd.delShip(id);
	}

	@Override
	public boolean updShip(Ship ship) {
		return sd.updShip(ship);
	}

	@Override
	public boolean addShip(Ship ship) {
		return sd.addShip(ship);
	}
	

}
