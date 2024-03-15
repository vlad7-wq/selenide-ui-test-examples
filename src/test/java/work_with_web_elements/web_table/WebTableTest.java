package work_with_web_elements.web_table;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WebTableTest {
    private UserData userData;
    private AddNewUserModal modal;
    private TableBody table;

    @BeforeTest
    public void setUp() {
        Configuration.browserSize = "1920x1080";
        open("https://demoqa.com/webtables");
        userData = UserDataProvider.getValidUserData();
        modal = new AddNewUserModal();
        table = new TableBody();
    }

    @Test(priority = -1)
    public void addNewUser() {
        table.clickOnAddBtn();
        modal.setUserDataInForm
                (userData.getFirstName(), userData.getLastName(), userData.getEmail(),
                        userData.getAge(), userData.getSalary(), userData.getDepartment());
        modal.clickSubmitBtn();

        assertTrue($(byText(userData.getFirstName())).should().exists());
    }

    @Test(dependsOnMethods = { "addNewUser" })
    @Description("find user via search field and verify correctness of user data")
    public void findUserInTableBySearch() {
        table.searchRecord(userData.getFirstName());
        table.verifySearchResult
                (userData.getFirstName(), userData.getLastName(), userData.getAge(),
                        userData.getEmail(), userData.getSalary(), userData.getDepartment());
    }

    @Test
    public void verifySizeOfTable() {
        assertEquals(table.verifySizeOfTable(), 10);
    }
}
