package com.comcast.listenerutility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.comcast.crm.basetest.BaseClass;

public class ListImpClass implements ITestListener, ISuiteListener {
	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report configuration");
	}

	public void onFinish(ISuite suite) {
		System.out.println("Reort backUP");
	}

	public void onTestStart(ITestResult result) {
		System.out.println("=====>" + result.getMethod().getMethodName() + "<===START==");
	}

	public void onTestSucess(ITestResult result) {
		System.out.println("=====>" + result.getMethod().getMethodName() + "<==END===");
	}

	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();

		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
		File srcFile = edriver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("./screenshot/" + testName + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSucessPercentage() {

	}
}
