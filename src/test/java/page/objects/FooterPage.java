package page.objects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class FooterPage extends BasePage {
    public SelenideElement
            footerBanner = $("#Banner img[src*='dog']");

    @Step("Banner after Login is Displayed")
    public boolean isBannerAfterLoginDisplayed() {
        boolean isDisplayed = footerBanner.isDisplayed();
        log().info("Banner After Login is displayed?: {}", isDisplayed);
        return isDisplayed;
    }
}