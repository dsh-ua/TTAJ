package ua.dsh.pageObjectApproach.tests;
import ua.dsh.pageObjectApproach.pages.HomePage;
import ua.dsh.pageObjectApproach.pages.ShoppingCartEmptyPage;
import org.testng.Assert;
import org.testng.annotations.Test;
public class ShoppingCartEmptyPageTest extends TestRunnerFirst {
    @Test
    public void checkShoppingCartEmptyPageTaskTest() {
        HomePage homePage = loadApplication();
        ShoppingCartEmptyPage cart = homePage.goToShoppingCartPage();
        Assert.assertTrue(cart.checkPageIsEmpty());
        presentationSleep(2); // For Presentation ONLY
        cart.clickContinueButton();
        homePage = homePage.refreshHomePage();
        Assert.assertTrue(homePage.IsHomePageLoad());
    }
}
