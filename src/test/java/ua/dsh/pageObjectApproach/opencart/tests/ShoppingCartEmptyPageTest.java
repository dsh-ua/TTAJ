package ua.dsh.pageObjectApproach.opencart.tests;
import ua.dsh.pageObjectApproach.opencart.pages.HomePage;
import ua.dsh.pageObjectApproach.opencart.pages.ShoppingCartEmptyPage;

import org.testng.Assert;
import org.testng.annotations.Test;
public class ShoppingCartEmptyPageTest extends TestRunnerFirst {
    @Test
    public void checkShoppingCartEmptyPageTaskTest() {
        HomePage homePage = loadApplication();
        presentationSleep(2); // For Presentation ONLY
        ShoppingCartEmptyPage cart = homePage.goToShoppingCartPage();
        presentationSleep(2); // For Presentation ONLY
        Assert.assertTrue(cart.checkPageIsEmpty());
        presentationSleep(2); // For Presentation ONLY
        cart.clickContinueButton();
        presentationSleep(3); // For Presentation ONLY
        homePage = homePage.refreshHomePage();
        Assert.assertTrue(homePage.IsHomePageLoad());
        presentationSleep(); // For Presentation ONLY
    }
}
