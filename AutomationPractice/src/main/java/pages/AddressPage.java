package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressPage {
	
	public WebDriver driver;
	
	public AddressPage(WebDriver driver) {
		this.driver = driver;
	}

	By firstname = By.id("firstname");
	By lastname = By.id("lastname");
	By company = By.id("company");
	By address1 = By.id("address1");
	By address2 = By.id("address2");
	By city = By.id("city");
	By postalcode = By.id("postcode");
	By phone = By.id("phone");
	By mobilephone = By.id("phone_mobile");
	By title = By.id("alias");
	By addInfo = By.id("other");
	By state = By.id("id_state");
	
	String titletext = "NathanRuiz";
	
	//Preenche as informações de um novo endereço
	public void fillAddress() {
		driver.findElement(firstname).clear();
		driver.findElement(firstname).sendKeys("Lima");
		driver.findElement(lastname).clear();
		driver.findElement(lastname).sendKeys("Weezy");
		driver.findElement(company).sendKeys("Young Money");
		driver.findElement(address1).sendKeys("Manoel Henriques");
		driver.findElement(address2).sendKeys("540");
		driver.findElement(city).sendKeys("Osasco");
		
		Select state = new Select(driver.findElement(By.id("id_state")));
		state.selectByVisibleText("Colorado");
		
		driver.findElement(postalcode).sendKeys("85001");
		driver.findElement(phone).sendKeys("1141400040");
		driver.findElement(mobilephone).sendKeys("119995345");
		driver.findElement(addInfo).sendKeys("Ao lado do mercado");
		driver.findElement(title).clear();
		driver.findElement(title).sendKeys(titletext);
	}
	
	//Clica no botão "Add a new address"
		public void addAddressButton() {
			driver.findElement(By.cssSelector(".address_add span")).click();
		}
	
	//Clica no botão "Save" para salvar o novo endereço preenchido
	public void saveAddress() {
		driver.findElement(By.cssSelector("#submitAddress > span")).click();
	}
	
	//Seleciona o endereço criado recentemente
	public void chooseAddressSelect() {
		Select select = new Select(driver.findElement(By.id("id_address_delivery")));
		select.selectByIndex(1);
	}
		
	//Verifica se o checkbox de usar o endereço de entrega como endereço de cobrança está marcado, se sim, uncheck
	public void BillingAddressCheckbox() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("waitimage")));
		WebElement checkBoxBilling = driver.findElement(By.id("addressesAreEquals"));
		boolean isEnabled = checkBoxBilling.isSelected();

		if (isEnabled == true) {
			checkBoxBilling.click();
		}
	}
	
	//Cria um endereço para cobrança 
	public void oneAddress() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("waitimage")));
		driver.findElement(By.cssSelector("#address_invoice_form span")).click();
		fillAddress();
		saveAddress();
		proceed();
	}
	
	//Escolhe um endereço para a entrega e outro para a cobrança
	public void multipleAddresses() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("waitimage")));
		
		Select select = new Select(driver.findElement(By.id("id_address_delivery")));
		select.selectByIndex(0);
		
		Select select1 = new Select(driver.findElement(By.id("id_address_invoice")));
		select1.selectByIndex(0);
	}
	
	
	//Clica no botão "Proceed to checkout" na página de endereço
	public void proceed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("waitimage")));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".button:nth-child(4) > span")));
		driver.findElement(By.cssSelector(".button:nth-child(4) > span")).click();
	}
	
}
