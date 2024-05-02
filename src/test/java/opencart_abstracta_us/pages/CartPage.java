package opencart_abstracta_us.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {

    private final SelenideElement productName = $("#content > form > div > table > tbody > tr > td:nth-child(2) > a");
    private final SelenideElement productTotalPrice =
            $("#content > form > div > table > tbody > tr > td:nth-child(6)");
    private final SelenideElement  checkoutBtn = $("a[class='btn btn-primary']");

    public void verifyProductName(String name) {
        productName.shouldHave(text(name));
    }

    public void verifyProductTotalPrice(String price) {
        productTotalPrice.shouldHave(text(price));
    }

    public void clickOnCheckoutBtn() {
        checkoutBtn.click();
    }
}
