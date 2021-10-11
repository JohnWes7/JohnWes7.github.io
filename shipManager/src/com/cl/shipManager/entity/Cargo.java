package com.cl.shipManager.entity;

public class Cargo {
	private int cargoId ;//������
	private String cargoName ;//������
	private int cargoWeight ;//��������
	private int shipId ;//��ֻ���
	
	public Cargo() {
		super();
	}

	public Cargo( int cargoId,String cargoName, int cargoWeight, int shipId) {
		super();
		this.cargoName = cargoName;
		this.cargoId = cargoId;
		this.cargoWeight = cargoWeight;
		this.shipId = shipId;
	}

	public String getCargoName() {
		return cargoName;
	}

	public void setCargoName(String cargoName) {
		this.cargoName = cargoName;
	}

	public int getCargoId() {
		return cargoId;
	}

	public void setCargoId(int cargoId) {
		this.cargoId = cargoId;
	}

	public int getCargoWeight() {
		return cargoWeight;
	}

	public void setCargoWeight(int cargoWeight) {
		this.cargoWeight = cargoWeight;
	}

	public int getShipId() {
		return shipId;
	}

	public void setShipId(int shipId) {
		this.shipId = shipId;
	}
	

}
