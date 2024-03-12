package work_with_web_elements;

import org.testng.annotations.Test;
import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;


public class DownloadFileTest {

    @Test
    public void downloadFileTest() {
        open("https://the-internet.herokuapp.com/download");

        File file = $(byText("SomeFile.txt")).download();
        assertThat(file).hasName("SomeFile.txt");
        assertThat(file).content().isEqualTo("This is some text");
    }
}
