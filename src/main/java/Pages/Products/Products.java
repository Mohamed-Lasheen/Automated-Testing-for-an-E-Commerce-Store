package Pages.Products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class Products {
    WebDriver driver;
    By productLinks = By.xpath("/html/body/app-root/div/app-overview/div[3]/div[2]/div[1]/a");
    By addToCartButton = By.xpath("/html/body/app-root/div/app-detail/div[1]/div[2]/div[4]/button[1]");
    By cartIcon = By.xpath("/html/body/app-root/app-header/nav/div/div/ul/li[5]/a");

    public Products(WebDriver driver) {
        this.driver = driver;
    }

    public void selectProduct(String productName) {
        List<WebElement> products = driver.findElements(productLinks);
        System.out.println(productName);
        for (WebElement product : products) {
            if (product.getText().contains(productName)) {
                product.click();
                break;
            }
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));
    }

    public void addToCart() {
        driver.findElement(addToCartButton).click();
    }

    public void goToCart() {
        System.out.println(driver.findElement(cartIcon));
        driver.findElement(cartIcon).click();
    }
}