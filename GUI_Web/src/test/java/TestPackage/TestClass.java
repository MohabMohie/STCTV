package TestPackage;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Subscribe;

public class TestClass {
    private final ThreadLocal<SHAFT.GUI.WebDriver> driver = new ThreadLocal<>();

    @Epic("STC TV Web GUI Sample")
    @Story("Validate Package Information")
    @Description("Given I am on the Subscriptions page,\nThen the subscription packages information should be correct.")
    @Test(description = "Check package information for KSA.")
    public void checkPackageInformationForKSA() {
        new Subscribe(driver).navigate(Subscribe.Locale.KSA)
                .verifySubscriptionPackageInformation();
    }

    @Epic("STC TV Web GUI Sample")
    @Story("Validate Package Information")
    @Description("Given I am on the Subscriptions page,\nThen the subscription packages information should be correct.")
    @Test(description = "Check package information for BAHRAIN.")
    public void checkPackageInformationForBahrain() {
        new Subscribe(driver).navigate(Subscribe.Locale.BAHRAIN)
                .verifySubscriptionPackageInformation();
    }

    @Epic("STC TV Web GUI Sample")
    @Story("Validate Package Information")
    @Description("Given I am on the Subscriptions page,\nThen the subscription packages information should be correct.")
    @Test(description = "Check package information for KUWAIT.")
    public void checkPackageInformationForKuwait() {
        new Subscribe(driver).navigate(Subscribe.Locale.KUWAIT)
                .verifySubscriptionPackageInformation();
    }

    @BeforeMethod(description = "Setup Browser instance.")
    public void beforeMethod() {
        driver.set(new SHAFT.GUI.WebDriver());
    }

    @AfterMethod(description = "Teardown Browser instance.")
    public void afterMethod() {
        driver.get().quit();
    }
}
