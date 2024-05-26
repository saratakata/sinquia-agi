package br.com.agi.teste_qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;


public abstract class AbstractTestCase {

	protected static WebDriver driver;
	
	public static String pathEvidencias;
	public static String url;
	
	
	
	@BeforeClass
	public static void beforeClass() throws Exception {	
		
		
		
		Properties prop = getProp();
		
		url = prop.getProperty("URL");	
		pathEvidencias = prop.getProperty("Path_evidencias");
		
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	    System.setProperty("webdriver.chrome.driver", "./browser/chromedriver.exe");
	    driver = new ChromeDriver(capabilities);
	    driver.manage().window().maximize();
				
	}
	 
	public static Properties getProp() throws IOException {
		Properties props = new Properties();
		FileInputStream file = new FileInputStream(
				"./properties/acesso.properties");
		props.load(file);
		return props;

	}
	

	public void screenRoll (String xpath ) {
		 WebElement element = driver.findElement(By.xpath(xpath));
	        new Actions(driver)
	                .moveToElement(element)
	                .perform();
	}
	
	
	@AfterClass
	public static void afterClass() throws Exception {
		if (driver != null) {
			driver.close();
			driver.quit();
		}
	}
	
}
