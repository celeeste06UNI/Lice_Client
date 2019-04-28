package com.mkyong.test;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Test_IT6_DataModel {

	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		String os = System.getProperty("os.name").toLowerCase();
		System.setProperty("webdriver.geckodriver", System.getProperty("user.dir") + "/geckodriver");
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("default");
		DesiredCapabilities dc = DesiredCapabilities.firefox();
		dc.setCapability(FirefoxDriver.PROFILE, myprofile);
		dc.setCapability("marionette", true);
		driver = new FirefoxDriver(dc);
	}

	@Test
	public void test1InferirModelo() throws Exception {
		driver.get("http://localhost:8080/SpringSecurity/login");
		driver.findElement(By.name("username")).sendKeys("celeste");
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.name("boton")).click();

		driver.get("http://localhost:8080/SpringSecurity/main/viewUpload");
		driver.findElement(By.name("sistemabbdd")).sendKeys("mysql");
		driver.findElement(By.name("version")).sendKeys("2");
		driver.findElement(By.id("archivo")).sendKeys("/Users/celeste/upload/mysql2.xml");

		Thread.sleep(200);
		driver.findElement(By.name("uploadFile")).click();
		driver.close();

	}

	@Test
	public void test2EliminarModelo() throws Exception {
		driver.get("http://localhost:8080/SpringSecurity/login");
		driver.findElement(By.name("username")).sendKeys("celeste");
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.name("boton")).click();
		driver.get("http://localhost:8080/SpringSecurity/actionDelete?database_name=classicmodels&version=2");
		Thread.sleep(200);
		driver.close();
	}
	

	@Test
	public void test3VisualizarTablas() throws Exception {
		driver.get("http://localhost:8080/SpringSecurity/login");
		driver.findElement(By.name("username")).sendKeys("celeste");
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.name("boton")).click();
		driver.get("http://localhost:8080/SpringSecurity/main/viewTable?id_datamodel=16");
		Thread.sleep(200);
		driver.close();
	}

	@Test
	public void test4VisualizarAtributos() throws Exception {
		driver.get("http://localhost:8080/SpringSecurity/login");
		driver.findElement(By.name("username")).sendKeys("celeste");
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.name("boton")).click();
		driver.get("http://localhost:8080/SpringSecurity/main/viewAttribute?table_name=assessmentReport");
		Thread.sleep(200);
		driver.close();
	}

}
