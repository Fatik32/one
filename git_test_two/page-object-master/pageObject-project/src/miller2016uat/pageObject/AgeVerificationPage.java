package miller2016uat.pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * Страница проверки возраста
 * @author a.fatov
 * Переменные:
 * @public WebDriver driver
 * @public String pageUrl
 * @public By yesButtonLocator
 * @public By noButtonLocator
 * Методы:
 * @public AgeVerificationPage(WebDriver driver) throws Exception
 * @public String getPage() throws Exception
 * @public void openPage() throws Exception
 * @public void selectDay() throws Exception
 * @public void selectMonth() throws Exception
 * @public void selectYear() throws Exception
 * @public void clickLoginButton() throws Exception
 * @public void clickYesButton() throws Exception
 */
public class AgeVerificationPage extends Page {
	//interface нужно добавить интерфейс для совместно используемых констант	
				//                   Переменные
	public WebDriver driver;
	public String pageUrl = "/ru/overlays/age-verification.html";
	public By yesButtonLocator = By.id("agevalidation-confirm");
	public By noButtonLocator = By.id("agevalidation-deny");	
				//	                    Методы
	/**
	 * Конструктор!
	 * Метод для передачи обьекта driver
	 * @param driver
	 * @throws Exception
	 */
	public AgeVerificationPage(WebDriver driver) throws Exception {
		this.driver = driver;
	}
	/**
	 * Выдает адресс страницы
	 * @throws Exception
	 * @return (baseUrl + pageUrl)
	 */
	public String getPage() throws Exception {
		//System.out.println("AgeVerificationPage.getPage() success!");
		//System.out.println(baseUrl + pageUrl);
		return (baseUrl + pageUrl);
	 }
	/**
	 * Открыть страницу
	 * @throws Exception
	 */
	public void openPage() throws Exception {
		driver.get(baseUrl + pageUrl);
		//System.out.println("AgeVerificationPage.openPage() success!");
		//System.out.println(baseUrl + pageUrl);
	 }
	/**
	 * Нажать на кнопку "ДА"
	 * @throws Exception
	 */
	public void clickYesButton() throws Exception {
		driver.findElement(yesButtonLocator).click();
		//driver.findElement(By.id("agevalidation-confirm")).click();
		Thread.sleep(3000);
	 }
	/**
	 * Нажать на кнопку "НЕТ"
	 * @throws Exception
	 */
	public void clickNoButton() throws Exception {
		driver.findElement(noButtonLocator).click();
		//driver.findElement(By.id("agevalidation-deny")).click();
		Thread.sleep(3000);
	 }
	/**
	 * Пройти проверку возраста, оказываемся на главной странице
	 * @throws Exception
	 */
    public void ageVerificationTrue() throws Exception{
    	System.out.println("@ageVerificationTrue start!");
    	AgeVerificationPage ageVerificationPage = new AgeVerificationPage(driver);
    	ageVerificationPage.openPage();
    	ageVerificationPage.clickYesButton();
    	
        System.out.println("@ageVerificationTrue success!");
}	
	}
