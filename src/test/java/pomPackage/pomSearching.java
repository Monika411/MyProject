package pomPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.CreateAccount;

public class pomSearching extends CreateAccount{
	
	@FindBy(id="twotabsearchtextbox") WebElement SearchBox;
	@FindBy(id="nav-search-submit-button") WebElement Searchbtn;
	@FindBy(xpath="//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[1]") WebElement pageno;
	@FindBy(xpath="//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[67]/div/div/span/a[3]") WebElement Nextbtn;
	

	public pomSearching(){
		PageFactory.initElements(driver, this);
	}
	
	public void typeDescription(String desc) {
		SearchBox.sendKeys(desc);
		Searchbtn.click();
	}
	public void typePartialItemText(String ptext) {
		SearchBox.clear();
		SearchBox.sendKeys(ptext);
		Searchbtn.click();
	}
	public void typeItemNumber(String INo) {
		SearchBox.clear();
		SearchBox.sendKeys(INo);
		Searchbtn.click();
	}
	public void typeCategoryKeyword(String CtgKeyword) {
		SearchBox.clear();
		SearchBox.sendKeys(CtgKeyword);
		Searchbtn.click();
	}

	public void ProductInfo(String descrip) {
		List<WebElement> Products = driver.findElements(By.xpath("//body/div[@id='a-page']/div[@id='search']/div[1]/div[1]/div[1]/span[3]/div[2]/div[*]"));
		String res = null;  
		for(WebElement j : Products) {
				if((j.getText()).contains(descrip))
	        		res="true";
	        		else
	        		 res="false";
		}
		System.out.println(res);
		
	}
	
	public int Pagination() {
		String pagination[]=pageno.getText().split(" ");
        String product_no[]=pagination[0].split("-");
        int TotNoOfProduct = (Integer.parseInt(product_no[1])-Integer.parseInt(product_no[0]))+1;
        return TotNoOfProduct;
	}
	
	public void NextButton() {
		Boolean result = Nextbtn.isEnabled();
		System.out.println("Next button is clickable: "+ result);
	}
}
