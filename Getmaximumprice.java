package com.tableevents;

import java.text.NumberFormat;
import java.text.ParseException;
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

public class Getmaximumprice {

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
public void getmaximumpriceincolumn() throws ParseException {
	String max;
	double m=0,maxcurrentprice=0;
	//no. of columns and print size
	List<WebElement>columns=driver.findElements(By.xpath("//*[@id='leftcontainer']/table/thead/tr/th"));	
	System.out.println("no of columns "+columns.size());
	
	//no. of rows and print size
	List<WebElement>rows=driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
	System.out.println("no of rows "+rows.size());
	
	//iterate over forloop for rows
	for(int i=1;i<rows.size();i++) {			
	    max=driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr['+i+']/td[4]")).getText();
	   // System.out.println(max);
	    NumberFormat f=NumberFormat.getNumberInstance();
	    Number num=f.parse(max);
	    max=num.toString();
	    m=Double.parseDouble(max); 
	    if(m>maxcurrentprice) {
	    	maxcurrentprice=m;
	    }
	}
	System.out.println("maximum current price "+maxcurrentprice);
}

@AfterSuite
public void closechromebrowser() {
	  driver.quit();
}
}
