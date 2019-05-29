package com.mkyong.test;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Test_IT8_Catalogue {
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
	public void testACrearCatalogo() throws Exception {
		driver.get("http://localhost:8080/SpringSecurity/login");
		driver.findElement(By.name("username")).sendKeys("celeste");
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.name("boton")).click();
		driver.get("http://localhost:8080/SpringSecurity/main/newCatalogue");
		driver.findElement(By.name("name")).sendKeys("CatalogoPrueba");
		driver.findElement(By.name("description")).sendKeys("Se ha creado");
		Thread.sleep(200);
		driver.findElement(By.name("guardarCat")).click();
		driver.close();

	}

	@Test
	public void testEditarCatalogo() throws Exception {
		driver.get("http://localhost:8080/SpringSecurity/login");
		driver.findElement(By.name("username")).sendKeys("celeste");
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.name("boton")).click();
		driver.get("http://localhost:8080/SpringSecurity/editCatalogue?id_catalogue=4");
		driver.findElement(By.name("name")).clear();
		driver.findElement(By.name("name")).sendKeys("PruebaEditar");
		driver.findElement(By.name("updateCat")).click();
		Thread.sleep(2000);
		driver.close();
	}
	@Test
	public void testEliminarCatalogo() throws Exception {
		driver.get("http://localhost:8080/SpringSecurity/login");
		driver.findElement(By.name("username")).sendKeys("celeste");
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.name("boton")).click();
		driver.get("http://localhost:8080/SpringSecurity/deleteCatalogue?id=8");
		Thread.sleep(200);
		driver.close();
	}


}
