package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Page;

public class IncomePage extends Page {

    @AndroidFindBy(id = idPrefix + "amount_text")
    private MobileElement amountField;

    @AndroidFindBy(id = idPrefix + "buttonKeyboard5")
    private MobileElement btnKeyboard5;

    @AndroidFindBy(id = idPrefix + "buttonKeyboard0")
    private MobileElement btnKeyboard0;

    @AndroidFindBy(id = idPrefix + "keyboard_action_button")
    private MobileElement categoryBtn;



    public IncomePage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        wait = new WebDriverWait(driver, 30);
    }

    public IncomePage enterIncome(){
        wait.until(ExpectedConditions.visibilityOf(btnKeyboard5));
        btnKeyboard5.click();
        btnKeyboard0.click();
        return this;
    }

    public CategoryPage clickCategoryBtn(){
        categoryBtn.click();
        return new CategoryPage();
    }

}
