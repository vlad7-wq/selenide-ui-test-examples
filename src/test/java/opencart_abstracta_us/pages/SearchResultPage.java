package opencart_abstracta_us.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchResultPage {

    private final SelenideElement searchResultItem = $(".product-layout");
    private final SelenideElement searchResultTitle = $("#content > h1");
    private final SelenideElement searchResultFirstItem = $("div[class='product-thumb'] > div");

    public void verifySearchResul(String val) {
        searchResultTitle.shouldHave(text("Search - " + val));
        searchResultItem.should(exist);
    }

    public void clickOnFirstSearchResultItem() {
        searchResultFirstItem.click();
    }
}
