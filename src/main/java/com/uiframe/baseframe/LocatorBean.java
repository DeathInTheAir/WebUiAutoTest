package com.uiframe.baseframe;

public class LocatorBean {
	
	private String elementName;
	private String by;
	private String locatorInfo;
	private int timeOut;
	private String eleType;
	
	public LocatorBean(String en,String by,String li,int time, String eleType){
		this.elementName = en;
		this.by = by;
		this.locatorInfo = li;
		this.timeOut = time;
		this.eleType = eleType;
	}
	
	public String getElementName() {
		return elementName;
	}
	public String getBy() {
		return by;
	}
	public String getLocatorInfo() {
		return locatorInfo;
	}
	public int getTimeOut() {
		return timeOut;
	}
	public String getEleType() {
		return eleType;
	}
	
	

}
