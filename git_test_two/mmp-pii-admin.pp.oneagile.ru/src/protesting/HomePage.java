package protesting;

public class HomePage extends Page {
	   public static final String PAGE_URL = "/home.html";
	   private String loggedinUserName;
	   protected HomePage() {
	       super(PAGE_URL);
	   }
	   protected void init() {
	       // ������������� ��������
	   }
	   @SuppressWarnings("deprecation")
	protected void parsePage() {
	       // ������ ��������� ��������
	       this.loggedinUserName = getBrowser().getText("id=userName");
	   }
	   public String getLoggedinUserName() {
	       return loggedinUserName;
	   }
	   @SuppressWarnings("deprecation")
	public LoginPage logout() {
	       getBrowser().click("id=LogoutLink");
	       return new LoginPage();
	   }
	}
