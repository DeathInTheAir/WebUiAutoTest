package com.uiframe.samples;

import com.alibaba.fastjson.JSONObject;

public class MaptoList {

	public static void main(String[] args) {
		JSONObject json = JSONObject.parseObject("{\"a\":\"b\"}");
		Object[][] ob =new  Object[2][2];
		ob[0][0] = json;
		System.out.println(ob[0][0]);
	}

}
