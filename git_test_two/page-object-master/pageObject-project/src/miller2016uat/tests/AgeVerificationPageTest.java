package miller2016uat.tests;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import miller2016uat.pageObject.AgeVerificationPage;
/**
 * 
 * @Тест страницы верификации возраста
 * @author a.fatov
 * Переменные:
 * @public WebDriver driver
 * Методы:
 * @public void setUp() throws Exception
 * @public void TestAgeVerificationTrue() throws Exception
 * @public void TestAgeVerificationTrueIsOneMetod() throws Exception
 * @public void TestAgeVerificationFalse() throws Exception
 * @public void tearDown() throws Exception
 */
public class AgeVerificationPageTest {
					//                    Переменные
	public WebDriver driver;
					//                      Методы
/**
 * setUp() Метод вызываемый перед началом каждого теста
 * @throws Exception
 */
    @Before
    public void setUp() throws Exception {
    	driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().deleteAllCookies();
	    driver.manage().window().maximize();
    	System.out.println("@Before succes!");
    }
/**
 * TestAgeVerificationTrue() Тест прохождения верификации возраста
 * @throws Exception
 */
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
/**
 * TestAgeVerificationTrueIsOneMetod() Тест прохождения верификации возраста одним методом
 * @throws Exception
 */
	@Test
    public void TestAgeVerificationTrueIsOneMetod() throws Exception{
    	System.out.println("@Test 2 start!");
    	AgeVerificationPage ageVerificationPage = new AgeVerificationPage(driver);
    	System.out.println("Страница подтверждения возраста: " + ageVerificationPage.getPage());
    	
    	ageVerificationPage.ageVerificationTrue();
    	
        System.out.println("@Test 2 success!");
}
/**
 * TestAgeVerificationFalse() Тест неудачного прохождения верификации возраста	
 * @throws Exception
 */
	@Test
    public void TestAgeVerificationFalse() throws Exception{
    	System.out.println("@Test 3 start!");
    	AgeVerificationPage ageVerificationPage = new AgeVerificationPage(driver);
    	System.out.println("Страница подтверждения возраста: " + ageVerificationPage.getPage());
    	
    	ageVerificationPage.getPage();
    	ageVerificationPage.openPage();
    	ageVerificationPage.clickNoButton();
    	
        System.out.println("@Test 3 success!");
}
/**
 * tearDown() Метод вызываемый после окончания каждого теста
 * @throws Exception
 */
    @After
    public void tearDown() throws Exception {
    	Thread.sleep(1000);
	    driver.manage().deleteAllCookies();
	    driver.quit();
	    System.out.println("@After success!");
    	System.out.println("End!");
    }

}
