package com.cl.shipManager.services;

import java.util.List;





import com.cl.shipManager.dao.CargoDao;
import com.cl.shipManager.dao.CargoDaoImpl;
import com.cl.shipManager.entity.Cargo;

public class CargoServicesImpl implements CargoServices{
	CargoDao cd = new CargoDaoImpl();

	@Override
	public List<Cargo> findAll(String cargoId) {
		return cd.findAll(cargoId);
	}
	public List<Cargo> findAllByShip(String shipId){
		return cd.findAllByShip(shipId);
	}

	@Override
	public boolean delCargo(int id) {
		return cd.delCargo(id);
	}

	@Override
	public boolean updCargo(Cargo cargo) {
		return cd.updCargo(cargo);
	}

	@Override
	public boolean addCargo(Cargo cargo) {
		return cd.addCargo(cargo);
	}

}
