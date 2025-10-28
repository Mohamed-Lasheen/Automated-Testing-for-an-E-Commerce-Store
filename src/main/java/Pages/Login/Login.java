package Pages.Login;

import Selenium.DriverFactory;
import TestData.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static Selenium.DriverFactory.driver;

public class Login {

    public static WebDriver LoginWithValidUser() throws InterruptedException {
        driver = DriverFactory.getDriver();
        driver.get("https://practicesoftwaretesting.com/auth/login");
        String email = "customer@practicesoftwaretesting.com";
        String password = "welcome01";
        Data.email_new = email;
        Data.password_new = password;
        driver.findElement(By.id("email")).sendKeys(Data.email_new);
        driver.findElement(By.id("password")).sendKeys(Data.password_new);
        driver.findElement(By.xpath("/html/body/app-root/div/app-login/div/div/div/form/div[3]/input")).click();
        Thread.sleep(2000);
        return driver;
    }
}
