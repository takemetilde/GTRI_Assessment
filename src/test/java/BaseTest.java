import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseTest {

    private Logger log = LoggerFactory.getLogger(BaseTest.class);

    protected WebDriver testBaseDriver;
    final private String OSName = System.getProperty("os.name");

    @Before
    public void setup() {
        log.info("OSName: " + OSName);
        switch (OSName){
            case "Linux": System.setProperty("webdriver.chrome.driver",
                    System.getProperty("user.dir") + "/driver/chromedriver_linux64.exe");
                    log.info("Using chromedriver_linux64.exe");
                break;
            case "Windows": System.setProperty("webdriver.chrome.driver",
                    System.getProperty("user.dir") + "/driver/chromedriver_win32.exe");
                log.info("Using chromedriver_win32.exe");
                break;
            default: throw new IllegalStateException("There are no drivers compatible with OS: " + OSName);
        }
        log.info("Initializing Chrome Driver...");
        testBaseDriver = new ChromeDriver();
    }

    @After
    public void teardown() {
        log.info("Quitting Chrome Driver...");
        testBaseDriver.quit();
    }

    public void validateURL(String url) {
        log.info("Validating URL: " + url +  " == " + testBaseDriver.getCurrentUrl());
        Assert.assertTrue(url.equals(testBaseDriver.getCurrentUrl()));
    }
}