package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import page.objects.*;

import static com.codeborne.selenide.Selenide.open;
import static navigation.ApplicationURLs.LOGIN_URL;

public class CorrectAdd2ProductsToCart extends TestBase {
    @Severity(SeverityLevel.NORMAL)
    @Test
    @Description("The goal of this test is correctly add 2 same product to cart")
    public void correctAdd2Product() {
        open(LOGIN_URL);
        LoginPage loginPage = new LoginPage();
        loginPage.clearFields();
        loginPage.typeOfUsername("j2ee");
        loginPage.typeOfPassword("j2ee");
        loginPage.clickOnLoginButton();

        MainProductPage mainProductPage = new MainProductPage();
        mainProductPage.clickFishFromTP();

        FishPage fishPage = new FishPage();
        fishPage.addAngelFishProduct();

        AngelFishPage angelFishPage = new AngelFishPage();
        angelFishPage.addToCartLargeAngelFish();

        ShoppingCartPage shoppingCart = new ShoppingCartPage();
        shoppingCart.headerH2.shouldHave(Condition.text("Shopping Cart"));
        shoppingCart.quantityFiled.shouldHave(Condition.value("1"));
    }
}
