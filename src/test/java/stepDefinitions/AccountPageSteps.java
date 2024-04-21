package stepDefinitions;
import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import Pages.AccountPages;
import java.time.Duration;
public class AccountPageSteps {
    WebDriver driver;
    AccountPages accountDriver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        accountDriver = new AccountPages(driver);
    }
    @Given("I in Home")
    public void home(){
        accountDriver.clickOnApplication("rahul","rahul@2021");
    }
    @When("I click on account logo")
    public void loginIntoAccount(){
        accountDriver.avatarButton();

    }
    @Then("I look the elements")
    public void lookingElements(){
        accountDriver.lookEle();
    }
    @Then("click logout button")
    public void logoutButton(){
        accountDriver.logout();
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
