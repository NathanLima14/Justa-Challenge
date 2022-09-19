package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {

	public WebDriver driver;
	
	public OrderPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Verifica se o produto está no carrinho
	public void verifyAndFinishOrder() {
		boolean product = driver.findElement(By.linkText("Faded Short Sleeve T-shirts")).isDisplayed();
		
		if(product==true) {
			driver.findElement(By.cssSelector(".standard-checkout > span")).click();
		}else {
			System.out.println("Produto não visível");
		}
	}
}
