package Project.Selenium;
import java.time.Duration;import java.util.List;
import org.openqa.selenium.By;import org.openqa.selenium.JavascriptExecutor;import org.openqa.selenium.WebDriver;import org.openqa.selenium.WebElement;import org.openqa.selenium.chrome.ChromeDriver;import org.openqa.selenium.interactions.Actions;import org.openqa.selenium.support.ui.ExpectedConditions;import org.openqa.selenium.support.ui.WebDriverWait;
public class SVG_Graphs {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();	
	int attempts_scroll = 10;	
	int attemps_month_data = 120;	
	driver.get("https://www.covid19india.org/state/DL");	
	boolean ele_found = false;		
   WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(2L));	
	while (!ele_found) {		
	JavascriptExecutor js = (JavascriptExecutor) driver;	
		js.executeScript("window.scrollBy(0, 500);");	
		By ele = By.xpath("//div[contains(@class,'Up is-confirmed')]  //*[name()='svg'] //*[local-name()='circle']");
		try {
           w.until(ExpectedConditions.presenceOfElementLocated(ele));				                ele_found = true;	
		} 
catch (Exception e) {		
		--attempts_scroll;			
}
 finally {
				if (attempts_scroll == 0)
					break;		
	}		
}		
String start_month = "";	
	Actions action = new Actions(driver);	
	while (!start_month.equals("02 August")) {
			System.out.println(driver.findElement(By.xpath("//div[@class='stats is-confirmed']")).getText());
			System.out.println("-----------------------------");
			WebElement element = driver.findElement(By					.xpath("//div[contains(@class,'Up is-confirmed')]  //*[name()='svg'] //*[local-name()='circle']"));			action.moveToElement(element, -5, 0).perform();
			start_month = driver.findElement(By.xpath("//div[@class='stats is-confirmed']/h5[2]")).getText();
			--attemps_month_data;			if (attemps_month_data == 0) {				System.out.println("While condition not matched there is no such month so to avoid infinite loop we exit");				break;
			}		}		// printing one more 02 August data		System.out.println(driver.findElement(By.xpath("//div[@class='stats is-confirmed']")).getText());
	}
}
