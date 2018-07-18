package com.uiframe.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.uiframe.utils.LoggerUtil;

public class TestDemo {
	@BeforeTest
	public void setUp(){
		
	}
	@DataProvider(name="a")
	public String[][] getdata(){
		  int[] a={1,2,3,4};
			System.out.println(a[8]);
		return new String[][]{{"aaa","bbb"},{"ccc","ddd"}};
	}
  @Test
  public void f1() {
	  try{
		  int[] a={1,2,3,4};
		  System.out.println(a[8]);
	  }catch(Exception e){
		  LoggerUtil.error(e.toString());
		  Assert.fail();
	  }
	  System.out.println("f1++++++++++++");
	  Assert.assertEquals(1, 2);
  }
  @Test(dataProvider="a")
  public void f2(String a,String b) {
	  int[] c={1,2,3,4};
		System.out.println(c[3]);
	  System.out.println("f1");
  }
//  @AfterMethod
//  public void tearDown1(){
//	  int[] a={1,2,3,4};
//		System.out.println(a[8]);
//  }
  @AfterTest
  public void tearDown2(){
//	  int[] a={1,2,3,4};
//		System.out.println(a[8]);
  }
}
