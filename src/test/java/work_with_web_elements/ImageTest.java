package work_with_web_elements;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ImageTest {

    @Test
    public void checkImage() {
        open("https://demoqa.com/broken");

        $(".text-center + p + img")
                .shouldHave(attribute("src", "https://demoqa.com/images/Toolsqa.jpg"))
                .isImage();
    }
}
