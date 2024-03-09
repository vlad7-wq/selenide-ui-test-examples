package frames_alerts_windows;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class WindowsTest {

    @Test
    public void switchToNewTab() {
        // this approach works for new tabs and windows
        open("https://demoqa.com/links");

        $("#simpleLink")
                .shouldHave(attribute("href", "https://demoqa.com/"))
                .shouldHave(attribute("target", "_blank"))
                .shouldHave(text("Home"))
                .click();

        // it is possible to select window by index (as on example below) or by title
        String newPageUrl = switchTo().window(1).getCurrentUrl();
        assertThat(newPageUrl, equalTo("https://demoqa.com/"));
    }
}
