package miller2016uat.pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * Домашняя (главная) Страница сайта:
 * @author a.fatov
 * Переменные:
 * @public WebDriver driver
 * @public String pageUrl
 * @public By homeLocator
 * @public By prizeLocator
 * @public By winnerLocator
 * @public By authLocator
 * @public By registerLocator
 * @public By popUpRegBtnLocator
 * Методы:
 * @public HomePage(WebDriver driver) throws Exception
 * @public String getPage() throws Exception
 * @public void openPage() throws Exception
 * @public void clickHome() throws Exception
 * @public void clickRegister() throws Exception
 * @public void clickPopUpRegBtn() throws Exception
 */
public class HomePage extends Page {
	//interface нужно добавить интерфейс для совместно используемых констант	
				//                   Переменные
	public WebDriver driver;
	public String pageUrl = "/home.html";
	public By homeLocator = By.cssSelector("a[title='Главная']"); //Ссылка на главную страницу
	public By prizeLocator = By.cssSelector("a[title='Призы']"); //Ссылка на страницу призов
	public By winnerLocator = By.cssSelector("a[title='Победители']"); //Ссылка на страницу победителей
	public By authLocator = By.cssSelector("a[title='ВХОД']"); //Ссылка на страницу авторизации
	public By registerLocator = By.cssSelector("a[title='РЕГИСТРАЦИЯ']"); //Ссылка на страницу регистрации
	public By popUpRegBtnLocator = By.id("popUpRegBtn"); //Ссылка на страницу регистрации в всплывающем попапе
				//	                    Методы
	/**
	 * HomePage(WebDriver driver) Конструктор!
	 * Метод для передачи обьекта driver
	 * @param driver
	 * @throws Exception
	 */
	public HomePage(WebDriver driver) throws Exception {
		this.driver = driver;
	}
	/**
	 * getPage() Выдает адресс страницы
	 * @throws Exception
	 * @return (baseUrl + pageUrl)
	 */
	public String getPage() throws Exception {
		//System.out.println("AgeVerificationPage.getPage() success!");
		//System.out.println(baseUrl + pageUrl);
		return (baseUrl + pageUrl);
	 }
	/**
	 * openPage() Открыть страницу
	 * @throws Exception
	 */
	public void openPage() throws Exception {
		driver.get(baseUrl + pageUrl);
		//System.out.println("AgeVerificationPage.openPage() success!");
		//System.out.println(baseUrl + pageUrl);
	 }
	/**
	 * clickHome() Нажать на текст "Главная"
	 * @throws Exception
	 */
	public void clickHome() throws Exception {
		driver.findElement(homeLocator).click();
		//driver.findElement(homeLocator).click();
		Thread.sleep(3000);
	 }
	/**
	 * clickPrize() Нажать на текст "Призы"
	 * @throws Exception
	 */
	public void clickPrize() throws Exception {
		driver.findElement(prizeLocator).click();
		//driver.findElement(homeLocator).click();
		Thread.sleep(3000);
	 }
	/**
	 * clickWinner() Нажать на текст "Победители"
	 * @throws Exception
	 */
	public void clickWinner() throws Exception {
		driver.findElement(winnerLocator).click();
		//driver.findElement(homeLocator).click();
		Thread.sleep(3000);
	 }
	/**
	 * clickAuth() Нажать на текст "ВХОД"
	 * @throws Exception
	 */
	public void clickAuth() throws Exception {
		driver.findElement(authLocator).click();
		//driver.findElement(homeLocator).click();
		Thread.sleep(3000);
	 }
	/**
	 * clickRegister() Нажать на текст "РЕГИСТРАЦИЯ"
	 * @throws Exception
	 */
	public void clickRegister() throws Exception {
		driver.findElement(registerLocator).click();
		//driver.findElement(homeLocator).click();
		Thread.sleep(3000);
	 }
	/**
	 * clickPopUpRegBtn() Нажать на текст "РЕГИСТРАЦИЯ" в всплывающем попапе
	 * @throws Exception
	 */
	public void clickPopUpRegBtn() throws Exception {
		driver.findElement(popUpRegBtnLocator).click();
		//driver.findElement(homeLocator).click();
		Thread.sleep(3000);
	 }
	}
