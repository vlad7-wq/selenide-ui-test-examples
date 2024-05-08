package opencart_abstracta_us.pages;

import com.codeborne.selenide.Configuration;

public class BasePage {

    public static void setUp() {
        Configuration.headless = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://opencart.abstracta.us";
    }
}
