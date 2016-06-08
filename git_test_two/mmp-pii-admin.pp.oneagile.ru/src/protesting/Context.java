package protesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.SeleniumServer;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

@SuppressWarnings({ "deprecation", "unused" })
public class Context {
    public static final String BROWSER_IE = "*iexplore";
    public static final String BROWSER_FF = "*firefox";
    public static final String BROWSER_CH = "*chrome";
    private static Context context;
    private static String siteUrl;
    private Selenium browser;
    private SeleniumServer seleniumServer;
    private Context() {
    }
    public static void initInstance(String browserType, String siteURL) {
        context = new Context();
        siteUrl = siteURL;
        context.setBrowser(new DefaultSelenium("localhost", 4444, browserType, siteURL));
        context.start();
    }
    public static Context getInstance() {
        if (context == null) {
            throw new IllegalStateException("Context is not initialized");
        }
        return context;
    }
    public Selenium getBrowser() {
        if (browser != null) {
            return browser;
        }
        throw new IllegalStateException("WebBrowser is not initialized");
    }
    public String getSiteUrl() {
       return siteUrl;
    }
    public void start() {
        try {
            seleniumServer = new SeleniumServer();
            seleniumServer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        browser.start();
    }
    public void close() {
        browser.close();
        browser.stop();
        seleniumServer.stop();
    }
    public void setBrowser(Selenium browser) {
        this.browser = browser;
    }
}