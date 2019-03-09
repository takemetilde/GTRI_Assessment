import org.junit.Before;
import org.junit.Test;

public class GTOscarPageTests extends BaseTest {

    private GTOscarPage gtOscarPage;

    @Before
    public void setUp(){
        gtOscarPage = new GTOscarPage(testBaseDriver);
    }

    @Test
    public void test() {
        gtOscarPage.navigateToHomePage();
        validateURL(gtOscarPage.getBASE_PAGE_URL());
        gtOscarPage.clickSchedOfClassesIcon();
        validateURL(gtOscarPage.getSCED_OF_CLASSES_PAGE_URL());
        gtOscarPage.selectTermByDropdownAndSubmit();
        validateURL(gtOscarPage.getCLASS_SCHED_SEARCH_PAGE_URL());
        gtOscarPage.selectTermSubjectAndSubmit();
        validateURL(gtOscarPage.getCLASS_SCHED_LISTING_PAGE_URL());
        gtOscarPage.checkHeadings();

    }
}
