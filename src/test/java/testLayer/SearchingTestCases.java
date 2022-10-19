package testLayer;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.CreateAccount;
import pomPackage.pomSearching;

public class SearchingTestCases extends CreateAccount {

pomSearching Search;
	
	public SearchingTestCases() {
		super();
	}
	
	@BeforeMethod
	public void initial_setup() throws InterruptedException {
		initialization();
		Thread.sleep(3000);
		Search = new pomSearching();
	}
	
	@Test(priority=2)
	public void ProductPerPage() throws InterruptedException {
		Search.typeDescription(prop.getProperty("description"));
		int NoOfProducts = Search.Pagination();
	    Assert.assertEquals(NoOfProducts, 60);
		
	}
	
	
	@Test(priority=1)
	public void Searching() throws InterruptedException {
		Search.typeDescription(prop.getProperty("description"));
		Thread.sleep(2000);
		Search.typePartialItemText(prop.getProperty("PartialItemText"));
		Thread.sleep(2000);
		Search.typeItemNumber(prop.getProperty("ItemNumber"));
		Thread.sleep(2000);
		Search.typeCategoryKeyword(prop.getProperty("CategoryKeyword"));
		Thread.sleep(2000);
		Search.ProductInfo(prop.getProperty("description"));
		Thread.sleep(11000);
        //Assert.assertEquals(res1, false);	
        //if(res1.equals("false"))
        //System.out.println("All the products displayed are not relevant");
		
	}
	
	@Test(priority=3)
	public void NextButton() throws InterruptedException {
		Search.typeDescription(prop.getProperty("description"));
		Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,7000)", "");
		Search.NextButton();
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
}
