package pomPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import basePackage.CreateAccount;

public class pomAccountCreation extends CreateAccount {

	
 	@FindBy(id="nav-link-accountList-nav-line-1") WebElement starthere;
 	@FindBy(id="ap_customer_name") WebElement Yourname;
	@FindBy(id="ap_email") WebElement Number_email;
	@FindBy(id="ap_password") WebElement Password;
	@FindBy(id="ap_password_check") WebElement PasswordAgain;
	@FindBy(id="continue") WebElement Cont;
	
	
	public pomAccountCreation(){
		PageFactory.initElements(driver, this);
	}
	
	public void Starthere_btn() {
		Actions action = new Actions(driver);
		action.moveToElement(starthere).build().perform();
		WebElement sh = driver.findElement(By.cssSelector("#nav-flyout-ya-newCust > a"));
		Boolean result = sh.isEnabled();
		System .out.println("If result is true than start here button is clickable otherwise not:" + result);
		sh.click();
	}
	public void typeusername(String name) {
		Yourname.sendKeys(name);
	}
	
	public void typeEmail_number(String num) {
		Number_email.sendKeys(num);
	}
	
	public void typepassword(String psswd) {
		Password.sendKeys(psswd);
	}
	public void typepasswordagain(String psswd_again) {
		PasswordAgain.sendKeys(psswd_again);
	}
	
	public void clickbtn(){
		Cont.click();
	}
	
}








