package com.tableevents;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Numberofrowsandcolumns {
      
	   protected static String url="https://demo.guru99.com/test/web-table-element.php#";
	   WebDriver driver;

@BeforeSuite 
public void startchromebrowser() {
	 WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();
	 driver.manage().window().maximize();
}	

@BeforeClass
public void openurl() {
	  driver.get(url);
}

@Test
public void testnumberofrowsandcolumns() {
	List<WebElement>columns=driver.findElements(By.xpath("//*[@id='leftcontainer']/table/thead/tr/th"));	
	System.out.println("no of columns "+columns.size());
	
	List<WebElement>rows=driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
	System.out.println("no of rows "+rows.size());
}
 
@AfterSuite
public void closechromebrowser() {
	  driver.quit();
}
}
