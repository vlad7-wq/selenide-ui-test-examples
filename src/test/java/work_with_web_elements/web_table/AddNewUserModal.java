package work_with_web_elements.web_table;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AddNewUserModal {

    private final SelenideElement firstName = $("#firstName");
    private final SelenideElement lastName = $("#lastName");
    private final SelenideElement email = $("#userEmail");
    private final SelenideElement age = $("#age");
    private final SelenideElement salary = $("#salary");
    private final SelenideElement department = $("#department");
    private final SelenideElement submitBtn = $("#submit");

    public void setUserDataInForm
            (String firstName, String lastName, String email, int age, int salary, String department) {

        this.firstName.setValue(firstName);
        this.lastName.setValue(lastName);
        this.email.setValue(email);
        this.age.setValue(String.format("%d", age));
        this.salary.setValue(String.format("%d", salary));
        this.department.setValue(department);
    }

    public void clickSubmitBtn() {
        submitBtn.click();
    }
}
