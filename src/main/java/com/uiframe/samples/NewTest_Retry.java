package com.uiframe.samples;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.uiframe.utils.AssertUtils;
import com.uiframe.utils.LoggerUtil;

public class NewTest_Retry {
  @BeforeTest
  public void f() {
	  int s1 = add(1,2);
	  LoggerUtil.info("one:"+s1);
	  Assert.assertEquals(3, s1);
	  int s2 = sub(1,2);
	  LoggerUtil.info("two:"+s2);
	  AssertUtils at1 = new AssertUtils();
	  at1.checkIntNum(s2, 3, "检查s2结果");
  }
  
  @Test
  public void f2() {
	  int s1 = add(1,2);
	  LoggerUtil.info("one:"+s1);
	  AssertUtils at1 = new AssertUtils();
	  at1.checkIntNum(s1, 3, "检查s1结果");
  }
  
  public int add(int a, int b){
	  int s = a + b;
	  return s;
  }
  public int sub(int a, int b){
	  int s = a - b;
	  return s;
  }
}
