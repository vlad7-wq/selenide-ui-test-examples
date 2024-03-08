package work_with_web_elements;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {

    private Faker faker;

    @BeforeTest
    public void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        faker = new Faker();

        open("/text-box");
    }

    @Test
    public void fillTextForm() {
        String name = faker.name().fullName();
        String email = faker.internet().emailAddress();
        String currentAddress = faker.address().fullAddress();
        String permanentAddress = faker.address().secondaryAddress();

        $(".text-center").shouldHave(text("Text Box"));

        $("#userName").setValue(name);
        $("#userEmail").setValue(email);
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(permanentAddress);
        $("#submit").click();

        $("#name").shouldHave(text("Name:" + name));
        $("#email").shouldHave(text("Email:" + email));
        $("#currentAddress.mb-1").shouldHave(text("Current Address :" + currentAddress));
        $("#permanentAddress.mb-1").shouldHave(text("Permananet Address :" + permanentAddress));
    }
}
