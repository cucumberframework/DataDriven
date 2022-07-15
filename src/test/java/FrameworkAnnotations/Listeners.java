package FrameworkAnnotations;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

import BaseTest.BaseClass;

public class Listeners extends FrameAnnotations implements ITestListener {
	public static ITestListener context; 

	public void onTestStart(ITestResult result) {

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test case success");
		try {
			takeScreenshot();
			test.log(LogStatus.PASS, test.addScreenCapture(destinationFileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test case has failed");
		try {
			takeScreenshot();
			test.log(LogStatus.FAIL, test.addScreenCapture(destinationFileName));
			test.log(LogStatus.INFO, "Test case has failed");
			test.log(LogStatus.INFO, result.getThrowable());
		} catch (IOException e) {
			
			test.log(LogStatus.INFO, e.getMessage());
		}

	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		Class x = context.getSuite().getAllMethods().listIterator().next().getRealClass();
		//		listIterator.next.getRealClass();
		//Then just take it as a String

		String name = x.getName().substring(x.getName().lastIndexOf(".")+1);
		System.out.println(name);
	}

	public void onFinish(ITestContext context) {

	}
}
