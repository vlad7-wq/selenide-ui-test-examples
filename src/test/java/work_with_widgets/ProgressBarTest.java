package work_with_widgets;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;
import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ProgressBarTest {

    @Test
    public void testProgressBar() {
        Configuration.browserSize = "1920x1080";
        Configuration.headless = true;
        open("https://demoqa.com/progress-bar");

        $("#startStopButton").shouldHave(text("Start")).click();
        actions().pause(Duration.ofSeconds(11)).perform();

        $("#progressBar > div[class='progress-bar bg-success']").shouldHave(text("100%"));
        $("#resetButton").shouldHave(text("Reset"));
    }
}
