package Project.Selenium;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAuthentication {

	public static void main(String[] args) {
		


		WebDriver driver = new ChromeDriver();
		HasAuthentication authentication = (HasAuthentication) driver;
		authentication.register(() -> new UsernameAndPassword("admin", "admin"));
		driver.get("https://the-internet.herokuapp.com/basic_auth");
		
		
		
		
		
		
	}

	
	
}
