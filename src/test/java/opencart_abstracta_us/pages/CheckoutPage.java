package opencart_abstracta_us.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage {

    private final SelenideElement newAddressBtn = $("input[value='new']");
    private final SelenideElement fName = $("#input-payment-firstname");
    private final SelenideElement lName = $("#input-payment-lastname");
    private final SelenideElement address = $("#input-payment-address-1");
    private final SelenideElement city = $("#input-payment-city");
    private final SelenideElement postCode = $("#input-payment-postcode");
    private final SelenideElement country = $("#input-payment-country");
    private final SelenideElement regionState = $("#input-payment-zone");
    private final SelenideElement billingContinueBtn = $("#button-payment-address");
    private final SelenideElement shippingContinueBtn = $("#button-shipping-address");
    private final SelenideElement methodContinueBtn = $("#button-shipping-method");
    private final SelenideElement paymentMethodBtn = $(byAttribute("value", "cod"));
    private final SelenideElement termsAndCondCheckBox = $("input[name='agree']");
    private final SelenideElement paymentContinueBtn = $("#button-payment-method");
    private final SelenideElement confirmOrderProductName =
            $("table[class='table table-bordered table-hover'] > tbody tr a:nth-child(1)");
    private final SelenideElement getConfirmOrderTotalPrice =
            $("#collapse-checkout-confirm > div > div.table-responsive > table > tfoot > tr:nth-child(5) > td:nth-child(2)");


    public void selectNewAddressBtn() {
        newAddressBtn.click();
    }

    public void setBillingDetails
            (String fName, String lName, String address, String city,
             String postCode, String country, String regionState) {
        this.fName.setValue(fName);
        this.lName.setValue(lName);
        this.address.setValue(address);
        this.city.setValue(city);
        this.postCode.setValue(postCode);
        this.country.selectOption(country);
        this.regionState.selectOption(regionState);
        billingContinueBtn.click();
    }

    public void ClickOnDeliveryDetailsContinueBtn() {
        shippingContinueBtn.click();
    }

    public void clickDeliveryMethodContinueBtn() {
        methodContinueBtn.click();
    }

    public void setPaymentMethod() {
        paymentMethodBtn.click();
        termsAndCondCheckBox.click();
        paymentContinueBtn.click();
    }

    public void verifyProductName(String name) {
        confirmOrderProductName.shouldHave(text(name));
    }

    public void verifyFinalPrice(String price) {
        getConfirmOrderTotalPrice.shouldHave(text(price));
    }
}
