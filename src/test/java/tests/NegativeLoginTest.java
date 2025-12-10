package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import page.objects.LoginPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.Assert.assertEquals;

public class NegativeLoginTest extends TestBase {

    @Issue("DEFECT-1")
    @TmsLink("ID-1")
    @Severity(SeverityLevel.NORMAL)
    @Test
    @Description("The goal of this test us to log in using not proper username and password" +
            "and check if warning message Invalid username or password is displayed")
    public void asUserTryToLogInWithIncorrectLoginAndPassword() {
        open(LOGIN_URL);
        LoginPage loginPage = new LoginPage();
        loginPage.clearFields();
        loginPage.typeOfUsername("incorrect");
        loginPage.typeOfPassword("incorrect");
        loginPage.clickOnLoginButton();

        //String warningMessage = loginPage.warningMessage();
       // assertEquals(warningMessage, "Invalid username or password. Signon failed.");
        loginPage.warningMessageLabel.shouldHave(Condition.text("Invalid username or password. Signon failed."));
    }

}