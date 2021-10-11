package com.cl.shipManager.entity;

public class Ship {
	
	private int shipId;//编号
	private String shipName;//名字
	private String shipDeparture;//出发地
	private String shipDestination;//目的地
	private int shipLoad;//已用载荷
	private int shipVolume;//最大载荷
	
	
	public Ship() {
		super();
	}


	public Ship( int shipId,String shipName, String shipDeparture,
			String shipDestination, int shipLoad, int shipVolume) {
		super();
		this.shipName = shipName;
		this.shipId = shipId;
		this.shipDeparture = shipDeparture;
		this.shipDestination = shipDestination;
		this.shipLoad = shipLoad;
		this.shipVolume=shipVolume;
	}


	public String getShipName() {
		return shipName;
	}


	public void setShipName(String shipName) {
		this.shipName = shipName;
	}


	public int getShipId() {
		return shipId;
	}


	public void setShipId(int shipId) {
		this.shipId = shipId;
	}


	public String getShipDeparture() {
		return shipDeparture;
	}


	public void setShipDeparture(String shipDeparture) {
		this.shipDeparture = shipDeparture;
	}


	public String getShipDestination() {
		return shipDestination;
	}


	public void setShipDestination(String shipDestination) {
		this.shipDestination = shipDestination;
	}


	public int getShipLoad() {
		return shipLoad;
	}


	public void setShipLoad(int shipLoad) {
		this.shipLoad = shipLoad;
	}
	
	public int getShipVolume() {
		return shipVolume;
	}
	public void setShipVolume(int shipVolume) {
		this.shipVolume = shipVolume;
	}


	@Override
	public String toString() {
		return "Ship [shipId=" + shipId + ", shipName=" + shipName
				+ ", shipDeparture=" + shipDeparture + ", shipDestination="
				+ shipDestination + ", shipLoad=" + shipLoad + ", shipVolume="
				+ shipVolume + "]";
	}
	

}
