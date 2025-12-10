package page.objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class FishPage extends BasePage {
    public SelenideElement
            angelFishProduct = $("#Catalog a[href*='FI-SW-01']");

    @Step("Select AngelFish Product")
    public void addAngelFishProduct() {
        angelFishProduct.shouldBe(Condition.visible).click();
        log().info("Clicked on AngelFish Product to select kind of AngelFish - large AngelFish");
    }
}
