package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageSteps {
    WebDriver driver;
    @Given("User opened chrome browser")
    public void userOpenedChromeBrowser() {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir + "/driver/chromedriver");
        driver = new ChromeDriver();
    }
    @When("User opened amazon website")
    public void userOpenedAmazonWebsite() throws InterruptedException {
        driver.get("https://www.amazon.com");
        Thread.sleep(1000);
    }

    @And("User wants to search product item")
    public void userWantToSearchProductItem() {
        driver.findElement(By.id("twotabsearchtextbox")).click();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("keyboard");
        driver.findElement(By.id("nav-search-submit-button")).click();
    }

    @And("User wants to checkout product item")
    public void userWantsToCheckoutProductItem() {
        new WebDriverWait(driver, Duration.ofSeconds(2));
        driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/div/div/div/div/div/div[2]/div/div/div[1]/h2/a")).click();
        driver.findElement(By.id("buy-now-button")).click();
    }

    @Then("User registered to amazon website")
    public void userRegisteredToAmazonWebsite() {
        driver.findElement(By.id("createAccountSubmit")).click();
        driver.findElement(By.id("ap_customer_name")).sendKeys("Account Tester");
        driver.findElement(By.id("ap_email")).sendKeys("testerintegration+738829@mailinator.com");
        driver.findElement(By.id("ap_password")).sendKeys("tester123");
        driver.findElement(By.id("ap_password_check")).sendKeys("tester123");
        driver.findElement(By.id("continue")).click();

        driver.close();
        driver.quit();
    }
}
