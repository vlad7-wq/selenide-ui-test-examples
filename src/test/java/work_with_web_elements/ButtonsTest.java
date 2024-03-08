package work_with_web_elements;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RadioButtonTest {

    @Test
    public void verifyRadioBtn() {
        open("https://formy-project.herokuapp.com/radiobutton");

        // selenide selectRadio() method works only if there is a 'value' attribute exist
        $(byValue("option2")).shouldNotBe(selected).selectRadio("option2");
        $(byValue("option2")).shouldBe(selected);
    }
}
