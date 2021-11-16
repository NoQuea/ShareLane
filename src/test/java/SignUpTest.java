import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest {

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

    @Test
    public void SignUpValid(){
        //открытие страницы https://www.sharelane.com/cgi-bin/register.py
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        //Ввод 5 цифр
        WebElement zipCodeFiveDigits = driver.findElement(By.xpath("//input[@name=\"zip_code\"]"));
        zipCodeFiveDigits.sendKeys("12345");

        //Нажимаем кнопку Continue
        WebElement clickOnTheButtonContinue = driver.findElement(By.xpath("//input[@value=\"Continue\"]"));
        clickOnTheButtonContinue.click();

        //Ввод валидных значений в поля со звездочками
        WebElement firstName = driver.findElement(By.xpath("//input[@name=\"first_name\"]"));
        firstName.sendKeys("Pavel");
        WebElement email = driver.findElement(By.xpath("//input[@name=\"email\"]"));
        email.sendKeys("sdfonlasdbg@mail.ru");
        WebElement password1 = driver.findElement(By.xpath("//input[@name=\"password1\"]"));
        password1.sendKeys("111111");
        WebElement password2 = driver.findElement(By.xpath("//input[@name=\"password2\"]"));
        password2.sendKeys("111111");

        //Нажимаем на конпку Register
        WebElement clickOnbButtonRegister = driver.findElement(By.cssSelector("[value=Register]"));
        clickOnbButtonRegister.click();

        //Убеждаемся что мы на странице окончания регистрации
        boolean isEnd = driver.findElement(By.xpath("//span[@class=\"confirmation_message\"]")).isDisplayed();
        Assert.assertTrue(isEnd);

        //Выход
        driver.quit();

    }

}
