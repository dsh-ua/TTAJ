package ua.dsh.pageObjectApproach.opencart.tests;
import ua.dsh.pageObjectApproach.opencart.pages.HomePage;
import ua.dsh.pageObjectApproach.opencart.pages.ShoppingCartEmptyPage;
import org.testng.Assert;
import org.testng.annotations.Test;
public class ShoppingCartEmptyPageTest extends TestRunnerFirst {
    @Test
    public void checkShoppingCartEmptyPageTaskTest() {
        HomePage homePage = loadApplication();
        presentationSleep(); // For Presentation ONLY
        ShoppingCartEmptyPage cart = homePage.goToShoppingCartPage();
        presentationSleep(); // For Presentation ONLY
        Assert.assertTrue(cart.checkPageIsEmpty());
        presentationSleep(); // For Presentation ONLY
        cart.clickContinueButton();
        presentationSleep(); // For Presentation ONLY
        homePage = homePage.refreshHomePage();
        Assert.assertTrue(homePage.IsHomePageLoad());
        presentationSleep(); // For Presentation ONLY
    }
}
