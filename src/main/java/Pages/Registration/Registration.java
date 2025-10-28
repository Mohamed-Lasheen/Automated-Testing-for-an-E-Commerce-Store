package Pages.Registration;

import Selenium.DriverFactory;
import TestData.Data;
import TestData.TestData;
import org.openqa.selenium.By;

import static Selenium.DriverFactory.driver;

public class Registration {

    public static void RegisterWithValidUser() throws InterruptedException {
        driver = DriverFactory.getDriver();
        driver.get("https://practicesoftwaretesting.com/auth/register");
        driver.findElement(By.id("first_name")).sendKeys("John");
        driver.findElement(By.id("last_name")).sendKeys("Doe");
        driver.findElement(By.id("dob")).sendKeys("2000-01-01");
        driver.findElement(By.id("street")).sendKeys("Temp Street");
        driver.findElement(By.id("postal_code")).sendKeys("12345");
        driver.findElement(By.id("city")).sendKeys("Cairo");
        driver.findElement(By.id("state")).sendKeys("Temp State");
        driver.findElement(By.id("country")).sendKeys("Egypt");
        driver.findElement(By.id("phone")).sendKeys("123456789");
        String email = TestData.fakeAccount;
        Data.email_new = email;
        driver.findElement(By.id("email")).sendKeys(email);
        String password = TestData.fakePassword;
        Data.password_new = password;
        driver.findElement(By.id("password")).sendKeys(password);
        System.out.println(Data.email_new);
        System.out.println(Data.password_new);
        driver.findElement(By.xpath("/html/body/app-root/div/app-register/div/div/div/form/div/button")).click();
        Thread.sleep(3000);
    }
}
