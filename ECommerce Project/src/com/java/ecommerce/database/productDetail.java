package com.java.ecommerce.database;

public class productDetail {
	int id ;
	String pdName;
	String pdDis ;
	int prc ;
	int qty ;
	public productDetail(int id, String pdName, String pdDis, int prc, int qty) {
		super();
		this.id = id;
		this.pdName = pdName;
		this.pdDis = pdDis;
		this.prc = prc;
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "productDetail [id=" + id + ", pdName=" + pdName + ", pdDis=" + pdDis + ", prc=" + prc + ", qty=" + qty
				+ "]";
	}
	
}
