package basePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import utilities.Timeutility;

public class CreateAccount {

		public static Properties prop = new Properties();
		public static WebDriver driver;
		//Step 1 Constructor to read file 
		public CreateAccount() {
			try {
				
			FileInputStream file = new FileInputStream("C:\\Users\\Administrator\\eclipse-workspace\\Amazon\\src\\test\\java\\environmentVariables\\Config");
			prop.load(file);
			}
			catch(FileNotFoundException e) {
			e.printStackTrace();
			}
			catch(IOException a) {
				a.printStackTrace();
			}
		}
		
		//Step 2 Reading properties from config file
		public static void initialization() {
			String bname = prop.getProperty("browser");
			if(bname.equals("edgedriver")) {
				System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
				driver = new EdgeDriver();
			}
			if(bname.equals("chrome")){
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				driver = new ChromeDriver();
			}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Timeutility.timepage,TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
			
		}
		
	}


