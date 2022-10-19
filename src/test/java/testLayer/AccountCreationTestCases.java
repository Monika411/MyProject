package testLayer;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.CreateAccount;
import pomPackage.pomAccountCreation;
import testData.ExcelSheet;


public class AccountCreationTestCases extends CreateAccount {

pomAccountCreation Acc;
	
	public AccountCreationTestCases() {
		super();
	}
	
	@BeforeMethod
	public void initial_setup() throws InterruptedException {
		initialization();
		Thread.sleep(3000);
		Acc = new pomAccountCreation();
	}
	
	@Test(priority=1)
	public void StartHere_btn() throws InterruptedException {
		Acc.Starthere_btn();
		Thread.sleep(3000);
	}
	
	//@DataProvider
	//public Object[][] Details(){
		//Object[][] data = ExcelSheet.readData("Sheet1");
		//return data;
	//}
	
	@Test(priority=2)
	public void Account() throws InterruptedException {
		Acc.typeusername(prop.getProperty("Name"));
		Thread.sleep(3000);
		Acc.typeEmail_number(prop.getProperty("Email"));
		Thread.sleep(3000);
		Acc.typepassword(prop.getProperty("Password"));
		Thread.sleep(3000);
		Acc.typepasswordagain(prop.getProperty("PasswordAgain"));
		//Acc.clickbtn();
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}

	
}
