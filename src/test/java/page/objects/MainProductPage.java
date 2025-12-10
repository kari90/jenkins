package page.objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainProductPage extends BasePage {

    //QuickLinks Menu QL
    public SelenideElement
            fishQL = $("#QuickLinks a[href*='FISH']");

    @Step("Click Fish form Top Menu")
    public void clickFishFromTP() {
        fishQL.shouldBe(Condition.visible).click();
        log().info("User clicked Fish From Top Menu");
    }
}
