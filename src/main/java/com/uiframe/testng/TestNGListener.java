package com.uiframe.testng;


import java.util.Iterator;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.uiframe.utils.LoggerUtil;

public class TestNGListener extends TestListenerAdapter{
	

	//testng初始化
	@Override
	public void onStart(ITestContext testContext) {
		LoggerUtil.info("测试初始化");
		super.onStart(testContext);
	}
	//case开始
	@Override
	public void onTestStart(ITestResult tr) {
		LoggerUtil.info("【"+tr.getName()+"】测试用例开始执行");
		super.onTestStart(tr);
	}
	//case执行成功
	@Override
	public void onTestSuccess(ITestResult tr) {
		LoggerUtil.info("【"+tr.getName()+"】测试用例执行成功");
		super.onTestSuccess(tr);
	}
	//case执行失败
	@Override
	public void onTestFailure(ITestResult tr) {
		LoggerUtil.error("【"+tr.getName()+"】测试用例执行失败");
		super.onTestFailure(tr);
//		takeScreenShot(tr);
	}	
    //case被跳过
    @Override
    public void onTestSkipped(ITestResult tr) {
    	LoggerUtil.error("【"+tr.getName()+"】测试用例被跳过");
        super.onTestSkipped(tr);
//        takeScreenShot(tr);
    }    
 
    @Override
    public void onFinish(ITestContext testContext) {
    	LoggerUtil.info("测试执行完毕");
    	Iterator<ITestResult> listOfFailedTests = testContext.getFailedTests().getAllResults().iterator();
        while (listOfFailedTests.hasNext()) {
            ITestResult failedTest = listOfFailedTests.next();
            ITestNGMethod method = failedTest.getMethod();
            if (testContext.getFailedTests().getResults(method).size() > 1) {
                listOfFailedTests.remove();
            } else {
                if (testContext.getPassedTests().getResults(method).size() > 0) {
                    listOfFailedTests.remove();
                }
            }
        }
    }
    
}
