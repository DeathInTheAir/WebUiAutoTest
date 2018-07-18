package com.uiframe.samples;

public class Person {
	private Driver driver;

	public Person() {
	}

	public Person(Driver driver) {
		this.driver = driver;
	}

	public void drive() {
		driver.run();
	}

	public void setDriver(Driver driver) { // 运用参数多态,以后方便修改车型
		this.driver = driver;
	}

public static void main(String args[]){  
   Person p =new Person();  
//   JD jd = new JD();   //刚开始没钱就买辆JD吧  
//   p.setDriver(jd);  
//   p.drive();  
//   Benz benz = new Benz();//有钱换车了  
//   Driver dr = new JD();
   Driver dr = new Benz();
   p.setDriver(dr);  
   p.drive();  
}  
}