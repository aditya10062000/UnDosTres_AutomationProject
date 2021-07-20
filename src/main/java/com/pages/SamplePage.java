package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.pages.SamplePage;
import com.basec.BaseClass;

public class SamplePage extends BaseClass {

	// Page Factory - OR:

	@FindBy(xpath = "//body[1]/div[3]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/div[1]/div[1]/input[1]")
	WebElement Operator;
	@FindBy(xpath = "//body[1]/div[3]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]/div[1]/b[1]")
	WebElement OperatorSelection;
	@FindBy(xpath="//body[1]/div[3]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[2]/div[1]/div[1]/input[1]")
	WebElement Number;
	@FindBy(xpath="//body[1]/div[3]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[3]/div[1]/div[1]/input[1]")
	WebElement dollar;
	@FindBy(xpath="//body[1]/div[3]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[3]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]")
	WebElement dollar10;
	@FindBy(xpath="//body[1]/div[3]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[3]/div[1]/button[1]")
	WebElement siguient;
	
	// Initializing the Page Objects:
	public SamplePage() {
		PageFactory.initElements(driver, this);
	}
	public void firstAssertion()
	{
		SelectOperator();
		EnterNumber();
		SelectDollar();
		siguiente();
	}

	public void SelectOperator() {
		Operator.click();
		OperatorSelection.click();
	}
	public void EnterNumber()
	{
		String num = prop.getProperty("Numero_de_celular");
		Number.sendKeys(num);
	}
	public void SelectDollar()
	{
		dollar.click();
		dollar10.click();	
	}
	public void siguiente()
	{
		siguient.click();
	}
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

}