package essa2016uat.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;

/*
 * driver.get(baseUrl + "/content/efes/essa/russia/essa2016/ru/overlays/age-verification.html");
    driver.findElement(By.id("select2-dob_month-container")).click();
    driver.findElement(By.id("select2-dob_year-container")).click();
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    select2-dob_day-container
 */
public class AgeVerificationPage extends Page {
	//interface нужно добавить интерфейс для совместно используемых констант
	
	public WebDriver driver;
	public String pageUrl = "http://essa2016-uat.posterone.ru/content/efes/essa/russia/essa2016/ru/overlays/age-verification.html";
	public By dob_dayLocator = By.id("select2-dob_day-container");
	public By dob_monthLocator = By.id("select2-dob_month-container");
	public By dob_yearLocator = By.id("select2-dob_year-container");
	
	public By loginButtonLocator = By.id("btn");
	public By errorsLocator = By.className("errors");
	public String Login = "a.fatov";
	public String Password = "Fatik32rus";
	public AgeVerificationPage(WebDriver driver) throws Exception {
		this.driver = driver;
	}
	//Авторизация с правильным логином
	public void loginAs() throws Exception {
	    //driver.findElement(usernameLocator).clear();
	    //driver.findElement(usernameLocator).sendKeys("a.fatov");
	    //dob_dayLocatordriver.findElement(passwordLocator).clear();
	    //driver.findElement(passwordLocator).sendKeys("Fatik32rus");
	    driver.findElement(loginButtonLocator).click();
	    System.out.println("AuthorizationPage.loginAs() success!");
	}
	//Авторизация с неправильным логином
	public void loginAsInvalidLogin() throws Exception {
	    //driver.findElement(usernameLocator).clear();
	    //driver.findElement(usernameLocator).sendKeys("a.fatov123");
	    //driver.findElement(passwordLocator).clear();
	    //driver.findElement(passwordLocator).sendKeys("Fatik32rus");
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
