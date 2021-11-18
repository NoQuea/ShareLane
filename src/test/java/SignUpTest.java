import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpTest {

    WebDriver driver = null;

    @BeforeMethod
    public void enterBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
    }

    @Test
    public void validValues() {
        WebElement zipCodeFiveDigits = driver.findElement(By.xpath("//input[@name=\"zip_code\"]"));
        zipCodeFiveDigits.sendKeys("12345");
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

    }

    @Test
    public void withoutFirstName() {
        WebElement zipCodeFiveDigits = driver.findElement(By.xpath("//input[@name=\"zip_code\"]"));
        zipCodeFiveDigits.sendKeys("12345");
        WebElement clickOnTheButtonContinue = driver.findElement(By.xpath("//input[@value=\"Continue\"]"));
        clickOnTheButtonContinue.click();

        //Ввод валидных значений в поля со звездочками не заполняя поле first name
        WebElement email = driver.findElement(By.xpath("//input[@name=\"email\"]"));
        email.sendKeys("sdfonlasdbg@mail.ru");
        WebElement password1 = driver.findElement(By.xpath("//input[@name=\"password1\"]"));
        password1.sendKeys("111111");
        WebElement password2 = driver.findElement(By.xpath("//input[@name=\"password2\"]"));
        password2.sendKeys("111111");

        //Нажимаем на конпку Register
        WebElement clickOnbButtonRegister = driver.findElement(By.cssSelector("[value=Register]"));
        clickOnbButtonRegister.click();

        //Убеждаемся что нам выдало ошибку
        boolean isEnd = driver.findElement(By.xpath("//span[@class=\"error_message\"]")).isDisplayed();
        Assert.assertTrue(isEnd);

    }

    @Test
    public void xml() {
        WebElement zipCodeFiveDigits = driver.findElement(By.xpath("//input[@name=\"zip_code\"]"));
        zipCodeFiveDigits.sendKeys("12345");
        WebElement clickOnTheButtonContinue = driver.findElement(By.xpath("//input[@value=\"Continue\"]"));
        clickOnTheButtonContinue.click();

        //Ввод валидных значений в поля со звездочками заполняя поле first name XML запросом
        WebElement firstName = driver.findElement(By.xpath("//input[@name=\"first_name\"]"));
        firstName.sendKeys("<td><span class=\"user\"></span></td>");
        WebElement email = driver.findElement(By.xpath("//input[@name=\"email\"]"));
        email.sendKeys("sdfonlasdbg@mail.ru");
        WebElement password1 = driver.findElement(By.xpath("//input[@name=\"password1\"]"));
        password1.sendKeys("111111");
        WebElement password2 = driver.findElement(By.xpath("//input[@name=\"password2\"]"));
        password2.sendKeys("111111");

        //Нажимаем на конпку Register
        WebElement clickOnbButtonRegister = driver.findElement(By.cssSelector("[value=Register]"));
        clickOnbButtonRegister.click();

        //Убеждаемся что нам выдало ошибку
        boolean isEnd = driver.findElement(By.xpath("//span[@class=\"error_message\"]")).isDisplayed();
        Assert.assertTrue(isEnd);

    }

    @Test
    public void xmlCapsLk() {
        WebElement zipCodeFiveDigits = driver.findElement(By.xpath("//input[@name=\"zip_code\"]"));
        zipCodeFiveDigits.sendKeys("12345");
        WebElement clickOnTheButtonContinue = driver.findElement(By.xpath("//input[@value=\"Continue\"]"));
        clickOnTheButtonContinue.click();

        //Ввод валидных значений в поля со звездочками заполняя поле first name XML запросом
        WebElement firstName = driver.findElement(By.xpath("//input[@name=\"first_name\"]"));
        firstName.sendKeys("<TD><SPAN CLASS=\"USER\"></SPAN></TD>");
        WebElement email = driver.findElement(By.xpath("//input[@name=\"email\"]"));
        email.sendKeys("sdfonlasdbg@mail.ru");
        WebElement password1 = driver.findElement(By.xpath("//input[@name=\"password1\"]"));
        password1.sendKeys("111111");
        WebElement password2 = driver.findElement(By.xpath("//input[@name=\"password2\"]"));
        password2.sendKeys("111111");

        //Нажимаем на конпку Register
        WebElement clickOnbButtonRegister = driver.findElement(By.cssSelector("[value=Register]"));
        clickOnbButtonRegister.click();

        //Убеждаемся что нам выдало ошибку
        boolean isEnd = driver.findElement(By.xpath("//span[@class=\"error_message\"]")).isDisplayed();
        Assert.assertTrue(isEnd);

    }

    @Test
    public void confirmPassword() {
        WebElement zipCodeFiveDigits = driver.findElement(By.xpath("//input[@name=\"zip_code\"]"));
        zipCodeFiveDigits.sendKeys("12345");
        WebElement clickOnTheButtonContinue = driver.findElement(By.xpath("//input[@value=\"Continue\"]"));
        clickOnTheButtonContinue.click();

        //Ввод валидных значений в поля со звездочками заполняя поле Confirm Password отличное от Password
        WebElement firstName = driver.findElement(By.xpath("//input[@name=\"first_name\"]"));
        firstName.sendKeys("Pavel");
        WebElement email = driver.findElement(By.xpath("//input[@name=\"email\"]"));
        email.sendKeys("sdfonlasdbg@mail.ru");
        WebElement password1 = driver.findElement(By.xpath("//input[@name=\"password1\"]"));
        password1.sendKeys("111111");
        WebElement password2 = driver.findElement(By.xpath("//input[@name=\"password2\"]"));
        password2.sendKeys("222222");

        //Нажимаем на конпку Register
        WebElement clickOnbButtonRegister = driver.findElement(By.cssSelector("[value=Register]"));
        clickOnbButtonRegister.click();

        //Убеждаемся что нам выдало ошибку
        boolean isEnd = driver.findElement(By.xpath("//span[@class=\"error_message\"]")).isDisplayed();
        Assert.assertTrue(isEnd, "We have a bug");

    }
    @Test
    public void empty() {
        WebElement zipCodeFiveDigits = driver.findElement(By.xpath("//input[@name=\"zip_code\"]"));
        zipCodeFiveDigits.sendKeys("12345");
        WebElement clickOnTheButtonContinue = driver.findElement(By.xpath("//input[@value=\"Continue\"]"));
        clickOnTheButtonContinue.click();

        //Ввод валидных значений в поля со звездочками заполняя поле Confirm Password отличное от Password
        WebElement firstName = driver.findElement(By.xpath("//input[@name=\"first_name\"]"));
        firstName.sendKeys("");
        WebElement email = driver.findElement(By.xpath("//input[@name=\"email\"]"));
        email.sendKeys("");
        WebElement password1 = driver.findElement(By.xpath("//input[@name=\"password1\"]"));
        password1.sendKeys("");
        WebElement password2 = driver.findElement(By.xpath("//input[@name=\"password2\"]"));
        password2.sendKeys("");

        //Нажимаем на конпку Register
        WebElement clickOnbButtonRegister = driver.findElement(By.cssSelector("[value=Register]"));
        clickOnbButtonRegister.click();

        //Убеждаемся что нам выдало ошибку
        boolean isEnd = driver.findElement(By.xpath("//span[@class=\"error_message\"]")).isDisplayed();
        Assert.assertTrue(isEnd);

    }

    @AfterMethod
    public void quitBrowser() {
        driver.quit();
    }

}
