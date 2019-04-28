package com.mkyong.test;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Test_IT5_Project {

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
	public void testCrearProyecto() throws Exception {
		driver.get("http://localhost:8080/SpringSecurity/login");
		driver.findElement(By.name("username")).sendKeys("celeste");
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.name("boton")).click();
		driver.get("http://localhost:8080/SpringSecurity/main/newProject");
		driver.findElement(By.name("organization")).sendKeys("1");
		driver.findElement(By.name("datamodel")).sendKeys("16");
		driver.findElement(By.name("personal")).sendKeys("31");
		driver.findElement(By.name("start_date")).sendKeys("2018-03-04");
		driver.findElement(By.name("finish_date")).sendKeys("2018-04-04");
		Thread.sleep(200);
		driver.findElement(By.name("guardarProj")).click();
		driver.close();

	}

	@Test
	public void testVisualizarProyectosAbiertos() throws Exception {
		driver.get("http://localhost:8080/SpringSecurity/login");
		driver.findElement(By.name("username")).sendKeys("celeste");
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.name("boton")).click();
		driver.get("http://localhost:8080/SpringSecurity/main/viewOpenProject");
		Thread.sleep(2000);
		driver.close();
	}

	@Test
	public void testVisualizarProyectosCerrados() throws Exception {
		driver.get("http://localhost:8080/SpringSecurity/login");
		driver.findElement(By.name("username")).sendKeys("celeste");
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.name("boton")).click();
		driver.get("http://localhost:8080/SpringSecurity/main/viewCloseProject");
		Thread.sleep(200);
		driver.close();
	}

}
