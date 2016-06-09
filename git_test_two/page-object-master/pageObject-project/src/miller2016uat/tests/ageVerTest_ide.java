package miller2016uat.tests;


//import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.Select;

public class ageVerTest_ide {
  private WebDriver driver;
  private String baseUrl;
  private String ageVerificationUrl;
  //private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://millersixteen-uat.posterone.ru";
    ageVerificationUrl = "/content/efes/miller/russia/millerworldsixteen/ru/overlays/age-verification.html";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().deleteAllCookies();
    driver.manage().window().maximize();
  }

  @Test
  public void testAgeVerTestIde() throws Exception {
    driver.get(baseUrl + ageVerificationUrl);
    
    //Select
    WebElement selectElem = driver.findElement(By.id("dob_year"));
    Select select = new Select(selectElem);
    driver.findElement(By.id("dob_year")).click();
    select.selectByValue("1945");
    
    
    //dob_day
    
    driver.findElement(By.cssSelector("select[name=\"dob_day\"]")).click();
    driver.findElement(By.xpath("//option[contains(@value, '9')]")).click();
    
    //driver.findElement(By.xpath("//select[contains(@name, 'dob_day')]/option[contains(@value, '9')]")).click();
    
    System.out.println("dob_day_click_success");
    System.out.println("day_success " + driver.findElement(By.xpath("//option[contains(@value, '9')]")).getText());
    Thread.sleep(3000);
    
    //dob_month
    
    //driver.findElement(By.cssSelector("select[name=\"dob_month\"]")).click();
    driver.findElement(By.cssSelector("select[name=\"dob_month\"]")).click();
    driver.findElement(By.xpath("//option[contains(text(),'май')]")).click();
    Thread.sleep(3000);
    
    //dob_year
    
    //driver.findElement(By.id("dob_year")).click();
    driver.findElement(By.id("dob_year")).click();
    driver.findElement(By.xpath("//option[contains(@value, '1901')]")).click();
    driver.findElement(By.xpath("//option[contains(@value, '1970')]")).click();
    //driver.findElement(By.xpath("//select[contains(@name, 'dob_year')]/option[contains(@value, '1945')]")).click();
    Thread.sleep(3000);
    
    //button ¬ход
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    //driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    
    System.out.println("test_success");
  }

  @After
  public void tearDown() throws Exception {
	  Thread.sleep(3000);
	  driver.manage().deleteAllCookies();
	  driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
