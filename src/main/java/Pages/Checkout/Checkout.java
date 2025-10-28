package Pages.Checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import java.lang.Thread;
import java.time.Duration;

public class Checkout {
    WebDriver driver;

    // Shipping fields
    By address = By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[3]/app-address/div/div/div/form/div/div[1]");
    By city = By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[3]/app-address/div/div/div/form/div/div[2]");
    By state = By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[3]/app-address/div/div/div/form/div/div[3]");
    By country = By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[3]/app-address/div/div/div/form/div/div[4]");
    By postalCode = By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[3]/app-address/div/div/div/form/div/div[5]");
    // Checkout buttons
    By proceedToCheckoutButton = By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[3]/app-address/div/div/div/div/button");
    By paymentList = By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-completion-step/app-payment/div/div/div/form/div[1]/select");
    By optionForCreditCard = By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-completion-step/app-payment/div/div/div/form/div[1]/select/option[4]");
    // Payment fields
    By cardNumber = By.id("credit_card_number");
    By expiryDate = By.id("expiration_date");
    By cvv = By.id("cvv");
    By cardHolderName = By.id("card_holder_name");

    By placeOrderButton = By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-completion-step/app-payment/div/div/div/div/button");
    By confirmationMessage = By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-completion-step/app-payment/div/div/div/span");

    public Checkout(WebDriver driver) {
        this.driver = driver;
    }

    public void fillShippingInfo(String addr,
                                 String cityName, String zip, String countryName) {

        driver.findElement(address).sendKeys(addr);
        driver.findElement(city).sendKeys(cityName);
        driver.findElement(state).sendKeys(cityName);
        driver.findElement(country).sendKeys(countryName);
        driver.findElement(postalCode).sendKeys(zip);
    }

    public void fillPaymentInfo(String first, String last, String card, String expiry, String securityCode) {
        driver.findElement(paymentList).click();
        driver.findElement(optionForCreditCard).click();
        driver.findElement(cardNumber).sendKeys(card);
        driver.findElement(expiryDate).sendKeys(expiry);
        driver.findElement(cvv).sendKeys(securityCode);
        driver.findElement(cardHolderName).sendKeys(first + " " + last);
    }

    public void proceedToCheckoutAfterBilling() {
        driver.findElement(proceedToCheckoutButton).click();
    }

    public void placeOrder() {
        driver.findElement(placeOrderButton).click();
    }

    public String orderMessage() {
        return driver.findElement(confirmationMessage).getText();
    }
}