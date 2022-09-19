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

public class Test3 {
	WebDriver driver;
	
	@Before
	public void begin() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nathan\\Desktop\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/");
		driver.manage().window().maximize();
	}
	
	@After
	public void finish() {
		driver.quit();
	}
	
	//Cenário 1 - Usuário não logado e escolha do cheque como forma de pagamento
	@Test
	public void TestCase() {
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
		
		address.proceed();
		shipping.acceptTerms();
		shipping.proceed();
		
		payment.selectCheck();
		payment.confirmOrder();
		payment.checkOrder();
	}
}
