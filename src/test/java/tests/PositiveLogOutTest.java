package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import page.objects.FooterPage;
import page.objects.LoginPage;
import page.objects.TopMenuPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.AssertJUnit.assertTrue;

public class PositiveLogOutTest extends TestBase {

    @Severity(SeverityLevel.NORMAL)
    @Test
    @Description("The goal of this test is reach after correctly logi out")

    public void correctlyLogOut() {
        open(LOGIN_URL);
        LoginPage loginPage = new LoginPage();
        loginPage.clearFields();
        loginPage.typeOfUsername("j2ee");
        loginPage.typeOfPassword("j2ee");
        loginPage.clickOnLoginButton();

        FooterPage footerPage = new FooterPage();
        assertTrue(footerPage.isBannerAfterLoginDisplayed());

        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage.clickLogOut();
        //assertTrue(!footerPage.isBannerAfterLoginDisplayed());
        footerPage.footerBanner.shouldNotBe(Condition.visible);
    }
}
