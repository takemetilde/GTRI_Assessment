import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class BasePage {

    private Logger log = LoggerFactory.getLogger(BasePage.class);

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void visit(String url) {
        log.info("Navigating to url: " + url);
        driver.get(url);
    }

    public void click(By element) {
        log.info("Clicking on element: " + element);
        driver.findElement(element).click();
    }

    public void select(By element, String option) {
        log.info("Selecting element: " + element);
        Select select = new Select(driver.findElement(element));
        select.selectByVisibleText(option);
    }

    public void submit(By element) {
        log.info("Submitting with element: " + element);
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
        log.info("Collecting all elements with tag: " + element);
        return driver.findElements(element);
        }

    public List<String> getAttributeFromWebElements(List<WebElement> elementList, String option) {
        log.info("Extracting attribute \"" + option + "\" from element list.");
        List<String> stringList = new ArrayList<>();

        for (WebElement element: elementList) {
            log.info("Adding element attribute \"" + option + "\" to list: " + element.getAttribute(option));
            stringList.add(element.getAttribute(option));
        }
        return stringList;
    }
}