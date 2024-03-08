package work_with_web_elements;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DropDownTest {

    @Test
    public void verifyDropDown() {
        open("https://the-internet.herokuapp.com/dropdown");

        $("#dropdown").selectOption(1);
        $("#dropdown :nth-child(2)").shouldHave(attribute("selected", "true"));
        $("#dropdown :nth-child(2)").shouldHave(text("Option 1"));

        $("#dropdown").selectOption("Option 2");
        $("#dropdown :nth-child(3)").shouldHave(attribute("selected", "true"));
        $("#dropdown :nth-child(3)").shouldHave(text("Option 2"));
    }
}
