import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GTOscarPage extends BasePage{

    private Logger log = LoggerFactory.getLogger(GTOscarPage.class);

    private final String BASE_PAGE_URL = "https://oscar.gatech.edu/";
    private final String SCED_OF_CLASSES_PAGE_URL = BASE_PAGE_URL + "pls/bprod/bwckschd.p_disp_dyn_sched";
    private final String CLASS_SCHED_SEARCH_PAGE_URL = BASE_PAGE_URL + "pls/bprod/bwckgens.p_proc_term_date";
    private final String CLASS_SCHED_LISTING_PAGE_URL = BASE_PAGE_URL + "pls/bprod/bwckschd.p_get_crse_unsec";

    private By scheduleOfClassesIcon = By.xpath("//a[@title='Georgia Tech schedule of classes']");
    private By selectByTermDropDown = By.name("p_term");
    private By submitButton = By.xpath("//input[@type='submit']");
    private By classTermSubjectDropdownItem = By.xpath("//option[@value='CS']");
    private By sectionHeadingsTest = By.xpath("//*[@class='ddtitle']/a");

    GTOscarPage(WebDriver driver) {
        super(driver);
    }

    public String getBASE_PAGE_URL() {
        return BASE_PAGE_URL;
    }

    public String getSCED_OF_CLASSES_PAGE_URL() {
        return SCED_OF_CLASSES_PAGE_URL;
    }

    public String getCLASS_SCHED_SEARCH_PAGE_URL() {
        return CLASS_SCHED_SEARCH_PAGE_URL;
    }

    public String getCLASS_SCHED_LISTING_PAGE_URL() {
        return CLASS_SCHED_LISTING_PAGE_URL;
    }

    public void navigateToHomePage() {
        visit(BASE_PAGE_URL);
    }

    public void clickSchedOfClassesIcon() {
        click(scheduleOfClassesIcon);
    }

    public void selectTermByDropdownAndSubmit() {
        select(selectByTermDropDown, "Spring 2019");
        submit(submitButton);
    }

    public void selectTermSubjectAndSubmit() {
        click(classTermSubjectDropdownItem);
        submit(submitButton);
    }

    public void checkHeadings() {
        List<String> headingsList = getAttributeFromWebElements(collectAllElementsByTag(sectionHeadingsTest), "text");

        //If time permitted, pojos could be made to more easily parse and validate
        for (String str: headingsList) {
            log.info("Validating headings for string: " + str + " --> contains \"CS\": " + str.contains("CS"));
            Assert.assertTrue(str.contains("CS"));
        }
    }

}