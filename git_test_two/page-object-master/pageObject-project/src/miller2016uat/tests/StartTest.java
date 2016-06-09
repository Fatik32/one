package miller2016uat.tests;

import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import essa2016uat.pageObject.AuthorizationPage;
//import tests.Driver;

public class StartTest {
	public static void main(String[] args) throws Exception {
		FirefoxDriver driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
			AuthorizationPage authPage = new AuthorizationPage(driver);
		/*
		*driver1.setUpFirefox();
		*driver1.setUpOpera();
		*driver1.setUpChrome();
		*/
		System.out.println("Begin!");
		
	    driver.get(authPage.pageUrl);
	    driver.manage().deleteAllCookies();
	    driver.findElement(authPage.usernameLocator).clear();
	    driver.findElement(authPage.usernameLocator).sendKeys("a.fatov");
	    driver.findElement(authPage.passwordLocator).clear();
	    driver.findElement(authPage.passwordLocator).sendKeys("Fatik32rus");
	    driver.findElement(authPage.loginButtonLocator).click();
	    Thread.sleep(3000);
	    driver.manage().deleteAllCookies();
	    driver.quit();
	    System.out.println("End!");

	}
	
	public void setUp(){
		
	}
	public void tearDown(){
		
	}

}
