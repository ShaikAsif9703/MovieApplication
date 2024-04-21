package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
public class HomePages {
    WebDriver driver;
    WebDriverWait wait;

    By usernameLocator = By.id("usernameInput");
    By passwordLocator = By.id("passwordInput");
    By loginButtonLocator = By.className("login-button");
    By headingsLocator = By.xpath("//h1[@class='movies-list-heading']");
    By visible = By.xpath("//div[@class='slick-list']/child::*/child::*");
    By movieCheckLocator = By.xpath("//div[@class='slick-list']/child::*/child::*");

    public HomePages(WebDriver driver){
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
    public void playButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("home-movie-play-button")));
        WebElement a = driver.findElement(By.className("home-movie-play-button"));
        Assert.assertTrue(a.isDisplayed());
        return;
    }
    public void foot(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='footer-icons-container']/child::*")));
        List<WebElement> icons = driver.findElements(By.xpath("//div[@class='footer-icons-container']/child::*"));
        for(int i = 0; i < icons.size(); i++){
            WebElement a = icons.get(i);
            Assert.assertTrue(a.isDisplayed());
        }
        return;
    }
    public void headings(){
        List<WebElement> headings = driver.findElements(headingsLocator);
        String[] expectedHeadings = {"Trending Now", "Originals"};
        for(int i = 0; i < headings.size(); i++){
            WebElement a = headings.get(i);
            String text = a.getText();
            String b = expectedHeadings[i];
            Assert.assertEquals(b,text,"donot match");
        }
        return;
    }
    public void movie(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(visible));
        List<WebElement> movies = driver.findElements(movieCheckLocator);
        for(int i = 0; i < movies.size(); i++){
            WebElement movie = movies.get(i);
            if(movie.isDisplayed()){
                continue;
            }else {
                break;
            }
        }
        return;
    }
}
