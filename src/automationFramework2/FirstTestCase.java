package automationFramework2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class FirstTestCase {

public static void main(String[] args) throws InterruptedException {
		
		//Desde Selenium 3.0 en adelante, necesitamos proporcionar explícitamente el controlador de firefox (geckodriver) 
		//ya que Firefox ya no proporciona el controlador incorporado por defecto.
		
		//System.setProperty("webdriver.gecko.driver", "D:/selenium-java-3.9.1/geckodriver.exe");
		System.setProperty("webdriver.firefox.marionette", "./geckodriver.exe");
		
		// Create a new instance of the Firefox driver
		WebDriver driver = new FirefoxDriver();
		
        //Launch the Online Store Website
		driver.get("http://www.store.demoqa.com");
 
        // Print a Log In message to the screen
        System.out.println("Successfully opened the website www.Store.Demoqa.com");
 
		//Wait for 5 Sec
		Thread.sleep(5000);
		
        // Close the driver
        driver.quit();

}
