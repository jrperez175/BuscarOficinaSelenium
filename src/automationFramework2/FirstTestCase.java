package automationFramework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class FirstTestCase {

public static void main(String[] args) throws InterruptedException {
		String url="http://www.bancolombia.com.co";
	
		//FIREFOX
		//Desde Selenium 3.0 en adelante, necesitamos proporcionar explícitamente el controlador de firefox (geckodriver) 
		//ya que Firefox ya no proporciona el controlador incorporado por defecto.
		
		//System.setProperty("webdriver.firefox.marionette", "./geckodriver.exe");
		
		//Google Drive
		String exePathOficina = "D:\\chromedriver\\chromedriver.exe";
		String exePathCasa = "H:\\Software\\Automatizacion\\chromedriver_win32\\chromedriver.exe";
		
		System.setProperty("webdriver.chrome.driver", exePathCasa);
		
	
		// Create a new instance of the Firefox driver
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		
        //Launch the Online Store Website
		driver.get(url);
		
		 //Hacer click en la imagen visitanos
		
		
		driver.findElement(By.cssSelector("a[title=\"Visítanos\"]")).click();
		
		
		 // Buscar Elmento ubicacion
		WebElement ubicacion = driver.findElement(By.id("srch-term"));
		
		//Digitar informacion
		ubicacion.sendKeys("Cra. 52 #14-30, Medellín, Antioquia, Colombia");
		
		//Enviar informacion
		//this.ubicacion.submit();
		 
		 
		 
				
				
        // Print a Log In message to the screen
        System.out.println("Successfully opened the website www.Store.Demoqa.com");
 
		//Wait for 5 Sec
		Thread.sleep(1000);
		
        // Close the driver
        driver.quit();

}
}
