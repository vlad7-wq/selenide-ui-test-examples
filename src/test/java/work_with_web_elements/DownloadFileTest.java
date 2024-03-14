package work_with_web_elements;

import org.testng.annotations.Test;
import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;


public class DownloadFileTest {

    @Test
    public void downloadFileTest() {
        open("https://the-internet.herokuapp.com/download");

        File file = $(byText("some-file.txt")).download();

        assertThat(file).hasName("some-file.txt");
        assertThat(file).content().startsWith("blah");
    }

    @Test
    public void uploadFileTest() {
        open("https://the-internet.herokuapp.com/upload");

        $("#file-upload").uploadFromClasspath("cuteCat.jpg");
        $("#file-submit").click();

        $("h3").shouldHave(text("File Uploaded!"));
        $("#uploaded-files").shouldHave(text("cuteCat.jpg"));
    }
}
