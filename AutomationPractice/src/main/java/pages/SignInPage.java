package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {

	public WebDriver driver;
	
	public SignInPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By email = By.id("email");
	By password = By.id("passwd");
	
	
	//Faz login utilizando os dados providos no github
	public void login() {
		driver.findElement(email).sendKeys("candidato@justa.com.vc");
		driver.findElement(password).sendKeys("tamojusto");
		driver.findElement(By.cssSelector("#SubmitLogin > span")).click();
	}
}
