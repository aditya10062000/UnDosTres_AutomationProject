package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.basec.BaseClass;

public class SamplePaymentPage extends BaseClass {

	// Page Factory - 
	@FindBy(xpath = "//body[1]/div[32]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/a[1]/div[1]/div[1]/span[1]")
	WebElement tarjeta;
	@FindBy(xpath = "//body[1]/div[32]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]")
	WebElement usarNuevaTarjeta;
	@FindBy(xpath = "//body[1]/div[32]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[1]/div[1]/input[1]")
	WebElement numeroDetarjeta;
	@FindBy(xpath = "//body[1]/div[32]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[1]/div[2]/form[1]/div[3]/div[1]/div[1]/div[1]/input[1]")
	WebElement mes;
	@FindBy(xpath = "//body[1]/div[32]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[1]/div[2]/form[1]/div[3]/div[1]/div[1]/div[3]/input[1]")
	WebElement ano;
	@FindBy(xpath = "//body[1]/div[32]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[1]/div[2]/form[1]/div[3]/div[2]/div[1]/input[1]")
	WebElement cvv;
	@FindBy(xpath = "//body[1]/div[32]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[1]/div[2]/form[1]/div[4]/div[1]/div[1]/input[1]")
	WebElement correoElectronico;
	@FindBy(xpath = "//body[1]/div[32]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[5]/div[1]/button[1]")
	WebElement pagarConTarjeta;
	@FindBy(xpath = "//body[1]/div[5]/div[1]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/form[1]/div[1]/input[1]")
	WebElement telefonoMovil;
	@FindBy(xpath = "//body[1]/div[5]/div[1]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/form[1]/div[2]/input[1]")
	WebElement contrasena;
	@FindBy(xpath = "//body[1]/div[5]/div[1]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/form[1]/div[4]")
	WebElement captcha;
	@FindBy(xpath = "//body[1]/div[5]/div[1]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/form[1]/button[1]")
	WebElement acceso;
	@FindBy(xpath = "//*[@id=\"mainBlueContainer\"]/div/div[1]/div[1]/div[1]/div[2]")
	WebElement fetchtext;
	

	// Initializing the Page Objects:
	public SamplePaymentPage() {
		PageFactory.initElements(driver, this);
	}
	public void SecondAssertion()
	{
		selectCard();
		enterCredential();
		payWithCard();
		popUpCredential();
		fetchingtext();
	}

	public void selectCard() {		
		tarjeta.click();
		Actions builder = new Actions(driver);
		builder.moveToElement(usarNuevaTarjeta).click(usarNuevaTarjeta);
		builder.perform();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
	public void enterCredential()
	{
		String numeroDe = prop.getProperty("numeroDeTarjeta");
		String mon = prop.getProperty("mes");
		String anoo = prop.getProperty("ano");
		String CVV = prop.getProperty("CVV");
		String email = prop.getProperty("correoElectronico");
		numeroDetarjeta.sendKeys(numeroDe);
		mes.sendKeys(mon);
		ano.sendKeys(anoo);
		cvv.sendKeys(CVV);
		correoElectronico.sendKeys(email);
	}
	public void payWithCard()
	{
		pagarConTarjeta.click();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void popUpCredential()
	{
		String telefono = prop.getProperty("telefonoMovil");
		String pass = prop.getProperty("contrasena");
		
		telefonoMovil.sendKeys(telefono);
		contrasena.sendKeys(pass);
		captcha.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Actions builder = new Actions(driver);
		builder.moveToElement(acceso).click(acceso);
		builder.perform();
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public String fetchingtext() {
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String text=fetchtext.getText();
		return text;	
	}
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
}