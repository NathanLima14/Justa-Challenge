package testCases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.AddressPage;
import pages.LandingPage;
import pages.OrderPage;
import pages.PaymentPage;
import pages.ProductPage;
import pages.ShippingPage;
import pages.SignInPage;

public class Teste1 {
	WebDriver driver;
	
	
	@Before
	public void begin() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nathan\\Desktop\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/");
		driver.manage().window().maximize();
	}
	
	
	@After public void finish() { 
		driver.quit(); 
	}
	 
	//Cenário 1.1 - Usuário não logado e mais de um endereço cadastrado
	@Test
	public void TestCase1() {		
		AddressPage address = new AddressPage(driver);
		LandingPage lp = new LandingPage(driver);
		ProductPage product = new ProductPage(driver);
		OrderPage order = new OrderPage(driver);
		SignInPage signin = new SignInPage(driver);
		ShippingPage shipping = new ShippingPage(driver);
		PaymentPage payment = new PaymentPage(driver);
		
		lp.addProduct();
		
		product.addToCart();
		product.toCheckout();
		
		order.verifyAndFinishOrder();
		
		signin.login();
		
		address.chooseAddressSelect();
		address.proceed();
		
		shipping.acceptTerms();
		shipping.proceed();
		
		payment.selectBankWire();
		payment.confirmOrder();
		payment.checkOrder();
	}
	
	//Cenário 1.2 – Usuário não logado e somente um endereço cadastrado
	@Test
	public void TestCase2() {
		AddressPage address = new AddressPage(driver);
		LandingPage lp = new LandingPage(driver);
		ProductPage product = new ProductPage(driver);
		OrderPage order = new OrderPage(driver);
		SignInPage signin = new SignInPage(driver);
		ShippingPage shipping = new ShippingPage(driver);
		PaymentPage payment = new PaymentPage(driver);
		
		lp.addProduct();
		
		product.addToCart();
		product.toCheckout();
		
		order.verifyAndFinishOrder();
		
		signin.login();
		
		address.addAddressButton();
		address.fillAddress();
		address.saveAddress();
		address.chooseAddressSelect();
		address.proceed();
		
		shipping.acceptTerms();
		shipping.proceed();
		
		payment.selectBankWire();
		payment.confirmOrder();
		payment.checkOrder();
	}
}
