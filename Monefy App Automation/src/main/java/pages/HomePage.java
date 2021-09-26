package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Page;

public class HomePage extends Page {

    @AndroidFindBy(id = idPrefix + "income_amount_text")
    private MobileElement incomeAmountValue;

    @AndroidFindBy(id = idPrefix + "expense_amount_text")
    private MobileElement expenseAmountValue;

    @AndroidFindBy(id = idPrefix + "balance_amount")
    private MobileElement balanceValue;

    @AndroidFindBy(id = idPrefix + "income_button")
    private MobileElement incomeBtn;

    @AndroidFindBy(id = idPrefix + "expense_button_title")
    private MobileElement expenseBtn;

    public HomePage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        wait = new WebDriverWait(driver, 30);
    }

    public String getIncomeAmountValue(){
        wait.until(ExpectedConditions.visibilityOf(incomeAmountValue));
        return incomeAmountValue.getText();
    }

    public String getExpenseAmountValue(){
        wait.until(ExpectedConditions.visibilityOf(expenseAmountValue));
        return expenseAmountValue.getText();
    }

    public String getBalanceAmountValue(){
        wait.until(ExpectedConditions.visibilityOf(balanceValue));
        return balanceValue.getText();
    }

    public IncomePage clickIncomeBtn(){
        wait.until(ExpectedConditions.visibilityOf(incomeBtn));
        incomeBtn.click();
        return new IncomePage();
    }

    public ExpensePage clickExpenseBtn(){
        wait.until(ExpectedConditions.visibilityOf(expenseBtn));
        expenseBtn.click();
        return new ExpensePage();
    }


}
