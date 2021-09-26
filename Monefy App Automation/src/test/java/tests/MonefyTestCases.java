package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.Constant;

public class MonefyTestCases extends SuiteConfig{

    HomePage homePage;


    /**
     * Description - This test case will validate the value of income, expense and balance amount for newly installed app.
     */
    @Test
    public void verifyIncomeAndExpenseAmountOnAppInstallation(){
        homePage = new HomePage();
        Assert.assertTrue(homePage.getIncomeAmountValue().equals(Constant.defaultIncomeValue), "At app launch income value is not matching");
        Assert.assertTrue(homePage.getExpenseAmountValue().equals(Constant.defaultExpenseValue), "At app launch expense value is not matching");
        Assert.assertTrue(homePage.getBalanceAmountValue().equals(Constant.defaultBalanceValue), "At app launch default balance value is not matching");
    }

    /**
     * Description - This test case will validate the value of Balance after user enter income.
     */
    @Test
    public void verifyBalanceAfterEnteringIncome(){
        homePage = new HomePage();
        homePage.clickIncomeBtn().enterIncome().clickCategoryBtn().clickSalary();
        Assert.assertTrue(homePage.getBalanceAmountValue().equals(Constant.balanceValue50Dollar), "After entering income balance value is not matching");

    }

    /**
     * Description - This test case will validate the value of Balance after user enter income and expenses.
     */

    @Test
    public void verifyBalanceValueAfterEnteringIncomeAndExpenses(){
        homePage = new HomePage();
        homePage.clickIncomeBtn().enterIncome()
                .clickCategoryBtn().clickSalary()
                .clickExpenseBtn().enterExpenses().clickCategoryBtn().selectCar();

        Assert.assertTrue(homePage.getBalanceAmountValue().equals(Constant.balanceValue45Dollar), "After entering income balance value is not matching");

    }



}
