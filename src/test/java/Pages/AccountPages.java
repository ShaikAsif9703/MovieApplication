package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
public class AccountPages {
    WebDriver driver;
    WebDriverWait wait;

    By usernameLocator = By.id("usernameInput");
    By passwordLocator = By.id("passwordInput");
    By loginButtonLocator = By.className("login-button");
    By accountButtonLocator = By.xpath("//button[@class='avatar-button']");
    By logoutButtonLocator = By.className("logout-button");
    By uiElementLocator = By.xpath("//h1[text()='Account']");
    By paraElements = By.tagName("p");
    public AccountPages(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
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
    public void clickOnApplication(String username,String password){
        enterUsername(username);
        enterPassword(password);
        clickOnLoginButton();
    }
    public void avatarButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountButtonLocator));
        WebElement avatar = driver.findElement(accountButtonLocator);
        avatar.click();
        return;
    }
    public void lookEle(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(uiElementLocator));
        List<WebElement> accountUiElements = driver.findElements(paraElements);
        //System.out.println(accountUiElements.size());
        for(int i = 0; i < accountUiElements.size(); i++){
            WebElement a = accountUiElements.get(i);
            Assert.assertTrue(a.isDisplayed(),"Not Displayed");
            //System.out.println(a.getText());
        }
        return;
    }
    public void logout(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButtonLocator));
        WebElement logoutButton = driver.findElement(logoutButtonLocator);
        logoutButton.click();
        String expectedUrl = "https://qamoviesapp.ccbp.tech/login";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,currentUrl,"URL's do not match");
        return;
    }
}
