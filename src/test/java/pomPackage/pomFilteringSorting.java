package pomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import basePackage.CreateAccount;

public class pomFilteringSorting extends CreateAccount {
	
	
	@FindBy(id="p_n_date/12035756011") WebElement NewArrival_30;
	@FindBy(id="p_n_date/12035757011") WebElement NewArrival_90;
	@FindBy(id="p_89/HP") WebElement Brand_HP;
	@FindBy(id="p_89/Canon") WebElement Brand_Canon;
	@FindBy(id="p_72/11192170011") WebElement CustomerRatings;
	@FindBy(id="s-result-sort-select") WebElement Sort;
	
	Select obj;
	public pomFilteringSorting(){
		PageFactory.initElements(driver, this);
	}
	
	public void NewArrival() {
	NewArrival_30.click();	
	}
	public void Brand() {
	Brand_HP.click();
	Brand_Canon.click();
	}
	public void CustomerRatings() {
		CustomerRatings.click();
	}
		

	public void Sorting() {
	obj = new Select(Sort);
		obj.selectByIndex(2);
	}
	
    public void Sort_Filter() {
    	obj = new Select(Sort);
    	NewArrival_90.click();
    	obj.selectByIndex(4);
    }
	
}
