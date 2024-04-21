package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PopularPages {
    WebDriver driver;
    WebDriverWait wait;

    By usernameLocator = By.id("usernameInput");
    By passwordLocator = By.id("passwordInput");
    By loginButtonLocator = By.className("login-button");
    By reloadLocator = By.xpath("//a[@class='nav-link']");
    By moviesListLocator = By.xpath("//div[@class='search-movies-container']/child::*");

    public PopularPages(WebDriver driver){
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
    public void clickOnApplication(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickOnLoginButton();
    }
    public void popularButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(reloadLocator));
        WebElement popularButton = driver.findElement(reloadLocator);
        popularButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(moviesListLocator));
        List<WebElement> moviesList = driver.findElements(moviesListLocator);
        for(int i = 0; i < moviesList.size(); i++){
            WebElement b = moviesList.get(i);
            Assert.assertTrue(b.isDisplayed(),"Not Displayed");
        }
        return;
    }
}
