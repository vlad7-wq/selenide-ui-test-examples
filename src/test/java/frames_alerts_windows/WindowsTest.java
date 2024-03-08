package frames_alerts_windows;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class WindowsTest {

    @Test
    public void switchToNewTab() {
        open("https://demoqa.com/links");

        $("#simpleLink")
                .shouldHave(attribute("href", "https://demoqa.com/"))
                .shouldHave(attribute("target", "_blank"))
                .shouldHave(text("Home"))
                .click();


        String title = switchTo().window(1).getTitle();
        String newPageUrl = switchTo().window(1).getCurrentUrl();

        assertThat(title, equalTo("DEMOQA"));
        assertThat(newPageUrl, equalTo("https://demoqa.com/"));
    }
}
