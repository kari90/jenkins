package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.objects.FooterPage;
import page.objects.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.AssertJUnit.assertTrue;


public class PositiveLoginTest extends TestBase {

    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Description("The goal of this test is to log in using valid username and password" +
            "and check if Dog banner is displayed after login on page footer and check if all side bars are displayed.")
    public void asUserLogInUsingValidLoginAndPassword() {
        open(LOGIN_URL);
        LoginPage loginPage = new LoginPage();
        loginPage.clearFields();
        loginPage.typeOfUsername("j2ee");
        loginPage.typeOfPassword("j2ee");
        loginPage.clickOnLoginButton();

       FooterPage footerPage = new FooterPage();
      //  assertTrue(footerPage.isBannerAfterLoginDisplayed());
      //  footerPage.footerBanner.isDisplayed();
        footerPage.footerBanner.shouldBe(Condition.visible);
    }
}