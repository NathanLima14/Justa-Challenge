package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {
	
	public WebDriver driver;

	public PaymentPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	//Seleciona o método de pagamento como bank wire
	public void selectBankWire() {
		driver.findElement(By.cssSelector(".bankwire")).click();
		System.out.println("Bank wire selecionado");
	}
	
	//Seleciona o método de pagamento como check
	public void selectCheck() {
		driver.findElement(By.cssSelector(".cheque")).click();
		System.out.println("Check selecionado");
	}
	
	//Clica no botão "I confirm my order"
	public void confirmOrder() {
		driver.findElement(By.cssSelector("#cart_navigation span")).click();
	}
	
	
	//Verifica se o pedido foi feito com sucesso através do texto exibido
	public void checkOrder() {
		if(driver.getPageSource().contains("Your order on My Store is complete.")) {
			System.out.println("Pedido feito com sucesso");
		}else {
			System.out.println("Ocorreu um erro no pedido");
		}
	}
}
