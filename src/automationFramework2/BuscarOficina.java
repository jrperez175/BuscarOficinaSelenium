package automationFramework2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import javax.swing.*;

public class BuscarOficina {

	public static void main(String[] args) throws InterruptedException {
		String url = "http://www.bancolombia.com.co";
		String direccionDeseada = JOptionPane.showInputDialog("Ingrese la direccion deseada");
		String agenciaSugerida = "";
		String direccionSugerida = "";
		String noDireccion = "";

		// FIREFOX
		// Desde Selenium 3.0 en adelante, necesitamos proporcionar explícitamente el
		// controlador de firefox (geckodriver)
		// ya que Firefox ya no proporciona el controlador incorporado por defecto.

		// System.setProperty("webdriver.firefox.marionette", "./geckodriver.exe");

		// Google Drive
		String exePathOficina = "D:\\chromedriver\\chromedriver.exe";
		String exePathCasa = "H:\\Software\\Automatizacion\\chromedriver_win32\\chromedriver.exe";

		System.setProperty("webdriver.chrome.driver", exePathOficina);

		// Creación de una nueva instacia del navegador
		// WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();

		// Maximizar la ventana del navegador
		driver.manage().window().maximize();

		// Ingresar a la URL
		driver.get(url);

		// Hacer click en la imagen visitanos
		driver.findElement(By.cssSelector("a[title=\"Visítanos\"]")).click();

		// Buscar Elemento ubicacion
		WebElement ubicacion = driver.findElement(By.id("srch-term"));

		// Digitar informacion
		ubicacion.sendKeys(direccionDeseada);

		// Hacer clic en el boton de busqueda
		driver.findElement(By.className("input-group-btn")).click();

		// Esperando 5 segundos para que se refresque la informacion

		esperartiempo(5);

		// Verifica que exista una agencia cerca, en caso positivo la selecciona

		noDireccion = driver.findElement(By.xpath("//*[@id='tab1']/div[1]/div[5]/label")).getText();

		if (noDireccion.isEmpty()) {
			agenciaSugerida = driver.findElement(By.xpath("//*[@id='tab1']/div[1]/div[6]/div[1]/div/div[2]/h3[1]"))
					.getText();
			direccionSugerida = driver.findElement(By.xpath("//*[@id='tab1']/div[1]/div[6]/div[1]/div/div[2]/p"))
					.getText();
			WebElement agencia = driver.findElement(By.xpath("//*[@id='tab1']/div[1]/div[6]/div[1]/div/div[1]/button"));
			agencia.click();

			// Mover el scroll hacia abajo para poder observar las agencias listadas

			// ((JavascriptExecutor)
			// driver).executeScript("arguments[0].scrollIntoView(true);", agencia);
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,250)", "");

			esperartiempo(5);

			// Mover el scroll hacia arriba para poder observar las agencia seleccionada

			// ((JavascriptExecutor)
			// driver).executeScript("arguments[0].scrollIntoView(true);", agencia);
			// ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-750)", "");

			// Limpiar la busqueda inicial y se digita la direccion sugerida
			esperartiempo(10);
			ubicacion.clear();
			ubicacion.sendKeys(direccionSugerida);

		}

		// Imprime en consola la Oficina y la direccion sugerida
		JOptionPane.showMessageDialog(null, agenciaSugerida + " " + "Direccion: " + direccionSugerida + noDireccion);
		System.out.println(agenciaSugerida + " " + "Direccion: " + direccionSugerida + noDireccion);

		// Cierra la automatizacion
		// esperartiempo(5);
		driver.quit();

	}

	public static void esperartiempo(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (Exception e) {
			System.out.println("Error en el espera");
		}
	}

}
