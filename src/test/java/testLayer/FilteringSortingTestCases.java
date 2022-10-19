package testLayer;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.CreateAccount;
import pomPackage.pomFilteringSorting;
import pomPackage.pomSearching;

public class FilteringSortingTestCases extends CreateAccount {

pomSearching S;
pomFilteringSorting fs;
	
	public FilteringSortingTestCases() {
		super();
	}
	
	@BeforeMethod
	public void initial_setup() throws InterruptedException {
		initialization();
		Thread.sleep(3000);
		S = new pomSearching();
		fs =  new pomFilteringSorting();
		
	}
	
	@Test(priority=2)
	public void FilterWith3op() throws InterruptedException {
		S.typeDescription(prop.getProperty("description"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
	     js.executeScript("window.scrollBy(0,150)", "");
		fs.Brand();
		fs.CustomerRatings();
	}
	
	
	@Test(priority=1)
	public void FilterWith1op() throws InterruptedException {
		S.typeDescription(prop.getProperty("description"));
		Thread.sleep(2000);
		 JavascriptExecutor js = (JavascriptExecutor) driver;
	     js.executeScript("window.scrollBy(0,550)", "");
		fs.NewArrival();
	}
	
	@Test(priority=3)
	public void Sorting() throws InterruptedException {
		S.typeDescription(prop.getProperty("description"));
		fs.Sorting();
	}
	
	@Test(priority=4)
	public void FilterSorting() throws InterruptedException {
		S.typeDescription(prop.getProperty("description"));
		fs.Sort_Filter();
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
}

