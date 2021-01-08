package web_automation.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import web_automation.Common.Base;
import web_automation.util.driver.Driver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class IHSLoginPage extends Base {
    private WebDriver driver = Driver.driver;
    private static String loginPageURLIHS= loginURLIHS;

    @FindBy(id="login-button")
    WebElement BTN_LOGIN;
    @FindBy(id="run-button")
    WebElement BTN_RUN;
    @FindBy(xpath = "//div[@id='output']")
    WebElement TEXT_OUTPUT;
    @FindBy(xpath="//input[@type='text' and @placeholder='Enter name here...']")
    WebElement TEXT_ENTERNAME;
    @FindBy(xpath = "//input[@class='new-package form-control input-sm' and @placeholder='Package name...']")
    WebElement TEXT_PACKAGENAME;
    @FindBy(xpath = "//a[@package-id='NUnit' and @id='ui-id-1']")
    WebElement MENU_NUNIT;
    @FindBy(xpath="//a[@package-id='NUnit' and @version-name='3.12.0.0']")
    WebElement VERSION;
    @FindBy(xpath = "//div[@class='package-name']")
    WebElement TEXT_ADDEDPACKAGENAME;
    @FindBy(xpath = "//button[@id='Share']")
    WebElement BTN_SHARE;
    @FindBy(xpath = "//input[@id='ShareLink']")
    WebElement SHARE_LINK;
    @FindBy(xpath = "//button[@class='btn btn-default btn-xs btn-sidebar-toggle' and @type='button']")
    WebElement BTN_OPTION;
    @FindBy(xpath = "//div[@class='sidebar unselectable']")
    WebElement SIDEBAR;
    @FindBy(id = "save-button")
    WebElement BTN_SAVE;
    @FindBy(xpath = "//a[@class='btn btn-default' and @href='/GettingStarted/']")
    WebElement BTN_GEETING_STARTED;
    @FindBy(xpath="//*[@class='modal-title' and @id='login-modal-label']")
    WebElement TEXT_LOGIN;
    @FindBy(xpath = "//span[@class='glyphicon glyphicon-chevron-left']")
    WebElement BTN_BACK_EDITOR;

    public IHSLoginPage(){
        PageFactory.initElements(driver,this);
    }

    public void navigateToLoginIHS(){
        driver.get(loginPageURLIHS);
    }

    public String getLoginText(){
       return getText(BTN_LOGIN);
    }


    public boolean checkLoginButtonIsVisisble() {
        return BTN_LOGIN.isDisplayed();
    }

    public void clickOnButton(String buttonName) {
        clickElement(BTN_RUN);
    }

    public String checkOutputText() {
        return getText(TEXT_OUTPUT);
    }

    public void enterFirstName(String firstName) {
        inputText(TEXT_ENTERNAME,firstName);
    }

    public String getTextBoxText() {
        return getText(TEXT_ENTERNAME);
    }

    public void checkFirstNameStartsWith(String firstName)  {
        Pattern pattern = Pattern.compile("^[A-E].*");
        Matcher matcher = pattern.matcher(firstName);
        if(matcher.matches()){
            assertThat(selectPackageName().equals("NUnit"));
            System.out.println("NUnit package added successfully");
        }
         pattern = Pattern.compile("^[F-k].*");
         matcher = pattern.matcher(firstName);
        if(matcher.matches()){
            clickElement(BTN_SHARE);
            String expectedLink="https://dotnetfiddle.net/.*";
            Pattern.compile(expectedLink);
            pattern.matcher(checkLinkStartsWith());
            assertThat(matcher.matches()).isTrue();
        }
        pattern = Pattern.compile("^[L-P].*");
        matcher = pattern.matcher(firstName);
        if(matcher.matches()){
            String valueBeforeClick = SIDEBAR.getAttribute("style");
            clickElement(BTN_OPTION);
            String valueAfterClick =SIDEBAR.getAttribute("style");
            assertThat(valueBeforeClick).isNotEqualTo(valueAfterClick);
        }
        pattern = Pattern.compile("^[Q-U].*");
        matcher = pattern.matcher(firstName);
        if(matcher.matches()){
            clickElement(BTN_SAVE);
            driver.switchTo().activeElement();
            assertThat( getText(TEXT_LOGIN)).isEqualTo("Log in");
        }
        pattern = Pattern.compile("^[V-Z].*");
        matcher = pattern.matcher(firstName);
        if(matcher.matches()){
            clickElement(BTN_GEETING_STARTED);

            assertThat(BTN_BACK_EDITOR.isDisplayed()).isTrue();
        }


    }
    public String selectPackageName(){
        inputText(TEXT_PACKAGENAME,"NUnit");
        clickElement(MENU_NUNIT);
        clickElement(VERSION);
       return getText(TEXT_ADDEDPACKAGENAME);
    }
    public String checkLinkStartsWith(){
        return getText(SHARE_LINK);
    }

}
