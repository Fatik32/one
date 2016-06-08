package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {

	public static void main(String[] args) throws Exception {
		System.out.println("Begin!");
		FirefoxDriver driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get("http://piiadmin.pp.oneagile.ru/");
	    driver.manage().window().maximize();;
	    driver.manage().deleteAllCookies();
	    driver.findElement(By.name("login")).clear();
	    driver.findElement(By.name("login")).sendKeys("a.fatov");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("Fatik32rus");
	    driver.findElement(By.id("btn")).click();
	    Thread.sleep(3000);
	    driver.manage().deleteAllCookies();
	    driver.quit();
	    System.out.println("End!");
	    
	}

}
