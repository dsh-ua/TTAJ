package ua.dsh.pageObjectApproach.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartEmptyPage extends TopPart{

    private WebElement continueButton;
    private WebElement shoppingCartLabel;
    private WebElement cartIsEmptyText;
    public static final String LABEL_SHOPPING_CART_IS_EMPTY = "Your shopping cart is empty!";
    public static final String LABEL_SHOPPING_CART = "Shopping Cart";


    public ShoppingCartEmptyPage(WebDriver driver) {
        super(driver);
        initElements();
    }
    public void clickContinueButton (){
        getContinueButton().click();
    }
    public boolean checkPageIsEmpty(){
        return cartIsEmptyText.getText().equals(LABEL_SHOPPING_CART_IS_EMPTY);
    }
    public WebElement getContinueButton() {
        return continueButton;
    }
    private void initElements() {
        // init
        continueButton = driver.findElement(By.xpath("//*[@id='content']/div/div/a"));
        shoppingCartLabel = driver.findElement(By.xpath("//*[@id='content']/h1"));
        cartIsEmptyText = driver.findElement(By.xpath("//*[@id='content']/p"));
    }
}
