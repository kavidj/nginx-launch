package com.nusyn.hrmate.model;

public class Data {
	  public String shopName;	
	  public int count;
	  public Data(String shopName,int count) {
		  this.shopName = shopName;
		  this.count = count;
	  }
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
