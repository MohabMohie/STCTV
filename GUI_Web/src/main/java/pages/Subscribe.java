package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;

public class Subscribe {
    private final ThreadLocal<SHAFT.GUI.WebDriver> driver;
    private final SHAFT.TestData.JSON testData;
    private final String url = "https://subscribe.stctv.com/";
    private final String planTypeLocator = "(//strong[@class='plan-title'])[${INDEX}]";
    private final String planCurrencyLocator = "//div[@class=\"price\"][contains(@id,'${PACKAGE_NAME}')]/i";
    private final String planPriceLocator = "//div[@class=\"price\"][contains(@id,'${PACKAGE_NAME}')]/b";
    private Locale locale;

    public Subscribe(ThreadLocal<SHAFT.GUI.WebDriver> driver) {
        this.driver = driver;
        this.testData = new SHAFT.TestData.JSON("simpleJSON.json");
    }

    @Step("When I navigate to the subscription page for '{locale}'.")
    public Subscribe navigate(Locale locale) {
        this.locale = locale;
        driver.get().browser().navigateToURL(url + locale.getValue());
        return this;
    }

    @Step("Then the subscription packages information should be correct.")
    public Subscribe verifySubscriptionPackageInformation() {
        // note that using loops is not recommended due to the test automation complexity paradox. It states that writing complex code to test
        // complex code is a paradox, because that test code will require testing in and of itself. Hence, it is recommended not to
        // write any code that would increase the cyclomatic complexity of test code, such as conditions, switches, and loops.

        // another note is that data validations are better done via API test automation not GUI as it has a much lower cost of development
        // , cost of maintenance, and cost of execution.

        verifySubscriptionPackageTypes()
                .verifySubscriptionPackageCurrency(Package.LITE)
                .verifySubscriptionPackageCurrency(Package.CLASSIC)
                .verifySubscriptionPackageCurrency(Package.PREMIUM)
                .verifySubscriptionPackagePrice(Package.LITE)
                .verifySubscriptionPackagePrice(Package.CLASSIC)
                .verifySubscriptionPackagePrice(Package.PREMIUM);
        return this;
    }

    @Step("And the type is correct.")
    private Subscribe verifySubscriptionPackageTypes() {
        // there are exactly three plans, and the types are listed in the enum below

        // first one should be LITE
        driver.get().element().verifyThat(By.xpath(planTypeLocator.replace("${INDEX}", "1")))
                .text().equalsIgnoringCaseSensitivity(Package.LITE).perform();

        // second one should be CLASSIC
        driver.get().element().verifyThat(By.xpath(planTypeLocator.replace("${INDEX}", "2")))
                .text().equalsIgnoringCaseSensitivity(Package.CLASSIC).perform();

        // third one should be PREMIUM
        driver.get().element().verifyThat(By.xpath(planTypeLocator.replace("${INDEX}", "3")))
                .text().equalsIgnoringCaseSensitivity(Package.PREMIUM).perform();
        return this;
    }

    @Step("And the currency is correct for {packageName}.")
    private Subscribe verifySubscriptionPackageCurrency(Package packageName) {
        // all three plans should have the correct currency for the target locale as per the test data file
        driver.get().element().verifyThat(By.xpath(planCurrencyLocator.replace("${PACKAGE_NAME}", packageName.name().toLowerCase())))
                .text().isEqualTo(testData.getTestData("packages." + locale.name() + ".currency")).perform();
        return this;
    }

    @Step("And the package price is correct for {packageName}.")
    private Subscribe verifySubscriptionPackagePrice(Package packageName) {
        // each plan should have the correct price for the target locale as per the test data file
        driver.get().element().verifyThat(By.xpath(planPriceLocator.replace("${PACKAGE_NAME}", packageName.name().toLowerCase())))
                .text().isEqualTo(testData.getTestData("packages." + locale.name() + "." + packageName.name() + ".price")).perform();
        return this;
    }

    public enum Locale {
        KSA("sa-en"), BAHRAIN("bh-en"), KUWAIT("kw-en");
        @Getter
        final private String value;

        Locale(String value) {
            this.value = value;
        }
    }

    public enum Package {LITE, CLASSIC, PREMIUM}
}
