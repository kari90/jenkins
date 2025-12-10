package page.objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class AngelFishPage extends BasePage {

    public SelenideElement
            largeAngelFishProduct = $("#Catalog a[href*='EST-1']"),
            addToCartButton1 = $("#Catalog a[href*='workingItemId=EST-1']");

    @Step("Add AngelFish - Large Angelfish to Cart")
    public void addToCartLargeAngelFish() {
        addToCartButton1.shouldBe(Condition.visible).click();
        log().info("Add to cart Large Angelfish to Cart");
    }
    @Step("Add AngelFish - Large Angelfish to Cart")
    public void addToCartLargeAngelFish2() {
        addToCartButton1.shouldBe(Condition.visible).click();
        log().info("Add to cart Large Angelfish to Cart");
    }
}
