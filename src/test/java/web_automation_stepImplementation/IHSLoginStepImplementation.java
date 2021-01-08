package web_automation_stepImplementation;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import web_automation.Pages.IHSLoginPage;
import web_automation.util.driver.Driver;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class IHSLoginStepImplementation {
    private WebDriver driver = Driver.driver;
    private IHSLoginPage loginPage = PageFactory.initElements(driver, IHSLoginPage.class);

    @Step("Navigate to .NetFiddle login page")
    public void navigateToLoginPage() throws InterruptedException, IOException {
        // Given
        // When
        loginPage.navigateToLoginIHS();

        // Then
        assertThat(loginPage.checkLoginButtonIsVisisble()).isTrue();
        assertThat(loginPage.getLoginText().equals("Log in"));

    }

    @Step("Click <Run> button")
    public void clickOnButton(String buttonName) {
        // Given

        // When
        loginPage.clickOnButton(buttonName);

        // Then
        assertThat(loginPage.checkOutputText().equals("Hello World"));
    }

    @Step("Type your first name <firstName>")
    public void enterFirstName(String firstName) {
        // Given

        // When
        loginPage.enterFirstName(firstName);

        // Then
        assertThat(loginPage.getTextBoxText().equals(firstName));

        // Given
        // When
        loginPage.checkFirstNameStartsWith(firstName);

    }
}
