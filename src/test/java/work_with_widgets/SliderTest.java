package work_with_widgets;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.*;

public class SliderTest {

    @Test
    public void sliderTest() {
        Configuration.browserSize = "1920x1080";
        Configuration.headless = true;
        open("https://demoqa.com/slider");

        SelenideElement el = $("span[class='range-slider__wrap']");
        actions().dragAndDropBy(el, 250, 0).perform();
        $("#sliderValue").shouldHave(attribute("value", "100"));
    }
}
