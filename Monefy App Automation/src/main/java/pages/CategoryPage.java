package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Page;

public class CategoryPage extends Page {

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Salary')]/..")
    private MobileElement salaryWidget;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Car')]/..")
    private MobileElement carWidget;



    public CategoryPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        wait = new WebDriverWait(driver, 30);
    }

    public HomePage clickSalary(){
        wait.until(ExpectedConditions.visibilityOf(salaryWidget));
        salaryWidget.click();
        sleep(5000);
        return new HomePage();
    }

    public HomePage selectCar(){
        wait.until(ExpectedConditions.visibilityOf(carWidget));
        carWidget.click();
        return new HomePage();
    }
}
