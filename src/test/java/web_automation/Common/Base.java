package web_automation.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web_automation.util.driver.Driver;

public abstract class Base {
    private WebDriver driver= Driver.driver;
    protected static String loginURLIHS = System.getenv("IHSMarkit");


   public Base() {
        PageFactory.initElements(driver,this);
    }
    protected void waitUntilElementIsClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    protected void waitUntilElementIsVisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    protected void inputText(WebElement element,String text){
        waitUntilElementIsClickable(element);
        element.sendKeys(text);
    }
    protected void clickElement(WebElement element) {
        waitUntilElementIsClickable(element);
        element.click();;
    }
    protected void clickLink(WebElement element) {
        waitUntilElementIsVisible(element);
        element.click();;
    }
    protected String getText(WebElement element){
        waitUntilElementIsVisible(element);
        return element.getText();
    }

    protected void clickElementByJavascriptExecutor(String xpath){
        WebElement element=driver.findElement(By.xpath(xpath));
        JavascriptExecutor ex=(JavascriptExecutor)driver;
        ex.executeScript("arguments[0].click()", element);
    }
    protected void freeze(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
