package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShippingPage {

	public WebDriver driver;
	
	public ShippingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	//Aceita os termos de uso na página de shipping
	public void acceptTerms() {
		WebElement checkBoxElement = driver.findElement(By.id("cgv"));
		boolean isEnabled = checkBoxElement.isEnabled();

		if (isEnabled == true) {
			checkBoxElement.click();
		}
	}
	
	//Clica no botão "Proceed to checkout" na página de shipping
	public void proceed() {
		driver.findElement(By.cssSelector(".standard-checkout > span")).click();
	}
}
