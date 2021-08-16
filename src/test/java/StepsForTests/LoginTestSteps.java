package StepsForTests;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class LoginTestSteps {

    WebDriver driver = null;

    @Given("browser is open")
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @And("user is on login page")
    public void goToLoginPage() {
        driver.navigate().to("https://example.testproject.io/web/");
    }

    @When("^user enters (.*) and (.*)$")
    public void enterCredentials(String username, String pasword) throws InterruptedException {
        driver.findElement(By.id("name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(pasword);
        Thread.sleep(2000);
    }

    @And("clicks on login button")
    public void clicksOnLoginButton() {
        driver.findElement(By.id("login")).click();
    }

    @Then("user is navigated to the homepage")
    public void navigatedToHomePage() throws InterruptedException {
        driver.getPageSource().contains("Hello Yuvi Ramluggun, let's complete the test form:");
        driver.findElement(By.id("logout")).click();
        Thread.sleep(3000);
        driver.close();
        driver.quit();
    }

    @Then("error message is shown")
    public void errorMessageIsShown() throws InterruptedException {
        driver.getPageSource().contains("Password is invalid");
        Thread.sleep(3000);
        driver.close();
        driver.quit();
    }

}
