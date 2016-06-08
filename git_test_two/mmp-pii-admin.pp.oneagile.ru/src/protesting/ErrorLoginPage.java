package protesting;

public class ErrorLoginPage extends Page {
	   public static final String PAGE_URL = "/loginError.html";
	   private String errorMessage;
	   protected ErrorLoginPage() {
	       super(PAGE_URL);
	   }
	   protected void init() {
	       // ������������� ��������
	   }
	   @SuppressWarnings("deprecation")
	protected void parsePage() {
	       // ������ ��������� ��������
	       this.errorMessage = getBrowser().getText("id=ErrorMessage");
	   }
	   public String getErrorMessage() {
	       return this.errorMessage;
	   }
	   @SuppressWarnings("deprecation")
	public LoginPage backToLoginPage() {
	       getBrowser().click("id=BackLink");
	       return new LoginPage();
	   }
	}
