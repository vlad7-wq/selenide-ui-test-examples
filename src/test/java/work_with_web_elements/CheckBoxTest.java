package work_with_web_elements;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CheckBoxTest {

    @Test
    public void verifyCheckBox() {
        open("https://the-internet.herokuapp.com/checkboxes");

        $("form :nth-child(1)")
                .shouldHave(type("checkbox"))
                .shouldNotBe(checked)
                .click();

        $("form :nth-child(1)").shouldBe(checked);
    }

    @Test
    public void verifyAnotherCheckBox() {
        open("https://demoqa.com/checkbox");

        $(".rct-text button[title='Toggle']").click();
        $("label[for='tree-node-documents'] .rct-checkbox :first-child")
                .shouldHave(attribute("class","rct-icon rct-icon-uncheck"))
                .click();

        $("label[for='tree-node-documents'] .rct-checkbox :first-child")
                .shouldHave(attribute("class","rct-icon rct-icon-check"));
    }
}
