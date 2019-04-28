package com.mkyong.test;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Test_IT4_Organization {
	
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
	public void testCrearOrganizacion() throws Exception {
		driver.get("http://localhost:8080/SpringSecurity/login");
		driver.findElement(By.name("username")).sendKeys("celeste");
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.name("boton")).click();
		driver.get("http://localhost:8080/SpringSecurity/main/newOrganization");
		driver.findElement(By.name("cif")).sendKeys("675893923");
		driver.findElement(By.name("name_org")).sendKeys("Organizacion de Prueba");
		driver.findElement(By.name("name_trade")).sendKeys("Organization S.A");
		driver.findElement(By.name("name_contact")).sendKeys("Celeste");
		driver.findElement(By.name("role_contact")).sendKeys("Directora de Sistemas");
		driver.findElement(By.name("telephone_contact")).sendKeys("344567");
		Thread.sleep(200);
		driver.findElement(By.name("guardarOrg")).click();
		driver.close();

	}

	@Test
	public void testEditarOrganizacion() throws Exception {
		driver.get("http://localhost:8080/SpringSecurity/login");
		driver.findElement(By.name("username")).sendKeys("celeste");
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.name("boton")).click();
		driver.get("http://localhost:8080/SpringSecurity/editOrganization?id=4");
		driver.findElement(By.name("name_contact")).clear();
		driver.findElement(By.name("name_contact")).sendKeys("Fernando");
		driver.findElement(By.name("updateOrg")).click();
		Thread.sleep(2000);
		driver.close();
	}

	@Test
	public void testEliminarOrganizacion() throws Exception {
		driver.get("http://localhost:8080/SpringSecurity/login");
		driver.findElement(By.name("username")).sendKeys("celeste");
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.name("boton")).click();
		driver.get("http://localhost:8080/SpringSecurity/deleteOrganization?id=5");
		Thread.sleep(200);
		driver.close();
	}


}
