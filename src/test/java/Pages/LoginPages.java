package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import java.time.Duration;

public class LoginPages {
    WebDriver driver;
    WebDriverWait wait;
    By usernameLocator = By.id("usernameInput");
    By passwordLocator = By.id("passwordInput");
    By loginButtonLocator = By.className("login-button");
    By websiteLogoLocator = By.className("login-website-logo");
    By errorMessageLocator = By.className("error-message");
    By mismatchLocator = By.className("error-message");
    By headingLocator = By.className("sign-in-heading");
    By usernameLabel = By.xpath("//label[text()='USERNAME']");
    By passwordLabel = By.xpath("//label[text()='PASSWORD']");


    public LoginPages(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterUsername(String username){
        driver.findElement(usernameLocator).sendKeys(username);
    }
    public void enterPassword(String password){
        driver.findElement(passwordLocator).sendKeys(password);
    }
    public void clickOnLoginButton(){
        driver.findElement(loginButtonLocator).click();
    }
    public void loginIntoApplication(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickOnLoginButton();
    }
    public void WebsiteLogo(){

        WebElement logo = driver.findElement(websiteLogoLocator);
        Assert.assertTrue(logo.isDisplayed());
        return;
    }
    public void errorMessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
        WebElement errorMessage = driver.findElement(errorMessageLocator);
        String text = errorMessage.getText();
        Assert.assertEquals(text,"*Username or password is invalid","Error Message donot match");
        return;
    }
    public void mismatch(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(mismatchLocator));
        WebElement misMatchError = driver.findElement(mismatchLocator);
        String misMatchText = misMatchError.getText();
        Assert.assertEquals(misMatchText,"*username and password didn't match");
        return;
    }
    public void checkHeading(){
        WebElement heading = driver.findElement(headingLocator);
        String expectedHeading = heading.getText();
        Assert.assertEquals(expectedHeading,"Login","Login's doesn't match");
        return;
    }
    public void user(){
        WebElement username = driver.findElement(usernameLabel);
        String expectedUsernameLabel = username.getText();
        Assert.assertEquals(expectedUsernameLabel,"USERNAME","Username label doesn't match");
        return;
    }
    public void password(){
        WebElement password = driver.findElement(passwordLabel);
        String expectedPasswordLabel = password.getText();
        Assert.assertEquals(expectedPasswordLabel,"PASSWORD","Password label doesn't match");
        return;
    }
    public void home(){
        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl,expectedUrl,"Url's do not match");
        return;
    }

}
