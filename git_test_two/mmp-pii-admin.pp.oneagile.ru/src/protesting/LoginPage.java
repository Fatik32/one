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
	       // ��� ��� ���������� ���� Username
	       getBrowser().type("id=UserName", userName);
	   }
	   @SuppressWarnings("deprecation")
	private void setPassword(String password) {
	       // ��� ��� ���������� ���� Password
	       getBrowser().type("id=Password", password);
	   }
	   @SuppressWarnings("deprecation")
	private void pushLoginButton() {
	       // ��� ��� ������� �� ������ Login
	       getBrowser().click("id=LoginButton");
	   }
	   protected void parsePage() {
	       // ������ ��������� ��������
	       // ���������� ����������� ���������� ������� �� ��������
	   }
	   @SuppressWarnings("deprecation")
	protected void init() {
	       // ������������� ��������, �������� �������� ������ (URL) ��������:
	       if(!getBrowser().getLocation().equals(PAGE_URL)) {
	           throw new IllegalStateException("Invalid page is opened");
	       }
	       // ����� ����� �������� �������� ������� ����������� ��� ���������� ������
	       // �������� � �.�.
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
