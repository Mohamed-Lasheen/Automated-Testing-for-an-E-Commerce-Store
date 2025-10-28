package Pages.Cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Cart {
    WebDriver driver;

    By checkoutButton = By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[1]/app-cart/div/div/button[2]");
    By checkoutSignInButton = By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[2]/app-login/div/div/div/div/button");
    By cartItems = By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[1]/app-cart/div/table/tbody/tr/td[1]/span");
    public Cart(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductInCart() {
        return !driver.findElements(cartItems).isEmpty();
    }

    public void proceedToCheckout() {
        driver.findElement(checkoutButton).click();
    }
    public void proceedToCheckoutAfterSignIn() {
        driver.findElement(checkoutSignInButton).click();
    }
}