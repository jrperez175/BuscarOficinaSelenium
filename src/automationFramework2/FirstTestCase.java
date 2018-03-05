package automationFramework2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class FirstTestCase {

public static void main(String[] args) throws InterruptedException {
		String url="http://www.store.demoqa.com";
	
		//FIREFOX
		//Desde Selenium 3.0 en adelante, necesitamos proporcionar explícitamente el controlador de firefox (geckodriver) 
		//ya que Firefox ya no proporciona el controlador incorporado por defecto.
		
		//System.setProperty("webdriver.firefox.marionette", "./geckodriver.exe");
		
		//Google Drive
		String exePath = "D:\\chromedriver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		
	
		// Create a new instance of the Firefox driver
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		
        //Launch the Online Store Website
		driver.get(url);
		
		 
        // Print a Log In message to the screen
        System.out.println("Successfully opened the website www.Store.Demoqa.com");
 
		//Wait for 5 Sec
		Thread.sleep(5000);
		
        // Close the driver
        driver.quit();

}
}
