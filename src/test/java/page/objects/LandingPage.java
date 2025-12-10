package page.objects;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LandingPage extends BasePage {

    private SelenideElement
            enterStoreLink = $(By.cssSelector("#Content a"));

    @Step("Click on Enter Store Link")
    public void clickOnEnterStoreLink() {
        enterStoreLink.shouldBe(Condition.enabled).shouldBe(Condition.visible).click();
        log().info(" Succesfully clicked on Enter Store link ");
    }
}


