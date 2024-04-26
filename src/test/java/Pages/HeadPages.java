package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class HeadPages {
    WebDriver driver;
    WebDriverWait wait;

    By usernameLocator = By.id("usernameInput");
    By passwordLocator = By.id("passwordInput");
    By loginButtonLocator = By.className("login-button");
    By homewebsitelogo = By.className("website-logo");
    By navItemsLocator = By.xpath("//nav[@class='nav-header ']/child::div/ *");
    By homePageLocator = By.xpath("//a[@class='nav-link active-nav-link']");
    By popularPageLocator = By.xpath("//a[@class='nav-link']");
    By avatarButton = By.className("avatar-img");
    By searchLogoLocator = By.cssSelector("button[class='search-empty-button']");

    public HeadPages(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
    public void homeWebsiteLogo(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(homewebsitelogo));
        WebElement homeLogo = driver.findElement(homewebsitelogo);
        Assert.assertTrue(homeLogo.isDisplayed(),"Not Displayed");
        return;
    }
    public void navElements(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(homewebsitelogo));
        String total = "NotDisplayed";
        List<WebElement> navItems = driver.findElements(navItemsLocator);
        // System.out.println(navItems.size());
        for(int i = 0; i < navItems.size(); i++){
            WebElement a = navItems.get(i);
            Assert.assertTrue(a.isDisplayed(),"Not Displayed");
        }
        return;
    }
    public void homeElement(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(homewebsitelogo));
        WebElement homeNavElement = driver.findElement(homePageLocator);
        homeNavElement.click();
        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl,expectedUrl,"URL's do not match");
        return;
    }
    public void popularElement(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(homewebsitelogo));
        WebElement popularButton = driver.findElement(popularPageLocator);
        popularButton.click();
        String popularExpectedUrl = "https://qamoviesapp.ccbp.tech/popular";
        wait.until(ExpectedConditions.urlToBe(popularExpectedUrl));
        String currentPopularPage = driver.getCurrentUrl();
        Assert.assertEquals(popularExpectedUrl,currentPopularPage,"URL's do not match");
        return;
    }
    public void accountElement(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(avatarButton));
        WebElement accountImage = driver.findElement(avatarButton);
        accountImage.click();
        String expectedAccountUrl = "https://qamoviesapp.ccbp.tech/account";
        wait.until(ExpectedConditions.urlToBe(expectedAccountUrl));
        String currentAccountUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedAccountUrl,currentAccountUrl,"URl's do not match");
        return;
    }
    public void searchElement(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchLogoLocator));
        WebElement searchLogo = driver.findElement(searchLogoLocator);
        searchLogo.click();
        String expectedSearchPageUrl = "https://qamoviesapp.ccbp.tech/search";
        wait.until(ExpectedConditions.urlToBe(expectedSearchPageUrl));
        String currentSearchPageUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedSearchPageUrl,currentSearchPageUrl,"URL's do not match");
        return;
    }
}
