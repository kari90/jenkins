package page.objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class ShoppingCartPage extends BasePage {
    public SelenideElement headerH2 = $("#Cart h2"),
            quantityFiled = $("#Cart input[size='3']");

    @Step("Information  about shopping Cart")
    public void isShoppingCartDisplayed() {
        headerH2.shouldBe(Condition.visible).shouldHave(Condition.text("Shopping Cart"));
        log().info("Successfully displayed Shop Cart with header 'Shopping Cart'");
    }

    @Step("Check quantity number")
    public String quantityNumber() {
        //String quantity = quantityFiled.getAttribute("value");
        String quantity = String.valueOf(quantityFiled.shouldHave(Condition.value("1")));
        log().info("In Shopping cart quantity is: {}", quantity);
        return quantity;
    }
}
