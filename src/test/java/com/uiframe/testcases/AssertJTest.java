package com.uiframe.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class AssertJTest {
  @Test
  public void f() {
	  String str = "123";
//	  Assert.assertEquals(str, null,"error");
//	  assertThat(str).isNullOrEmpty();
	  str = "Fordo";
	  assertThat(str).isEqualTo("Frodo").isEqualToIgnoringCase("frodo");
//	  fail("");
  }
}
