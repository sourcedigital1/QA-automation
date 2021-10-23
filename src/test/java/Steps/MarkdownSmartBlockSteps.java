package Steps;

import Base.BaseUtil;
import Pages.Activation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.plugin.ColorAware;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class MarkdownSmartBlockSteps extends BaseUtil {

    Activation activation;

    public MarkdownSmartBlockSteps() {
        activation = new Activation(driver);
    }
    @And("I verify the block height is {string}")
    public void iVerifyTheBlockHeightIsHeight(String height) {
        WebElement element=driver.findElement(By.cssSelector(".sd-markdown-block.smart-block-list__item"));
        wait.until(ExpectedConditions.visibilityOf(element));
        String actHeight=element.getCssValue("height");
        softAssert.assertEquals(actHeight,height);
    }

    @And("I see Smart block text")
    public void iSeeSmartBlockText() {
        try {
            Thread.sleep(30000);
            WebElement element = driver.findElement(By.cssSelector(".sd-markdown-block.smart-block-list__item strong"));
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("I verify the text is {string}")
    public void iVerifyTheTextIs(String fontSize) {
        By by=By.cssSelector(".sd-markdown-block.smart-block-list__item strong");
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        }catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    @Then("I verify the text color is {string}")
    public void iVerifyTheTextColorIs(String color) {
        WebElement element=driver.findElement(By.cssSelector(".sd-markdown-block.smart-block-list__item strong span"));
        String actColor=element.getCssValue("color");
        actColor= Color.fromString(actColor).asHex();
        softAssert.assertEquals(actColor,color);
    }

    @Given("Execute {string} and play and click {string}")
    public void executeAndPlayAndClick(String activation, String timeLineText) throws InterruptedException {

        this.activation.visitActivation(activation);
        this.activation.clickMuteButton();
        this.activation.clickPlayButton();
        Thread.sleep(3000);
        WebElement slider=driver.findElement(By.cssSelector(".plyr__progress input"));
        Actions move = new Actions(driver);
        Action action = move.dragAndDropBy(slider, 100, 0).build();
        action.perform();
        action = move.dragAndDropBy(slider, -100, 0).build();
        action.perform();
        this.activation.ActivationIsShowing(timeLineText);
        this.activation.clickActivation(timeLineText);

    }
}
