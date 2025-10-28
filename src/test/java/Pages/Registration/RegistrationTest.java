package Pages.Registration;

public class RegistrationTest {

    final Registration registration = new Registration();

    @org.testng.annotations.Test(priority = 1)
    public void RegisterWithUser() throws InterruptedException {
        registration.RegisterWithValidUser();
    }
}
