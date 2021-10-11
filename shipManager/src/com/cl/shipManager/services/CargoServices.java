package com.cl.shipManager.services;

import java.util.List;

import com.cl.shipManager.entity.Cargo;

public interface CargoServices {
	/*��ѯ����*/
	public List<Cargo> findAll(String cargoId);
	public List<Cargo> findAllByShip(String shipId);
	/*ж��*/
	public boolean delCargo(int id);
	/*������Ϣ�޸�*/
	public boolean updCargo(Cargo cargo);
	/*װ��*/
	public boolean addCargo(Cargo cargo);
	/*������ѯ������Ϣ*/


}
