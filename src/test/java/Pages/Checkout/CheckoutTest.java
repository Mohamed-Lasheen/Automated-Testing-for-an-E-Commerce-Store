package Pages.Checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import Pages.Login.Login;
import Pages.Cart.Cart;
import Pages.Products.Products;
import Selenium.DriverFactory;
import TestData.TestData;
import java.util.List;

import java.time.Duration;

import static Selenium.DriverFactory.driver;

public class CheckoutTest extends DriverFactory {

    @Parameters("baseUrl")
    @Test(dataProvider = "checkoutData")
    public void testCompleteCheckoutProcess(String productName, String email, String password,
                                            String firstName, String lastName, String address,
                                            String city, String state, String postalCode, String country,
                                            String cardNumber, String expiry, String cvv) {

        //WebDriver driver = getDriver();

        try {
            // 1. Login
            driver = Login.LoginWithValidUser();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            String shop_logo = "/html/body/app-root/app-header/nav/div/a";
            WebElement label_name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(shop_logo)));
            driver.findElement(By.xpath(shop_logo)).click();
            Thread.sleep(3000);

            // 2. Select products class with the products and add the selected product to cart
            Products productsPage = new Products(driver);
            productsPage.selectProduct(productName);
            productsPage.addToCart();
            Thread.sleep(11000);

            // 3. Go to cart and verify
            productsPage.goToCart();
            Thread.sleep(5000);

            Cart cartPage = new Cart(driver);
            Assert.assertTrue(cartPage.isProductInCart(), "Product should be in cart");
            // 4. Proceed to checkout
            cartPage.proceedToCheckout();
            Thread.sleep(5000);
            cartPage.proceedToCheckoutAfterSignIn();
            Thread.sleep(5000);

            // 5. Fill shipping and payment info
            Checkout checkoutPage = new Checkout(driver);
            checkoutPage.fillShippingInfo(address, city, state, postalCode, country);
            Thread.sleep(2000);
            checkoutPage.proceedToCheckoutAfterBilling();
            Thread.sleep(5000);

            checkoutPage.fillPaymentInfo(firstName, lastName, cardNumber, expiry, cvv);

            // 6. Place order
            checkoutPage.placeOrder();
            Thread.sleep(3000);
            checkoutPage.placeOrder();
            Thread.sleep(3000);
            System.out.println("Order completed successfully. Order #: " +
                    checkoutPage.orderMessage());

        } catch (Exception e) {
            Assert.fail("Test failed: " + e.getMessage());
        }
    }

    @DataProvider(name = "checkoutData")
    public Object[][] getCheckoutTestData() {
        return TestData.getCheckoutTestData();
    }
}