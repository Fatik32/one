package essa2016uat.pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;
public class AuthorizationPage extends Page {
	public WebDriver driver;
	//interface нужно добавить интерфейс для совместно используемых констант
	//if(elem.Displayed) проверка есть элемент или нет
	//http://essa2016-uat.posterone.ru/content/efes/essa/russia/essa2016/ru/overlays/age-verification.html
	public String pageUrl = "http://piiadmin.pp.oneagile.ru/";
	public By usernameLocator = By.name("login");
	public By passwordLocator = By.name("password");
	public By loginButtonLocator = By.id("btn");
	public By errorsLocator = By.className("errors");
	public String Login = "a.fatov";
	public String Password = "Fatik32rus";
	public AuthorizationPage(WebDriver driver) throws Exception {
		this.driver = driver;
	}
	//Авторизация с правильным логином
	public void loginAs() throws Exception {
	    driver.findElement(usernameLocator).clear();
	    driver.findElement(usernameLocator).sendKeys("a.fatov");
	    driver.findElement(passwordLocator).clear();
	    driver.findElement(passwordLocator).sendKeys("Fatik32rus");
	    driver.findElement(loginButtonLocator).click();
	    System.out.println("AuthorizationPage.loginAs() success!");
	}
	//Авторизация с неправильным логином
	public void loginAsInvalidLogin() throws Exception {
	    driver.findElement(usernameLocator).clear();
	    driver.findElement(usernameLocator).sendKeys("a.fatov123");
	    driver.findElement(passwordLocator).clear();
	    driver.findElement(passwordLocator).sendKeys("Fatik32rus");
	    driver.findElement(loginButtonLocator).click();
	    driver.findElement(errorsLocator);
	    System.out.println(driver.findElement(errorsLocator).getText());
	    assertTrue(driver.findElement(errorsLocator).getText().equals("Invalid user"));
	    System.out.println("AuthorizationPage.loginAsInvalidLogin() success!");
	}
	
	public void openPage() throws Exception {
		driver.get(pageUrl);
		System.out.println("AuthorizationPage.openPage() success!");
	 }
	}
