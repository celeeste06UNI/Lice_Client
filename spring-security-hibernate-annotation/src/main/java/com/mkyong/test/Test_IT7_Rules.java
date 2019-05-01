package com.mkyong.test;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Test_IT7_Rules {

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
	public void testDefinirRegla() throws Exception {
		driver.get("http://localhost:8080/SpringSecurity/login");
		driver.findElement(By.name("username")).sendKeys("celeste");
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.name("boton")).click();

		driver.get("http://localhost:8080/SpringSecurity/main/selectProject?project=10&numberAt=1");
		driver.findElement(By.name("operador")).sendKeys("Es oligatorio que"); //
		driver.findElement(By.name("cuantificador1")).sendKeys("");
		driver.findElement(By.name("termino1")).sendKeys("email");
		driver.findElement(By.name("verbo1")).sendKeys("sea");
		driver.findElement(By.name("operadorLogi1")).sendKeys("-");
		driver.findElement(By.name("valorAt1")).sendKeys("UNIQUE");
		driver.findElement(By.name("propiedad")).sendKeys("Precision semantica");
		driver.findElement(By.name("estado")).sendKeys("Elicitada");
		driver.findElement(By.name("criticidad")).sendKeys("alta");
		driver.findElement(By.name("prioridad")).sendKeys("baja");
		driver.findElement(By.name("version")).sendKeys("1");
		driver.findElement(By.name("catalogo")).sendKeys("0");
		Thread.sleep(200);
		driver.findElement(By.name("guardarRegla")).click();
		driver.close();

	}

	@Test
	public void testVisualizarReglas() throws Exception {
		driver.get("http://localhost:8080/SpringSecurity/login");
		driver.findElement(By.name("username")).sendKeys("celeste");
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.name("boton")).click();
		driver.get("http://localhost:8080/SpringSecurity/main/viewRule");
		Thread.sleep(2000);
		driver.close();
	}

	@Test
	public void testEditarRegla() throws Exception {
		driver.get("http://localhost:8080/SpringSecurity/login");
		driver.findElement(By.name("username")).sendKeys("celeste");
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.name("boton")).click();
		driver.get("http://localhost:8080/SpringSecurity/main/viewRule");
		driver.findElement(By.name("viewMore")).click();
		driver.findElement(By.name("estado")).sendKeys("Cerrada");
		driver.findElement(By.name("updateR")).click();
		Thread.sleep(2000);
		driver.close();
	}

	@Test
	public void testEliminarRegla() throws Exception {
		driver.get("http://localhost:8080/SpringSecurity/login");
		driver.findElement(By.name("username")).sendKeys("celeste");
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.name("boton")).click();
		driver.get("http://localhost:8080/SpringSecurity/deleteRule?id_rule=32");
		Thread.sleep(2000);
		driver.close();
	}

}
