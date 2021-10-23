package Steps;

import Base.BaseUtil;
import Pages.Activation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.swing.*;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class CheckoutSteps extends BaseUtil {

    Activation activation;

    public CheckoutSteps() {
        activation = new Activation(driver);
    }

    @Given("Execute {string} and check and click {string}")
    public void executeAndCheckAndClick(String activation, String timeLineText) throws InterruptedException {

        this.activation.visitActivation(activation);
        this.activation.ActivationIsShowing(timeLineText);
        this.activation.clickActivation(timeLineText);
    }

    @And("I click Add to cart button")
    public void iClickAddToCartButton() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='add-to-cart']"))));
        driver.findElement(By.xpath("//div[@class='add-to-cart']")).click();
    }

    @And("I clicked View in cart button")
    public void iClickedViewInCartButton() {
        driver.findElement(By.xpath("//span[contains(text(),'View in cart')]")).click();
    }

    @And("I clicked Checkout button")
    public void iClickedCheckoutButton() {
        driver.findElement(By.cssSelector(".checkout-btn")).click();
    }

    @And("I clicked Proceed button")
    public void iClickedProceedButton() {
        driver.findElement(By.xpath("//div[@class='q-card__actions q-card__actions--horiz row justify-end']/button[2]")).click();
    }

    @Then("I should see billing page")
    public void iShouldSeeBillingPage() {
        String parentWindow=driver.getWindowHandle();
        Set<String> windowHandles=driver.getWindowHandles();
        Iterator<String> itr=windowHandles.iterator();
        while(itr.hasNext())
        {
            String windowHandle=itr.next();
            if(!windowHandle.equals(parentWindow))
                driver.switchTo().window(windowHandle);
        }
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("main-header"))));
        Assert.assertTrue(driver.findElement(By.id("main-header")).getText().contains("Contact information"));

    }

}
