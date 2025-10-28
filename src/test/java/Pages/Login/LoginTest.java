package Pages.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static Selenium.DriverFactory.driver;

public class LoginTest {

    @org.testng.annotations.Test(priority = 1)
    public void Login() throws InterruptedException {
        driver = Login.LoginWithValidUser();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement label_name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/app-overview/h1")));
        Assert.assertEquals(label_name.getText(), "My account");
        System.out.println(label_name.getText());
    }
}
