package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

	public WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Clica no botão "Add to cart"
	public void addToCart() {
		driver.findElement(By.cssSelector(".exclusive > span")).click();
	}
	
	//Clica no botão "Proceed to checkout" na página do produto
	public void toCheckout() {
		WebElement proceedButton = driver.findElement(By.cssSelector(".button-medium > span"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(proceedButton));
		driver.findElement(By.linkText("Proceed to checkout")).click();
	}
}
