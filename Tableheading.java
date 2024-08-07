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

public class Tableheading {

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
public void gettableheading() {
	 WebElement tableelement=driver.findElement(By.xpath("//table[@class='dataTable']/thead"));
	 List<WebElement>rows=tableelement.findElements(By.tagName("tr"));	
	 
	 //use loop
	 for(WebElement rowelement:rows) {
	     List<WebElement>cells=rowelement.findElements(By.tagName("th"));
	     for(WebElement cellelement:cells) {
	    	 String celltext=cellelement.getText();
	    	 System.out.print("|"+celltext+"|\t");
	     }
	     System.out.println();
	 }
	 
}
@AfterSuite
public void closechromebrowser() {
	  driver.quit();
}
}
