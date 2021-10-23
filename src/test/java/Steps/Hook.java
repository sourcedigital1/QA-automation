package Steps;

import Base.BaseUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class Hook extends BaseUtil {

    @Before
    public void setUp() throws MalformedURLException {

        softAssert=new SoftAssert();
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1920x1080");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("os", "Windows");
        caps.setCapability("name", "BStack-[Java] Sample Test"); // test name
        caps.setCapability("build", "BStack Build Number 1"); // CI/CD job or build name
        //driver = new RemoteWebDriver(new URL(url), caps);
        System.setProperty("webdriver.chrome.driver","src//test//resources//driver//chromedriver.exe");
        driver=new ChromeDriver(new ChromeOptions().merge(caps));;
        wait = new WebDriverWait(driver, 30);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(){
        driver.quit();
        softAssert.assertAll();
    }
}
