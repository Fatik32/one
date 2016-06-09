package other;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Basic class for reporting test results
 */
public abstract class Reporter {

    public static final String TEST_PASSED = "Passed";
    public static final String TEST_FAILED = "Failed";
    public static final String TEST_CRASHED = "Crashed";
    public static final String DEBUG = "Debug";

    protected String currentStatus = null;
    protected String currentPromo = null;
    protected String currentTest = null;

    /**
     * Change location of the report
     *
     * @param documentRoot the new location of the report
     */
    abstract public void switchContext(String documentRoot) throws IOException;

    protected String timestamp() {
        return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")).format(new Date());
    }

    /**
     * Reporting log message
     *
     * @param type    type of the message (one of main.framework.basic.loger.loger.TEST_PASSED, main.framework.basic.loger.loger.TEST_FAILED, main.framework.basic.loger.loger.TEST_CRASHED, main.framework.basic.loger.loger.DEBUG)
     * @param message string message
     */
    public void writeLog(String type, String message)
            throws IOException {
        if (currentStatus != Reporter.TEST_CRASHED && type != Reporter.DEBUG) {
            if (currentStatus != Reporter.TEST_FAILED || type == Reporter.TEST_CRASHED) {
                currentStatus = type;
            }
        }
    }

    /**
     * returns status of current test
     *
     * @return status
     */
    public String getStatus() {
        return currentStatus;
    }

    /**
     * clears status of current test
     */
    public void clear() {
        currentStatus = null;
    }

    /**
     * reporting starting of the test
     *
     * @param promo promo on witch test is running
     * @param test  test witch running
     * @throws IOException when error of reporting occures
     */
    public void startTest(String promo, String test)
            throws IOException {
        clear();
        currentPromo = promo;
        currentTest = test;
    }

    /**
     * reporting ending of the test
     *
     * @throws IOException when error of reporting occures
     */
    abstract public void endTest()
            throws IOException;

    /**
     * Path to report
     *
     * @return path to report
     */
    abstract public String getReportPath() throws IOException;
}
