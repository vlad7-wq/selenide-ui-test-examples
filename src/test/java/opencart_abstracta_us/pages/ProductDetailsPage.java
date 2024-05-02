package opencart_abstracta_us.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class ProductDetailsPage {

    private final SelenideElement productTitle = $(".btn-group + h1");
    private final SelenideElement mainImage = $("#content > div:nth-child(1) > div.col-sm-8 > ul.thumbnails > li:nth-child(1) > a > img");
    private final SelenideElement productPrice = $("li h2");
    private final SelenideElement addToCartBtn = $("#button-cart");

    public void verifyThatProductTitleIsCorrect(String val) {
        productTitle.shouldHave(text(val));
    }

    public boolean verifyMainProductImage() {
        return mainImage.shouldBe(exist).isImage();
    }

    public void verifyProductPrice(String price) {
        productPrice.shouldHave(text(price));
    }

    public void clickOnAddToCartBtn() {
        addToCartBtn.click();
    }
}
