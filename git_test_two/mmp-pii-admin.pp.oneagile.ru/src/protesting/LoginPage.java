package protesting;

public class LoginPage extends Page {
	   public static final String PAGE_URL = "";
	   protected LoginPage() {
	       super(PAGE_URL);
	   }
	   @SuppressWarnings("deprecation")
	public static LoginPage openLoginPage() {
	       LoginPage loginPage = new LoginPage();
	       loginPage.getBrowser().open(PAGE_URL);
	       return loginPage;
	   }
	   @SuppressWarnings("deprecation")
	private void setUserName(String userName) {
	       // код для заполнения поля Username
	       getBrowser().type("id=UserName", userName);
	   }
	   @SuppressWarnings("deprecation")
	private void setPassword(String password) {
	       // код для заполнения поля Password
	       getBrowser().type("id=Password", password);
	   }
	   @SuppressWarnings("deprecation")
	private void pushLoginButton() {
	       // код для нажатия на кнопку Login
	       getBrowser().click("id=LoginButton");
	   }
	   protected void parsePage() {
	       // Разбор элементов страницы
	       // Заполнение необходимых переменных данными со страницы
	   }
	   @SuppressWarnings("deprecation")
	protected void init() {
	       // Инициализация страницы, например проверка адреса (URL) страницы:
	       if(!getBrowser().getLocation().equals(PAGE_URL)) {
	           throw new IllegalStateException("Invalid page is opened");
	       }
	       // Можно также добавить проверки наличия необходимых для дальнейшей работы
	       // объектов и т.д.
	   }
	   private void loginAs(String userName, String password) {
	       setUserName(userName);
	       setPassword(password);
	       pushLoginButton();
	   }
	   public HomePage login(String userName, String password) {
	       loginAs(userName, password);
	       return new HomePage();
	   }
	   public ErrorLoginPage loginInvalid(String userName, String password) {
	       loginAs(userName, password);
	       return new ErrorLoginPage();
	   }
	}
