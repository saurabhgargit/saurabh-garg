package utils;

import org.openqa.selenium.support.ui.WebDriverWait;

public class Page extends BaseClass {

    public static final String idPrefix = "com.monefy.app.lite:id/";
    public WebDriverWait wait;

    protected void sleep(int sleepMillis) {
        try {
            Thread.sleep(sleepMillis);
        } catch (InterruptedException ignored) {
        }
    }


}
