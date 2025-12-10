package page.objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class TopMenuPage extends BasePage {
    private SelenideElement
            signOutButton = $("#MenuContent a[href*='ou']");

    @Step("Clicked Log Out from Top Menu")
    public void clickLogOut() {
        signOutButton.shouldBe(Condition.visible).shouldBe(Condition.enabled).click();
        log().info("User clicked Log Out button");
    }
}

