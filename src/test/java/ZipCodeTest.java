import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ZipCodeTest {

    @Test
    public void ZipCodeAccept5Digits(){
        // открытие страницы https://www.sharelane.com/cgi-bin/register.py
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        // ввести 5 цифр
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("12345");

        // Нажимаем кнопку Continue
        WebElement continueButton = driver.findElement(By.cssSelector("[value=Continue]"));
        continueButton.click();

        // Убедиться о том что мы на странице SignUp
        boolean isDisplay = driver.findElement(By.cssSelector("[value=Register]")).isDisplayed();
        Assert.assertTrue(isDisplay);
        // Закрыть браузер
        driver.quit();
    }

    @Test
    public void ZipCodeAccept6Digits(){
        // открытие страницы https://www.sharelane.com/cgi-bin/register.py
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        // ввести 5 цифр
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("123456");

        // Нажимаем кнопку Continue
        WebElement continueButton = driver.findElement(By.cssSelector("[value=Continue]"));
        continueButton.click();

        // Убедиться о том что нам отобразилось сообщение "Oops, error on page. ZIP code should have 5 digits"
        try {
            boolean isDisplay = driver.findElement(By.xpath("//span[@class=\"error_message\"]")).isDisplayed();
        } catch (Exception e) {
            Assert.assertTrue(false, "Bug");
        } finally {
            driver.quit();
        }
        // Закрыть браузер
        driver.quit();
    }

    @Test
    public void ZipCodeAccept4Digits(){
        // открытие страницы https://www.sharelane.com/cgi-bin/register.py
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        // ввести 5 цифр
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("1234");

        // Нажимаем кнопку Continue
        WebElement continueButton = driver.findElement(By.cssSelector("[value=Continue]"));
        continueButton.click();

        // Убедиться о том что нам вывело сообщение "Oops, error on page. ZIP code should have 5 digits"
        boolean isDisplay = driver.findElement(By.xpath("//span[@class=\"error_message\"]")).isDisplayed();
        Assert.assertTrue(isDisplay);

        // Закрыть браузер
        driver.quit();
    }

}
