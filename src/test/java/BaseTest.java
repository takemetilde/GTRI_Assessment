import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    protected WebDriver testBaseDriver;
    final private String OSName = System.getProperty("os.name");

    @Before
    public void setup() {
        switch (OSName){
            case "Linux": System.setProperty("webdriver.chrome.driver",
                    System.getProperty("user.dir") + "/driver/chromedriver_linux64.exe");
                break;
            case "Windows": System.setProperty("webdriver.chrome.driver",
                    System.getProperty("user.dir") + "/driver/chromedriver_win32.exe");
                break;
            default: throw new IllegalStateException("There are no drivers compatible with OS: " + OSName);
        }
        testBaseDriver = new ChromeDriver();
    }

    @After
    public void teardown() {
        testBaseDriver.quit();
    }

    public void validateURL(String url) {
        Assert.assertTrue(url.equals(testBaseDriver.getCurrentUrl()));
    }
}