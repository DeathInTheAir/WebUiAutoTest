package com.uiframe.baseframe;

public class LocatorBean {
	
	private String elementName;
	private String by;
	private String locatorInfo;
	private int timeOut;
	
	public LocatorBean(String en,String by,String li,int time){
		this.elementName = en;
		this.by = by;
		this.locatorInfo = li;
		this.timeOut = time;
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
	
	

}
