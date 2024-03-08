package work_with_web_elements;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ButtonsTest {

    @Test
    public void verifyRadioBtn() {
        open("https://formy-project.herokuapp.com/radiobutton");

        // selenide selectRadio() method works only if there is a 'value' attribute exist
        $(byValue("option2")).shouldNotBe(selected).selectRadio("option2");
        $(byValue("option2")).shouldBe(selected);
    }

    @Test
    public void verifyDoubleClickOnBtn() {
        open("https://demoqa.com/buttons");

        $("#doubleClickBtn").doubleClick();
        $("#doubleClickMessage").shouldHave(text("You have done a double click"));
    }

    @Test
    public void verifyContextClickOnBth() {
        open("https://demoqa.com/buttons");

        $("#rightClickBtn").contextClick();
        $("#rightClickMessage").shouldHave(text("You have done a right click"));
    }

    @Test
    public void verifyClickOnBtn() {
        open("https://demoqa.com/buttons");

        $(byText("Click Me")).click();
        $("#dynamicClickMessage").shouldHave(text("You have done a dynamic click"));
    }
}
