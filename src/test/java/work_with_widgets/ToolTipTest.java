package work_with_widgets;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ToolTipTest {

    @Test
    public void testTooltip() {
        Configuration.browserSize = "1920x1080";
        Configuration.headless = true;
        open("https://demoqa.com/tool-tips");

        $("#toolTipTextField").hover();
        $("#textFieldToolTip div[class='tooltip-inner']").shouldHave(text("You hovered over the text field"));
    }
}
