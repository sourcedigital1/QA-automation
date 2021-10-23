package Pages;

import Base.BaseUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Activation extends BaseUtil {

   private final String timeLineText = "Color Tattoo Cream Eyeshadow Pot";

    @FindBy(how=How.XPATH,using="//button[@data-plyr='mute']")
    private WebElement muteButton;

    @FindBy(how=How.XPATH,using="//button[@data-plyr='play']")
    private WebElement playButton;

    public Activation(WebDriver driver) {
        BaseUtil.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void visitActivation(String dist){
        String url = "https://experience-stg.sourcesync.io/";
        url = url + dist;
        driver.get(url);
    }

    public boolean ActivationIsShowing(String timeLineText) throws InterruptedException {
        WebElement target=driver.findElement(By.xpath("//div[@class='plyr__poster']"));
        Actions builder = new Actions(driver);
        builder.moveToElement(target,10,10).build().perform();
        //driver.findElement(By.xpath("//div[@class='q-pa-md cursor-pointer text-center absolute-center']")).click();
        try {
            Dimension screenSize = driver.manage().window().getSize();
            if (screenSize.getHeight() > screenSize.getWidth()) {
                WebElement elem1 = driver.findElement(By.xpath(String.format("//div[contains(text(), '%s')]", timeLineText)));
                return verifyElementDisplayed(elem1);
            } else {
                WebElement elem2 = driver.findElement(By.xpath(String.format("//p[contains(text(), '%s')]", timeLineText)));
                return verifyElementDisplayed(elem2);
            }
        } catch (Exception e) {
            Thread.sleep(10000);
            return verifyElementDisplayed(driver.findElement(By.xpath(String.format("//div[contains(text(), '%s')]", timeLineText))));
        }
    }

    public void clickActivation(String timeLineText) {
        try {
            Dimension screenSize = driver.manage().window().getSize();
            if (screenSize.getHeight() > screenSize.getWidth()) {
                driver.findElement(By.xpath(String.format("//div[contains(text(), '%s')]", timeLineText))).click();
            } else {
                driver.findElement(By.xpath(String.format("//p[contains(text(), '%s')]", timeLineText))).click();
            }
        } catch (Exception e) {
            driver.findElement(By.xpath(String.format("//div[contains(text(), '%s')]", timeLineText))).click();
        }
    }


    public void clickFullScreen() {
        driver.findElement(By.xpath("//*[@id=\"ep\"]/div[1]/div/div[2]/div[2]/div/div[1]/button[3]")).click();
    }

    public  void clickUnmuteButton() {
        driver.findElement(By.xpath("//*[@id=\"ep\"]/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/button")).click();
    }
    public  void clickMuteButton() {
        muteButton.click();
    }
    public  void clickPlayButton() {
        playButton.click();
    }
}
