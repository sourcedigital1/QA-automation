package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class BaseUtil {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static String AUTOMATE_USERNAME = "sourcedigital1";
    public static String AUTOMATE_ACCESS_KEY = "a1qh66UKN7Bd7U8Lyqxu";
    public static String url = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
    public static SoftAssert softAssert;
    public void waitAndClick(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public boolean verifyElementDisplayed(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }
}
