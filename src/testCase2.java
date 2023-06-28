import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
public class testCase2 {

    WebDriver driver;

    public void launchBrowser() {
        System.setProperty("webdriver.chrome.driver",
                "/Users/kohilnamdeo/Desktop/Phorest/chromedriver");
        driver = new ChromeDriver();

        driver.get("https://gift-cards.phorest.com/salons/demous#");


        //Find and select the radio button
        WebElement radioButton = driver.findElement(By.id("optionOther"));
        radioButton.click();

        WebElement OtherField = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[1]/div/ul/li[4]/div/input"));
        OtherField.sendKeys("200");


}
}
