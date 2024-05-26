package br.com.agi.teste_qa.tela;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TelaUltimasBlog {
	
	private WebDriver driver;
	
	public TelaUltimasBlog(WebDriver webdriver)
	{
		this.driver = webdriver;
	}
	
	public void waitTitle()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='post-6665']/div[1]/header/h1")));
	}
	
	public String getTitle()
	{
		return driver.findElement(By.xpath("//*[@id='post-6665']/div[1]/header/h1")).getText();	
	}
	
}
