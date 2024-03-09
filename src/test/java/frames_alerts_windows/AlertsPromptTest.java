package frames_alerts_windows;

import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class AlertsPromptTest {

    @Test
    public void switchToAlert() {
        open("https://demoqa.com/alerts");

        $("#alertButton").scrollTo().click();

        String text = switchTo().alert().getText();
        assertThat(text, equalTo("You clicked a button"));
    }

    @Test
    public void switchToAlertWithDelay() {
        open("https://demoqa.com/alerts");

        $("#timerAlertButton").scrollTo().click();

        String text = switchTo().alert(Duration.ofSeconds(6)).getText();
        assertThat(text, equalTo("This alert appeared after 5 seconds"));
    }

    @Test
    public void switchToAlertWithConfirm() {
        open("https://demoqa.com/alerts");

        $("#confirmButton").scrollTo().click();
        switchTo().alert().accept();
        $("#confirmResult").shouldHave(text("You selected Ok"));

        $("#confirmButton").shouldBe(clickable).click();
        switchTo().alert().dismiss();
        $("#confirmResult").shouldHave(text("You selected Cancel"));
    }

    @Test
    public void switchToPrompt() {
        open("https://demoqa.com/alerts");
        String s = "Test Text Here";

        $("#promtButton").scrollTo().click();
        switchTo().alert().sendKeys(s);
        switchTo().alert().accept();
        $("#promptResult").shouldHave(text("You entered " + s));
    }
}
