import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void visit(String url) {
        driver.get(url);
    }

    public void click(By element) {
        if (isDisplayed(element))
            driver.findElement(element).click();
    }

    public void type(By element, String inputText) {
        driver.findElement(element).sendKeys(inputText);
    }

    public void select(By element, String option) {
        Select select = new Select(driver.findElement(element));
        select.selectByVisibleText(option);
    }

    public void submit(By element) {
        driver.findElement(element).submit();
    }

    public Boolean isDisplayed(By element) {
        try {
            return driver.findElement(element).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException exception) {
            return false;
        }
    }

    public List<WebElement> collectAllElementsByTag(By element) {
        return driver.findElements(element);
        }

    public List<String> getAttributeFromWebElements(List<WebElement> elementList, String option) {
        List<String> stringList = new ArrayList<>();

        for (WebElement element: elementList)
            stringList.add(element.getAttribute(option));

        return stringList;
    }
//
//    public void waitFor(By locator, Integer seconds){
//        try {
//            WebDriverWait waitFor = new WebDriverWait(driver, seconds);
//            waitFor.until(ExpectedConditions.presenceOfElementLocated(locator));
//        } catch (TimeoutException exception) {
//        }
//    }
}