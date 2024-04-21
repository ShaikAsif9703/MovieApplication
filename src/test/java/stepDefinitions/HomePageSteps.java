package stepDefinitions;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.Before;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import Pages.HomePages;
import java.time.Duration;
import java.util.List;
public class HomePageSteps {
    WebDriver driver;
    HomePages homeDriver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        homeDriver = new HomePages(driver);
    }
    @Given("I am in Home page")
    public void homePage(){
        homeDriver.clickOnApplication("rahul","rahul@2021");
    }
    @Then("checking headings")
    public void headings(){
        homeDriver.headings();
    }
    @Then("play button is display")
    public void playButton(){
        homeDriver.playButton();
    }
    @Then("checking movies")
    public void movieCheck(){
        homeDriver.movie();
    }
    @Then("checking footer section")
    public void footerSection(){
        homeDriver.foot();
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
