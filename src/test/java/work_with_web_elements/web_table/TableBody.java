package work_with_web_elements.web_table;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TableBody {

    private final SelenideElement addBtn = $("#addNewRecordButton");
    private final SelenideElement searchInput = $("#searchBox");
    private final ElementsCollection rowsInTable = $$(".rt-tr-group");
    private final SelenideElement searchResultFirstName = $("div[class='rt-tr -odd'] :nth-child(1)");
    private final SelenideElement searchResultLastName = $("div[class='rt-tr -odd'] :nth-child(2)");
    private final SelenideElement searchResultAge = $("div[class='rt-tr -odd'] :nth-child(3)");
    private final SelenideElement searchResultEmail = $("div[class='rt-tr -odd'] :nth-child(4)");
    private final SelenideElement searchResultSalary = $("div[class='rt-tr -odd'] :nth-child(5)");
    private final SelenideElement searchResultDepartment = $("div[class='rt-tr -odd'] :nth-child(6)");

    public int verifySizeOfTable() {
        return rowsInTable.size();
    }

    public void verifySearchResult(String fName, String lName, int age, String email, int salary, String dep) {
        searchResultFirstName.shouldHave(text(fName));
        searchResultLastName.shouldHave(text(lName));
        searchResultAge.shouldHave(text(String.format("%d", age)));
        searchResultEmail.shouldHave(text(email));
        searchResultSalary.shouldHave(text(String.format("%d", salary)));
        searchResultDepartment.shouldHave(text(dep));
    }

    public void searchRecord(String val) {
        searchInput.setValue(val);
    }

    public void clickOnAddBtn() {
        addBtn.click();
    }
}
