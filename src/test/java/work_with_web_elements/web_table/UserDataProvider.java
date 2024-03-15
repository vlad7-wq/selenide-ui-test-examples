package work_with_web_elements.web_table;

import com.github.javafaker.Faker;

public class UserDataProvider {

    private static final Faker faker = new Faker();

    public static UserData getValidUserData() {

        UserData userData = new UserData();

        userData.setFirstName(faker.name().firstName());
        userData.setLastName(faker.name().lastName());
        userData.setEmail(faker.internet().emailAddress());
        userData.setAge(faker.number().numberBetween(18, 100));
        userData.setSalary(faker.number().numberBetween(10000, 100000));
        userData.setDepartment("Random Department");

        return userData;
    }
}
