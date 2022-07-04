package com.mindtree;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class Selenium {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		//step 1
		
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.moneycontrol.com/");
		System.out.println(driver.getTitle());
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//step 2
		Actions action =new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//li[@cid='8']"))).build().perform();
		driver.findElement(By.xpath("//li[@cid='8']")).click();
		Set <String> str1=driver.getWindowHandles();
		Iterator <String> iterator1=str1.iterator(); 
		String p_screen=iterator1.next();
		String n_screen=iterator1.next();
		driver.switchTo().window(n_screen);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='tax_container' //input[@value='without']")).click(); 
		
		//step3
		 driver.findElement(By.xpath("//input[@id='age']")).sendKeys("22");
		 
		 //step4
		 Select selector=new Select(driver.findElement(By.className("custselect")));
		 selector.selectByVisibleText("stay in Non Metro city");
		 
		 //step5
		 driver.findElement(By.cssSelector("[title=Next]")).click();		
		
	}

}
