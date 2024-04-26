package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
public class SearchPages {
    WebDriver driver;
    WebDriverWait wait;
    By usernameLocator = By.id("usernameInput");
    By passwordLocator = By.id("passwordInput");
    By loginButtonLocator = By.className("login-button");
    By homePageLocator = By.xpath("//a[@class='nav-link']");
    By searchLogoLocator = By.cssSelector("button[class='search-empty-button']");
    By inputLocator = By.id("search");
    By searchButtonLocator = By.className("search-button");
    By movieElements = By.xpath("//ul[@class='search-movies-container']/child::*");
    By noMoviesErrorMessageLocator = By.xpath("//p[@class='not-found-search-paragraph']");

    public SearchPages(WebDriver driver){
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
    public void clickOnApplication(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickOnLoginButton();
    }
    public void uiMovies(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageLocator));
        WebElement searchLogo = driver.findElement(searchLogoLocator);
        searchLogo.click();
        return;
    }
    public void enterName(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputLocator));
        WebElement search = driver.findElement(inputLocator);
        search.sendKeys("venom");
        WebElement searchButton = driver.findElement(searchButtonLocator);
        searchButton.click();
        return;
    }
    public void noOfElements(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(movieElements));
        List<WebElement> movies = driver.findElements(movieElements);
        // System.out.println(movies.size());
        for(int i = 0; i < movies.size(); i++){
            WebElement a = movies.get(i);
            Assert.assertTrue(a.isDisplayed(),"Not Displayed");
        }
        WebElement oneMovie = movies.get(0);
        oneMovie.click();
        System.out.println(driver.getCurrentUrl());
        String expectedUrl = "https://qamoviesapp.ccbp.tech/movies/51b4602f-b0f2-4c81-98e0-a2a409b13926";
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,currentUrl,"URL's do not match");
        return;
    }
    public void spiderman(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputLocator));
        WebElement search = driver.findElement(inputLocator);
        search.sendKeys("spiderman");
        WebElement searchButton = driver.findElement(searchButtonLocator);
        searchButton.click();
        return;
    }
    public void noMovies(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(noMoviesErrorMessageLocator));
        WebElement NotFoundMovieLocator = driver.findElement(noMoviesErrorMessageLocator);
        // System.out.println(NotFoundMovieLocator.getText());
        String expectedNotMovieFound = "Your search for spiderman did not find any matches.";
        String currentNotMovieFound = NotFoundMovieLocator.getText();
        Assert.assertEquals(expectedNotMovieFound,currentNotMovieFound,"Error doesn't match");
        return;
    }
}
