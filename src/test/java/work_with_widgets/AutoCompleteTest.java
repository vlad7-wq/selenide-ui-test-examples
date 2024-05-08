package work_with_widgets;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;

public class AutoCompleteTest {

    @Test
    public void testAutoComplete() {
        Configuration.browserSize = "1920x1080";
        Configuration.headless = true;
        open("https://demoqa.com/auto-complete");

        $("#autoCompleteMultipleInput").setValue("bl").pressTab();
        $("#autoCompleteMultipleInput").setValue("a").sendKeys(Keys.DOWN);
        $("#autoCompleteMultipleInput").sendKeys(Keys.DOWN);
        $("#autoCompleteMultipleInput").pressTab();

        List<String> actualResult = $$("div[class='css-12jo7m5 auto-complete__multi-value__label']").texts();
        List<String> expectedResult = Arrays.asList("Blue", "Aqua");
        assertEquals(actualResult, expectedResult);
    }
}
