package opencart_abstracta_us.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class HomePage {

    private final SelenideElement searchField = $("input[type='text']");
    private final SelenideElement cartDropDownMenu = $("#cart");
    private final SelenideElement viewCartBtn = $("p[class='text-right'] a:nth-child(1)");
    private final SelenideElement removeBtn = $("button[title='Remove']");
    private final SelenideElement myAccountDropDownMenu = $("a[title='My Account']");
    private final SelenideElement loginPage = $(byText("Login"));
    private final SelenideElement emailField = $("#input-email");
    private final SelenideElement passwordField = $("#input-password");
    private final SelenideElement loginBtn = $(byAttribute("value", "Login"));

    public void setValueInSearchFieldAndPressEnter(String val) {
        searchField.setValue(val).pressEnter();
    }

    public void clickOnCartDropDown() {
        cartDropDownMenu.click();
    }

    public void clickOnViewCartBtn() {
        viewCartBtn.click();
    }

    public String getHomePageUrl() {
        return WebDriverRunner.url();
    }

    public void logIn(String email, String pwd) {
        myAccountDropDownMenu.click();
        loginPage.click();
        emailField.setValue(email);
        passwordField.setValue(pwd);
        loginBtn.click();
    }

    public void checkAndClearCart() {
        while (removeBtn.exists()) {
            cartDropDownMenu.click();
            removeBtn.click();
            actions().pause(Duration.ofSeconds(1)).perform();
        }
    }
}
