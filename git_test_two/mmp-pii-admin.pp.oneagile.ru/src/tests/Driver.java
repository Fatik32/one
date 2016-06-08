package tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
//import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import pageObject.AuthorizationPage;

public class Driver {
	public static By usernameLocator;
	private static WebDriver driver;
	public static void setUpFirefox() throws Exception {
	    driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().window().maximize();;
	    System.out.println("Driver.setUpFirefox() succes!");
	}
	/*
 	public static void setUpFirefox() throws Exception {
	    FirefoxDriver driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get("http://piiadmin.pp.oneagile.ru/");
	    driver.quit();
	}
	public static void setUpOpera() throws Exception {
	    	System.setProperty("webdriver.opera.driver", "C:/selenium/new/driver/operadriver.exe");
	    	OperaDriver driver = new OperaDriver();
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    driver.get("http://piiadmin.pp.oneagile.ru/");
		    Thread.sleep(3000);
		    driver.quit();
	    }
	public static void setUpChrome() throws Exception {
		ChromeOptions option = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver", "C:/Program Files/Google/Chrome/Application/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://piiadmin.pp.oneagile.ru/");
		Thread.sleep(3000);
		driver.close();		
		}
		*/
	/*public static void openPage(String pageUrl) throws Exception {
	 	driver.get(pageUrl);
	    System.out.println("Driver.openPage(pageUrl) success!");
	    }
	*/
	/*public static void loginAs(String Login, String Password) throws Exception {
		driver.findElement(usernameLocator).clear();
	    driver.findElement(usernameLocator).sendKeys("a.fatov");
	    driver.findElement(passwordLocator).clear();
	    driver.findElement(passwordLocator).sendKeys("Fatik32rus");
	    driver.findElement(loginButtonLocator).click();
	    System.out.println("Driver.loginAs(login, password) success!");
	}
	*/
	public static void tearDownFirefox() throws Exception {
		Thread.sleep(3000);
	    driver.manage().deleteAllCookies();
	    driver.quit();
	    System.out.println("Driver.tearDownFirefox() success!");
	}
}