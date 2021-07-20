package com.testcases;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.basec.BaseClass;
import com.pages.SamplePage;
import com.pages.SamplePaymentPage;
import com.testdata.CustomDataProvider;

public class SampleTest extends BaseClass {

	public SampleTest() {
		super();
	}

	@BeforeTest
	public void setUp() {
		intialization();
		sample = new SamplePage();
		samplePayment = new SamplePaymentPage();
	}
	@Test(priority = 1, dataProvider = "test-data", dataProviderClass = CustomDataProvider.class)
	public void verifyPaymentScreen(String url) {
		sample.firstAssertion();
		Assert.assertEquals(sample.getCurrentUrl(), url);
	}
	@Test(priority = 2, dataProvider = "test-data", dataProviderClass = CustomDataProvider.class)
	public void verifySuccessMessage(String text) {
		
		samplePayment.SecondAssertion();
		String pageText = samplePayment.fetchingtext();		
		Assert.assertEquals(pageText, text);
	}
	@Test(priority = 3, dataProvider = "test-data", dataProviderClass = CustomDataProvider.class)
	public void verifyRechargeSuccess(String url) {
		Assert.assertEquals(samplePayment.getCurrentUrl(), url);
	}
}
