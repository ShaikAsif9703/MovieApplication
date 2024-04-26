package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
public class MovieDetailsPages {
    WebDriver driver;
    WebDriverWait wait;
    By usernameLocator = By.id("usernameInput");
    By passwordLocator = By.id("passwordInput");
    By loginButtonLocator = By.className("login-button");
    By homeWait = By.xpath("//a[@class='nav-link']");
    By homeButtonLocator = By.xpath("//a[text()='Home']");
    By oneMovieLocator = By.xpath("//img[contains(@src,'no-time-to-die')]");
    By homeUiElements = By.xpath("//ul[@class='similar-movies-list-container']/child::*");
    By popularButtonLocator = By.xpath("//a[text()='Popular']");
    By popularOneMovieLocator = By.xpath("//img[contains(@src,'venom')]");
    By uiElementsinHomeLocator = By.xpath("//div[@class='medium-screen-movie-container']/child::*");
    By popularUiElementsLocator = By.xpath("//ul[@class='similar-movies-list-container']/child::*");
    By uiElementsInPopularLocator = By.xpath("//div[@class='medium-screen-movie-container']/child::*");

    public MovieDetailsPages(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }
    public void enterUsername(String username){
        driver.findElement(usernameLocator).sendKeys(username);
    }
    public void enterPassword(String password){
        driver.findElement(passwordLocator).sendKeys(password);
    }
    public void loginButton(){
        driver.findElement(loginButtonLocator).click();
    }
    public void clickOnApplication(String username, String password){
        enterUsername(username);
        enterPassword(password);
        loginButton();
    }
    public void homeMovies(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeWait));
        WebElement homeButton = driver.findElement(homeButtonLocator);
        homeButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(oneMovieLocator));
        WebElement oneMovie = driver.findElement(oneMovieLocator);
        oneMovie.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeUiElements));
        List<WebElement> uiElements = driver.findElements(homeUiElements);
        System.out.println(uiElements.size());
        for(int i = 0; i < uiElements.size(); i++){
            WebElement a = uiElements.get(i);
            Assert.assertTrue(a.isDisplayed(),"Not Displayed");
        }
        List<WebElement> uiELementsinHome = driver.findElements(uiElementsinHomeLocator);
        for(int j = 0; j < uiELementsinHome.size(); j++){
            WebElement b = uiELementsinHome.get(j);
            Assert.assertTrue(b.isDisplayed(),"Not Displayed");
        }
        return;
    }
    public void popularMovies(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeWait));
        WebElement popularButton = driver.findElement(popularButtonLocator);
        popularButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(popularOneMovieLocator));
        WebElement popularOneMovie = driver.findElement(popularOneMovieLocator);
        popularOneMovie.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(popularUiElementsLocator));
        List<WebElement> popularUiElements = driver.findElements(popularUiElementsLocator);
        System.out.println(popularUiElements.size());
        for(int i = 0; i < popularUiElements.size(); i++){
            WebElement a = popularUiElements.get(i);
            Assert.assertTrue(a.isDisplayed(),"Not Displayed");
        }
        List<WebElement> uiElementsInPopular = driver.findElements(uiElementsInPopularLocator);
        System.out.println(uiElementsInPopular.size());
        for(int j = 0; j < uiElementsInPopular.size(); j++){
            WebElement c = uiElementsInPopular.get(j);
            Assert.assertTrue(c.isDisplayed(),"Not Displayed");
        }
        return;
    }
}
