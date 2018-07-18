package com.uiframe.samples;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class FastJsonTest {

	public static void main(String[] args) {
		
//		String reqText = "{\"protcolver\":\"2.1\",\"app\":{\"bundle\":\"com.zyb.test.pkg\",\"id\":\"zybappid\",\"storeurl\":\"test.zyb.com\",\"ver\":\"1.14\"},\"authid\":\"zybauthid\",\"device\":{\"carrier\":46002,\"connectiontype\":6,\"devicetype\":2,\"did\":\"18705305190\",\"didha\":0,\"dpid\":\"zybtestadid\",\"dpidha\":0,\"geo\":{\"latitude\":100,\"longitude\":101},\"h\":1280,\"ifa\":\"zybtestaaid\",\"ip\":\"\",\"mac\":\"zy:bt:es:tm:ac\",\"macha\":0,\"make\":\"ifly\",\"model\":\"ifly1s\",\"orientation\":0,\"os\":\"ios\",\"osv\":\"1.0\",\"ppi\":300,\"ua\":\"Mac OS X\",\"w\":960},\"imp\":[{\"actiontype\":0,\"id\":\"C8D845E44026443A67BD7218E8F2DD4E\",\"context\":{},\"video\":{\"minduration\":\"5\",\"maxduration\":\"60\",\"num\":1}}],"
//				+ "\"token\":\"zybtoken\",\"user\":{\"id\":\"zybuserid\"}}";
		
		String reqText2 = "{\"protcolver\":\"1.2\",\"device\":{\"a\":\"1\",\"b\":\"2\"},\"authid\":\"au123\",\"token\":\"to123\"}";
		RequestBody reqJson = JSONObject.parseObject(reqText2, RequestBody.class);
		 String protcolver = reqJson.protcolver;
		 System.out.println("---属性值---"+protcolver);
		 
		 
//		String protcolverContent = reqJson.getString("protcolver");
//		System.out.println("protcolver属性值---"+protcolverContent);
//		for(Entry<String, Object> entry:reqJson.entrySet()){
//			System.out.println(entry.getKey()+":"+entry.getValue());
//		}
	
	}
	static class RequestBody {
		String protcolver;
		Device device;
		String authid;
		String token;
//		ArrayList<Object> imp;

	}
	static class Device {
		String os;
		String orientation;
		String ip;		
	}
	static class Video {
		String id;
		String actiontype;
		Video video;		
	}
}
