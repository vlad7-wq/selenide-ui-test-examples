package frames_alerts_windows;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class FrameTest {

    @Test
    public void iFrameTest() {
        open("https://demoqa.com/frames");

        switchTo().frame("frame1");
        String t = $("#sampleHeading").getText();
        assertThat(t, equalTo("This is a sample page"));
    }
}
