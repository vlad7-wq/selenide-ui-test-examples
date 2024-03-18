package opencart.abstracta.us.data;

import com.github.javafaker.Faker;

public class BillingDetailsDataProvider {

    private static final Faker faker = new Faker();

    public static BillingDetailsData getBillingDetailsData() {
        BillingDetailsData bDataDetails = new BillingDetailsData();

        bDataDetails.setFirstName(faker.name().firstName());
        bDataDetails.setLastName(faker.name().lastName());
        bDataDetails.setAddress(faker.address().fullAddress());
        bDataDetails.setCity(faker.address().city());
        bDataDetails.setPostCode(faker.address().countryCode());
        bDataDetails.setCountry("Canada");
        bDataDetails.setRegionState("Ontario");

        return bDataDetails;
    }
}
