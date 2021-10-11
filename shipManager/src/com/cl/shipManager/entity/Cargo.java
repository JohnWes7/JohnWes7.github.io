package com.cl.shipManager.entity;

public class Cargo {
	private int cargoId ;//货物编号
	private String cargoName ;//货物名
	private int cargoWeight ;//货物重量
	private int shipId ;//船只编号
	
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
