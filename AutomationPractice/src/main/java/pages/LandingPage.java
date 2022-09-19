package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

	public WebDriver driver;
		
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Clica no produto através do nome exibido
	public void addProduct() {
		driver.findElement(By.linkText("Faded Short Sleeve T-shirts")).click();
	}
}
