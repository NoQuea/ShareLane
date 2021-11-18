import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpTest {

    WebDriver driver;

    @BeforeMethod
    public void enterBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
    }

    @Test
    public void validValues() {
        driver.findElement(By.xpath("//input[@name=\"zip_code\"]"))
                .sendKeys("12345");
        WebElement clickOnTheButtonContinue = driver.findElement(By.xpath("//input[@value=\"Continue\"]"));
        clickOnTheButtonContinue.click();

        //Ввод валидных значений в поля со звездочками
        driver.findElement(By.xpath("//input[@name=\"first_name\"]"))
                .sendKeys("Pavel");
        driver.findElement(By.xpath("//input[@name=\"email\"]"))
                .sendKeys("sdfonlasdbg@mail.ru");
        driver.findElement(By.xpath("//input[@name=\"password1\"]"))
                .sendKeys("111111");
        driver.findElement(By.xpath("//input[@name=\"password2\"]"))
                .sendKeys("111111");

        //Нажимаем на конпку Register
        driver.findElement(By.cssSelector("[value=Register]"))
                .click();

        //Убеждаемся что мы на странице окончания регистрации
        boolean isEnd = driver.findElement(By.xpath("//span[@class=\"confirmation_message\"]"))
                .isDisplayed();
        Assert.assertTrue(isEnd);

    }

    @Test
    public void withoutFirstName() {
        driver.findElement(By.xpath("//input[@name=\"zip_code\"]"))
                .sendKeys("12345");
        driver.findElement(By.xpath("//input[@value=\"Continue\"]"))
                .click();

        //Ввод валидных значений в поля со звездочками не заполняя поле first name
        driver.findElement(By.xpath("//input[@name=\"email\"]"))
                .sendKeys("sdfonlasdbg@mail.ru");
        driver.findElement(By.xpath("//input[@name=\"password1\"]"))
                .sendKeys("111111");
        driver.findElement(By.xpath("//input[@name=\"password2\"]"))
                .sendKeys("111111");

        //Нажимаем на конпку Register
        driver.findElement(By.cssSelector("[value=Register]"))
                .click();

        //Убеждаемся что нам выдало ошибку
        boolean isEnd = driver.findElement(By.xpath("//span[@class=\"error_message\"]"))
                .isDisplayed();
        Assert.assertTrue(isEnd);

    }

    @Test
    public void fillXmlTagInFirstNameFieldShouldDisplayErrorMessage() {
        driver.findElement(By.xpath("//input[@name=\"zip_code\"]"))
                .sendKeys("12345");
        driver.findElement(By.xpath("//input[@value=\"Continue\"]"))
                .click();

        //Ввод валидных значений в поля со звездочками заполняя поле first name XML запросом
        driver.findElement(By.xpath("//input[@name=\"first_name\"]"))
                .sendKeys("<td><span class=\"user\"></span></td>");
        driver.findElement(By.xpath("//input[@name=\"email\"]"))
                .sendKeys("sdfonlasdbg@mail.ru");
        driver.findElement(By.xpath("//input[@name=\"password1\"]"))
                .sendKeys("111111");
        driver.findElement(By.xpath("//input[@name=\"password2\"]"))
                .sendKeys("111111");

        //Нажимаем на конпку Register
        driver.findElement(By.cssSelector("[value=Register]"))
                .click();

        //Убеждаемся что нам выдало ошибку
        boolean isEnd = driver.findElement(By.xpath("//span[@class=\"error_message\"]"))
                .isDisplayed();
        Assert.assertTrue(isEnd);

    }

    @Test
    public void xmlCapsLk() {
        driver.findElement(By.xpath("//input[@name=\"zip_code\"]"))
                .sendKeys("12345");
        driver.findElement(By.xpath("//input[@value=\"Continue\"]"))
                .click();

        //Ввод валидных значений в поля со звездочками заполняя поле first name XML запросом
        driver.findElement(By.xpath("//input[@name=\"first_name\"]"))
                .sendKeys("<TD><SPAN CLASS=\"USER\"></SPAN></TD>");
        driver.findElement(By.xpath("//input[@name=\"email\"]"))
                .sendKeys("sdfonlasdbg@mail.ru");
        driver.findElement(By.xpath("//input[@name=\"password1\"]"))
                .sendKeys("111111");
        driver.findElement(By.xpath("//input[@name=\"password2\"]"))
                .sendKeys("111111");

        //Нажимаем на конпку Register
        driver.findElement(By.cssSelector("[value=Register]"))
                .click();

        //Убеждаемся что нам выдало ошибку
        boolean isEnd = driver.findElement(By.xpath("//span[@class=\"error_message\"]"))
                .isDisplayed();
        Assert.assertTrue(isEnd);

    }

    @Test
    public void confirmPassword() {
        driver.findElement(By.xpath("//input[@name=\"zip_code\"]"))
                .sendKeys("12345");
        driver.findElement(By.xpath("//input[@value=\"Continue\"]"))
                .click();

        //Ввод валидных значений в поля со звездочками заполняя поле Confirm Password отличное от Password
        driver.findElement(By.xpath("//input[@name=\"first_name\"]"))
                .sendKeys("Pavel");
        driver.findElement(By.xpath("//input[@name=\"email\"]"))
                .sendKeys("sdfonlasdbg@mail.ru");
        driver.findElement(By.xpath("//input[@name=\"password1\"]"))
                .sendKeys("111111");
        driver.findElement(By.xpath("//input[@name=\"password2\"]"))
                .sendKeys("222222");

        //Нажимаем на конпку Register
        driver.findElement(By.cssSelector("[value=Register]"))
                .click();

        //Убеждаемся что нам выдало ошибку
        boolean isEnd = driver.findElement(By.xpath("//span[@class=\"error_message\"]"))
                .isDisplayed();
        Assert.assertTrue(isEnd, "We have a bug");

    }
    @Test
    public void empty() {
        driver.findElement(By.xpath("//input[@name=\"zip_code\"]"))
                .sendKeys("12345");
        driver.findElement(By.xpath("//input[@value=\"Continue\"]"))
                .click();

        //Ввод валидных значений в поля со звездочками заполняя поле Confirm Password отличное от Password
        driver.findElement(By.xpath("//input[@name=\"first_name\"]"))
                .sendKeys("");
        driver.findElement(By.xpath("//input[@name=\"email\"]"))
                .sendKeys("");
        driver.findElement(By.xpath("//input[@name=\"password1\"]"))
                .sendKeys("");
        driver.findElement(By.xpath("//input[@name=\"password2\"]"))
                .sendKeys("");

        //Нажимаем на конпку Register
        driver.findElement(By.cssSelector("[value=Register]"))
                .click();

        //Убеждаемся что нам выдало ошибку
        boolean isEnd = driver.findElement(By.xpath("//span[@class=\"error_message\"]"))
                .isDisplayed();
        Assert.assertTrue(isEnd);

    }

    @AfterMethod
    public void quitBrowser() {
        driver.quit();
    }

}
