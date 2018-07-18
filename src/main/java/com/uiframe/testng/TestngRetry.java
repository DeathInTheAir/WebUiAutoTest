package com.uiframe.testng;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.uiframe.utils.Config;
import com.uiframe.utils.LoggerUtil;

public class TestngRetry implements IRetryAnalyzer{
	
    private static int maxRetryCount = Config.MAX_RETRY_TIMES;
    private int retryCount = 1;
	@Override
	public boolean retry(ITestResult result) {
		if (retryCount <= maxRetryCount) {
			String message = "测试类：'" + this.getClass().getName()
	        + "' 中的测试方法：'" + result.getName() + "' 执行失败，重试第 "
	        + retryCount + " 次";
	        LoggerUtil.info(message);
	        
	        retryCount++;
	        return true;
		}
	    return false;
	}
}
