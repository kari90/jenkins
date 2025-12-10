package page.objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {


    private SelenideElement
            usernameField = $("#Catalog input[name*='username']");
    private SelenideElement passwordField = $("#Catalog input[name*='password']");
    private SelenideElement loginButton = $("#Catalog input[name*='signon']");
    public SelenideElement warningMessageLabel = $("#Content ul[class='messages'] li");

    @Step("Clear fields username and password")
    public void clearFields() {
        usernameField.shouldBe(Condition.visible).shouldBe(Condition.enabled).clear();
        usernameField.shouldBe(Condition.visible).shouldBe(Condition.enabled).clear();
        log().info("Fields has been cleared");
    }

    @Step("Type into username Filed")
    public void typeOfUsername(String username) {
        usernameField.shouldBe(Condition.visible).shouldBe(Condition.enabled).clear();
        usernameField.setValue(username);
        log().info("Typed into User Name Field {}", username);
    }

    @Step("Type into password Filed")
    public void typeOfPassword(String password) {
        usernameField.shouldBe(Condition.visible).shouldBe(Condition.enabled).clear();
        usernameField.setValue(password);
        log().info("Typed into User Name Field {}", password);
    }

    @Step("Click Login Button")
    public void clickOnLoginButton() {
        loginButton.shouldBe(Condition.visible).shouldBe(Condition.enabled).click();
        log().info("Clicked on Login Button");
    }

    @Step("Getting warning message")
    public String warningMessage() {
        warningMessageLabel.shouldBe(Condition.visible);
        String warningMessageText = warningMessageLabel.getText();
        log().info("Warning message is: {}", warningMessageText);
        return warningMessageText;
    }
}
