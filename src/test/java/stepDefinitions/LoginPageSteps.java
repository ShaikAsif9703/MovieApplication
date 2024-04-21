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
import Pages.LoginPages;
import java.time.Duration;
public class LoginPageSteps {
    WebDriver driver;
    LoginPages loginPage;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPages(driver);
    }
    @Given("I am on the movie login page")
    public void moviePage(){
        driver.get("https://qamoviesapp.ccbp.tech");

    }
    @When("I click on the login button")
    public void clickOnLoginButton(){
        loginPage.clickOnLoginButton();
    }
    @When("I entered the password input")
    public void passwordField(){
        loginPage.enterPassword("rahul@2021");
    }
    @When("I entered the username input")
    public void enterusername(){
        loginPage.enterUsername("rahul");
    }
    @When("I entered the username and password input")
    public void invalidCredentials(){
        loginPage.enterUsername("rahul");
        loginPage.enterPassword("rahul2021");
    }
    @When("I entered the inputs")
    public void validCredentials(){
        loginPage.enterUsername("rahul");
        loginPage.enterPassword("rahul@2021");
    }
    @And("I click on  login button")
    public void clickOnTheLoginButton(){
        loginPage.clickOnLoginButton();
    }
    @Then("I want to check app logo")
    public void websiteLogo(){
        loginPage.WebsiteLogo();
    }
    @Then("I check the movie page heading")
    public void checkingHeadingText(){
        loginPage.checkHeading();
    }
    @Then("I check the username label")
    public void checkingUsernameLabel(){
        loginPage.user();
    }
    @Then("I check the password label")
    public void checkingPasswordLabel(){
        loginPage.password();
    }
    @Then("Error message will be displayed")
    public void errorMessage(){
        loginPage.errorMessage();
    }
    @Then("Error Message")
    public void errormessage(){
        loginPage.mismatch();
    }
    @Then("return to home page")
    public void homePage(){
        loginPage.home();
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
