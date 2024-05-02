package opencart_abstracta_us.tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import opencart_abstracta_us.data.BillingDetailsData;
import opencart_abstracta_us.data.BillingDetailsDataProvider;
import opencart_abstracta_us.data.LogInData;
import opencart_abstracta_us.pages.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.testng.Assert.assertTrue;


public class E2ETest {
    LogInData logInData;
    BillingDetailsData bData;
    HomePage homePage;
    SearchResultPage searchResultPage;
    ProductDetailsPage productPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    @BeforeTest
    public void setUp() {
        BasePage.setUp();
        logInData = new LogInData();
        bData = BillingDetailsDataProvider.getBillingDetailsData();
        homePage = new HomePage();
        searchResultPage = new SearchResultPage();
        productPage = new ProductDetailsPage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
    }

    @Test
    @Description
            ("Example of end to end test, using page object model, where existing user goes to online store, " +
                    "looking for a product and buy something")
    public void buyProductEnd2EndTest() {
        open(Configuration.baseUrl);

        // open home page and check that url is correct
        assertThat(homePage.getHomePageUrl(), equalTo("https://opencart.abstracta.us/"));
        // log in with existing user
        homePage.logIn(logInData.getEmail(), logInData.getPassword());
        // check if there is something in cart, if so - clear cart
        homePage.checkAndClearCart();
        // enter product name into search field and press enter
        homePage.setValueInSearchFieldAndPressEnter("iphone");
        // check search result
        searchResultPage.verifySearchResul("iphone");
        // click on first product in search result
        searchResultPage.clickOnFirstSearchResultItem();
        // check correctness of product on product details page
        productPage.verifyThatProductTitleIsCorrect("iPhone");
        productPage.verifyProductPrice("$123.20");
        assertTrue(productPage.verifyMainProductImage());
        // click add to cart button
        productPage.clickOnAddToCartBtn();
        // click on cart menu and go to cart page
        homePage.clickOnCartDropDown();
        homePage.clickOnViewCartBtn();
        // check product in cart
        cartPage.verifyProductName("iPhone");
        cartPage.verifyProductTotalPrice("$123.20");
        // click on checkout button
        cartPage.clickOnCheckoutBtn();
        // add new billing details
        checkoutPage.selectNewAddressBtn();
        checkoutPage.setBillingDetails
                (bData.getFirstName(), bData.getLastName(), bData.getAddress(), bData.getCity(),
                        bData.getPostCode(), bData.getCountry(), bData.getRegionState());
        // pass all next steps
        checkoutPage.ClickOnDeliveryDetailsContinueBtn();
        checkoutPage.clickDeliveryMethodContinueBtn();
        // set payment method
        checkoutPage.setPaymentMethod();
        // check final price and product name
        checkoutPage.verifyProductName("iPhone");
        checkoutPage.verifyFinalPrice("$131.20");
    }
}
