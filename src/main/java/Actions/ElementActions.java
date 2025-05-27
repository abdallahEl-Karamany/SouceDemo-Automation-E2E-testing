package Actions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class ElementActions {
   private WebDriver driver;

    public ElementActions() {
        this.driver = BrowserActions.getDriver();
    }


    public void PageNavigation(String URL, Locator expectedLocator,String expectedSelector, long duration) {
        driver.get(URL);
        elementValidation(ValidationType.PRESENT, expectedLocator,expectedSelector, duration);
    }

    public void PageNavigation(String URL) {
        driver.get(URL);
    }

    public boolean elementValidation(ValidationType condition,  Locator locator,String selector, long duration) {
        ExpectedCondition<WebElement> type = null;
        switch (condition) {
            case PRESENT:
                type = ExpectedConditions.presenceOfElementLocated(elementLocator(locator,selector));
                break;
            case CLICKABLE:
                type = ExpectedConditions.elementToBeClickable(elementLocator(locator,selector));
                break;
            case VISIBLE:
                type = ExpectedConditions.visibilityOfElementLocated(elementLocator(locator,selector));
                break;
        }
        try {
            new WebDriverWait(driver, Duration.ofMillis(duration)).until(type);
        } catch (Exception e) {
            try {
                new WebDriverWait(driver, Duration.ofMillis(duration)).until(type);
            }
            catch(Exception ex) {
                Assert.fail("element " + selector + "is not " + condition);}
            }
        return true;
    }
    public Boolean alertIsPresent(){
        try{
            Alert alert= new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.alertIsPresent());
            System.out.println("Alert detected with text: " + alert.getText());
            alert.accept();
            return true;
        }catch(TimeoutException e){
            return false;
        }

    }


    public void clickOnElement( Locator locator,String selector, Locator expectedLocator,String expectedSelector, long duration) {
        if (elementValidation(ValidationType.CLICKABLE, locator,selector, duration)) {
            getElement(locator,selector).click();
        }
        elementValidation(ValidationType.PRESENT, expectedLocator,expectedSelector, duration);
    }

    public void clickOnElement( Locator locator,String selector, long duration) {
        if (elementValidation(ValidationType.CLICKABLE, locator,selector, duration)) {
            getElement(locator,selector).click();
        }

    }

    public void sendKeyBoardKeys(SupportedKeys key,  Locator locator,String selector, Locator expectedLocator,String expectedSelector, long duration) {

        if (elementValidation(ValidationType.VISIBLE, locator,selector, duration)) {
            switch (key) {
                case ENTER:
                    getElement(locator,selector).sendKeys(Keys.ENTER);
                case TAB:
                    getElement(locator,selector).sendKeys(Keys.TAB);
                case SPACE:
                    getElement(locator,selector).sendKeys(Keys.SPACE);
                case ARROW_DOWN:
                    getElement(locator,selector).sendKeys(Keys.ARROW_DOWN);
                case ARROW_UP:
                    getElement(locator,selector).sendKeys(Keys.ARROW_UP);
                case ARROW_LEFT:
                    getElement(locator,selector).sendKeys(Keys.ARROW_LEFT);
                case ARROW_RIGHT:
                    getElement(locator,selector).sendKeys(Keys.ARROW_RIGHT);
                case ESCAPE:
                    getElement(locator,selector).sendKeys(Keys.ESCAPE);
                case PAGE_DOWN:
                    getElement(locator,selector).sendKeys(Keys.PAGE_DOWN);
                case PAGE_UP:
                    getElement(locator,selector).sendKeys(Keys.PAGE_UP);
            }
        }
            elementValidation(ValidationType.PRESENT, expectedLocator,expectedSelector, duration);
    }


    public void sendKeyBoardKeys(SupportedKeys key,  Locator locator,String selector, long duration) {

        if (elementValidation(ValidationType.VISIBLE, locator,selector, duration)) {
            switch (key) {
                case ENTER:
                    getElement(locator,selector).sendKeys(Keys.ENTER);
                case TAB:
                    getElement(locator,selector).sendKeys(Keys.TAB);
                case SPACE:
                    getElement(locator,selector).sendKeys(Keys.SPACE);
                case ARROW_DOWN:
                    getElement(locator,selector).sendKeys(Keys.ARROW_DOWN);
                case ARROW_UP:
                    getElement(locator,selector).sendKeys(Keys.ARROW_UP);
                case ARROW_LEFT:
                    getElement(locator,selector).sendKeys(Keys.ARROW_LEFT);
                case ARROW_RIGHT:
                    getElement(locator,selector).sendKeys(Keys.ARROW_RIGHT);
                case ESCAPE:
                    getElement(locator,selector).sendKeys(Keys.ESCAPE);
                case PAGE_DOWN:
                    getElement(locator,selector).sendKeys(Keys.PAGE_DOWN);
                case PAGE_UP:
                    getElement(locator,selector).sendKeys(Keys.PAGE_UP);
            }
        }
    }

    public void sendString(String Text, Locator locator,String selector, long duration) {
        if (elementValidation(ValidationType.VISIBLE, locator,selector, duration)) {
            getElement(locator,selector).sendKeys(Text);
        }
    }


    public WebElement getElement(Locator locator,String selector) {
        return driver.findElement(elementLocator(locator,selector));
    }

    public List<WebElement> getElements(Locator locator,String selector) {
        return driver.findElements(elementLocator(locator,selector));
    }

    public String getElementText(Locator locator,String selector,long duration) {
        elementValidation(ValidationType.VISIBLE, locator,selector, duration);
        return getElement(locator,selector).getText();
    }

    public List<String> getAllElementText(Locator locator,String selector) {
        List<WebElement> elementList = getElements(locator,selector);
        List<String> textList = new ArrayList<>();
        for (WebElement list : elementList) {
            textList.add(list.getText());
        }
        return textList;
    }
    public By elementLocator(Locator locator,String selector){
        switch(locator){
            case cssSelector:return new By.ByCssSelector(selector);
            case xPath:return new By.ByXPath(selector);
            case id:return new By.ById(selector);
            case className:return new By.ByClassName(selector);
            case tagName:return new By.ByTagName(selector);
            default:return null;
        }
    }
    public void clearText( Locator locator,String selector)
    {
        getElement(locator,selector).clear();
    }


    public enum Locator{
        cssSelector,
        xPath,
        id,
        tagName,
        className
    }
    public enum SupportedKeys {
        ENTER,
        TAB,
        SPACE,
        ESCAPE,
        ARROW_UP,
        ARROW_DOWN,
        ARROW_LEFT,
        ARROW_RIGHT,
        PAGE_DOWN,
        PAGE_UP;

    }

    public enum ValidationType {
        PRESENT,
        VISIBLE,
        CLICKABLE,

    }

}
