package com.tableevents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Fetchdatavaluesofcells {

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
public void gecellvalueofrowandcolumn() {
	WebElement tablerow3=driver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[3]"));
	String rowtext=tablerow3.getText();
	System.out.println("third row of table "+rowtext);
	
	WebElement tablerow3column3=driver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[3]/td[3]"));
	String celltext=tablerow3column3.getText();
	System.out.println(celltext);
}

@AfterSuite
public void closechromebrowser() {
	  driver.quit();
}
}
