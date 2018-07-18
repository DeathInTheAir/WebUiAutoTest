package com.uiframe.utils;

import java.util.Map;

import org.json.JSONObject;

import com.uiframe.utils.LoggerUtil;

public class TestCaseBean {
	
	private String caseID;
	private String instruction;
	private String expectedResult;
	private String testData;
//	private Map<String,String> testDatas;
//	testDatas.put
	
	public TestCaseBean(String c,String i,String r,String t){
		caseID = c;
		instruction = i;
		expectedResult = r;
		testData = t;
	}
	
	public String getCaseID() {
		return caseID;
	}
	public String getInstruction() {
		return instruction;
	}
	public String getExpectedResult() {
		return expectedResult;
	}
	public String getTestData() {
		return testData;
	}
	
	public String getJsonValue(String key){
		String content = null;
		try{
			JSONObject jsonData = new JSONObject(getTestData());
			content = jsonData.get(key).toString();
		}catch(Exception e){
			
		}
		return content;
		
	}
	
	

}
