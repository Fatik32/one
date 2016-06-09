package miller2016uat.tests;
//import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import miller2016uat.pageObject.AgeVerificationPage;

/**
 * 
 * @author a.fatov
 * @Тест страницы верификации возраста
 */

public class AuthorizationPageTest {
	public WebDriver driver;
    @Before
    public void setUp() throws Exception {
    	driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().deleteAllCookies();
	    driver.manage().window().maximize();
    	System.out.println("@Before succes!");
    }

	@Test
    public void TestAgeVerificationTrue() throws Exception{
    	System.out.println("@Test 1 start!");
    	AgeVerificationPage ageVerificationPage = new AgeVerificationPage(driver);
    	System.out.println("Страница подтверждения возраста: " + ageVerificationPage.getPage());
    	
    	ageVerificationPage.getPage();
    	ageVerificationPage.openPage();
    	ageVerificationPage.clickYesButton();
    	
        System.out.println("@Test 1 success!");
}
	
	@Test
    public void TestAgeVerificationFalse() throws Exception{
    	System.out.println("@Test 2 start!");
    	AgeVerificationPage ageVerificationPage = new AgeVerificationPage(driver);
    	System.out.println("Страница подтверждения возраста: " + ageVerificationPage.getPage());
    	
    	ageVerificationPage.getPage();
    	ageVerificationPage.openPage();
    	ageVerificationPage.clickNoButton();
    	
        System.out.println("@Test 2 success!");
}
	/*@Test
    public void TestInvalidLogin() throws Exception{
    	System.out.println("@Test 2 start!");
        AuthorizationPage authPage = new AuthorizationPage(driver);
        authPage.openPage();
        authPage.loginAsInvalidLogin();
        //assertTrue(driver.getTitle().equals("Build my Car - Configuration"));
        System.out.println("@Test 2 success!");
}*/

    @After
    public void tearDown() throws Exception {
    	Thread.sleep(1000);
	    driver.manage().deleteAllCookies();
	    driver.quit();
	    System.out.println("@After success!");
    	System.out.println("End!");
    }

}
