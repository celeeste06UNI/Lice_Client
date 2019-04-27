package com.mkyong.test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class Test_IT3_User {
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
	public void testLogin() throws Exception {
		driver.get("http://localhost:8080/SpringSecurity/login");
		driver.findElement(By.name("username")).sendKeys("celeste");
		driver.findElement(By.name("password")).sendKeys("123456");
		Thread.sleep(200);
		driver.findElement(By.name("boton")).click();
		Thread.sleep(200);
		driver.close();
	}

	@Test
	public void testCrearUsuario() throws Exception {
		driver.get("http://localhost:8080/SpringSecurity/login");
		driver.findElement(By.name("username")).sendKeys("celeste");
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.name("boton")).click();
		driver.get("http://localhost:8080/SpringSecurity/main/newEmployee");
		driver.findElement(By.name("username")).sendKeys("usuarioCreadoenTest");
		driver.findElement(By.name("name")).sendKeys("Test");
		driver.findElement(By.name("email")).sendKeys("celestelopezgarrido@gmail.com");
		driver.findElement(By.name("address")).sendKeys("C/Prueba");
		driver.findElement(By.name("telephone")).sendKeys("600000000");
		driver.findElement(By.name("role")).sendKeys("USER");
		Thread.sleep(200);
		driver.findElement(By.name("guardar")).click();
		driver.close();

	}

	@Test
	public void testEditarUsuario() throws Exception {
		driver.get("http://localhost:8080/SpringSecurity/login");
		driver.findElement(By.name("username")).sendKeys("celeste");
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.name("boton")).click();
		driver.get("http://localhost:8080/SpringSecurity/editPersonal?id=31&username=Celeste");
		driver.findElement(By.name("address")).clear();
		driver.findElement(By.name("address")).sendKeys("C/Prueba");
		driver.findElement(By.name("updateUser")).click();
		Thread.sleep(2000);
		driver.close();
	}

	@Test
	public void testEliminarUsuario() throws Exception {
		driver.get("http://localhost:8080/SpringSecurity/login");
		driver.findElement(By.name("username")).sendKeys("celeste");
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.name("boton")).click();
		driver.get("http://localhost:8080/SpringSecurity/deletePersonal?id=66&username=Prueba");
		Thread.sleep(200);
		driver.close();
	}

}
