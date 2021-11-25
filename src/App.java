import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.junit.Assert;

// Built with vs code

public class App {
    private static final String WEBDRIVER_NAME = "webdriver.chrome.driver";
    private static final String WEBDRIVER_PATH = "lib/chromedriver.exe";
    private static final String BASE_URL = "https://www.phptravels.net";
    private static final String URL = "/login";
    private static final String EMAIL_ELEMENT_NAME = "email";
    private static final String PASSWORD_ELEMENT_NAME = "password";
    private static final String COOKIE_STOP_ELEMENT_NAME = "cookie_stop";
    private static final String LOGIN_BUTTON_XPATH = "/html/body/div[1]/div/div[2]/div[2]/div/form/div[3]/button";
    private static final String LOGIN = "user@phptravels.com";
    private static final String PASSWORD = "demouser";
    private static final String EXPECTED_URL = "/account/dashboard";

    public static void main(String[] args) throws Exception {
        System.setProperty(WEBDRIVER_NAME, WEBDRIVER_PATH);

        var driver = new ChromeDriver();
        driver.manage().window().maximize();
        var url = BASE_URL + URL;
        driver.get(url);

        var username = driver.findElement(By.name(EMAIL_ELEMENT_NAME));
        var password = driver.findElement(By.name(PASSWORD_ELEMENT_NAME));
        var cookieStop = driver.findElement(By.id(COOKIE_STOP_ELEMENT_NAME));
        var login = driver.findElement(By.xpath(LOGIN_BUTTON_XPATH));
        
        username.sendKeys(LOGIN);
        password.sendKeys(PASSWORD);
        cookieStop.click();
        login.click();

        String actualUrl = BASE_URL + EXPECTED_URL;
        String expectedUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);

        driver.quit();
    }
}
