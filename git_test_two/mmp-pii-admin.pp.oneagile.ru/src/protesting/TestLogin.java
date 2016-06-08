package protesting;

import junit.framework.TestCase;

public class TestLogin extends TestCase {
	   public void setUp() {
	        // »нициализаци€ контекста.
	        Context.initInstance(Context.BROWSER_IE, "http://www.testtesttestlogin.com");
	    }
	   public void testLoginLogout() {
	        String userName = "tester";
	        String password = "testPass";
	        LoginPage loginPage = LoginPage.openLoginPage();
	        HomePage homePage = loginPage.login(userName, password);
	        assertEquals(userName, homePage.getLoggedinUserName());
	        homePage.logout();
	    }
	    public void testInvalidLogin() {
	        String userName = "$tester@#";
	        String password = "********";
	        String expectedMessage = "Invalid username or password";
	        LoginPage loginPage = LoginPage.openLoginPage();
	        ErrorLoginPage errorLoginPage = loginPage.loginInvalid(userName, password);
	        assertEquals(expectedMessage, errorLoginPage.getErrorMessage());
	        errorLoginPage.backToLoginPage();
	    }
	    protected void tearDown() throws Exception {
	        // закрытие браузера
	       Context.getInstance().close();
	    }
	}