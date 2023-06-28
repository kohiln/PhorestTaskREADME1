import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;
import java.time.Instant;

public class Main {

    WebDriver driver;
    WebElement confirmButton;
    WebElement iFrameElement;

    public void launchBrowser() {
        System.setProperty("webdriver.chrome.driver",
                "/Users/kohilnamdeo/Desktop/Phorest/chromedriver");
        driver = new ChromeDriver();

        driver.get("https://gift-cards.phorest.com/salons/demous#");

        //Testcase1: Verify that user can purchase a 50$ gift card for themself

        //Find and select the radio button
        WebElement radioButton = driver.findElement(By.id("option50"));
        radioButton.click();

        //Enter data in the email address feild
        WebElement emailField = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div/div/input"));
        emailField.sendKeys("jane@mail.com");

        // Enter data in the first name field
        WebElement firstNameField = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div/div/div[2]/div/div[1]/input"));
        firstNameField.sendKeys("Jane");

        // Enter data in the last name field
        WebElement lastNameField = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div/div/div[2]/div/div[2]/input"));
        lastNameField.sendKeys("Smith");

        //To select the checkout button
        WebElement checkoutButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[1]/div[2]/div[2]/button"));
        checkoutButton.click();

        //To confirm user details

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement confirmButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/button")));


        // Perform your validation or further actions with the confirm button
        if (confirmButton.isDisplayed()) {
            System.out.println("Confirm button is present on the next page.");
            //Click the confirm button
            confirmButton.click();

            try {
                Thread.sleep(5000); // Adjust the sleep duration as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //To go to the iframe so that user can input the payment details

            WebElement iframeElement = driver.findElement(By.tagName("iframe"));
            driver.switchTo().frame(iframeElement);


            // Input payment details

            WebElement cardholderNameField = driver.findElement(By.id("card-name"));
            cardholderNameField.sendKeys("Jane Smith");

            // Enter zipcode
            WebElement zipCodeField = driver.findElement(By.id("card-zip"));
            zipCodeField.sendKeys("92606");

            //Enter card number
            WebElement cardNumberField = driver.findElement(By.id("card-number"));
            cardNumberField.sendKeys("4111 1111 1111 1111");


            //Enter card expiration date
            WebElement expirationField = driver.findElement(By.id("card-expiry"));
            expirationField.sendKeys("12/23");

            //Enter CVC of the card
            WebElement cvcField = driver.findElement(By.id("card-security"));
            cvcField.sendKeys("999");

            WebElement submitButton = driver.findElement(By.id("submitButton"));
            submitButton.click();


        } else {
            System.out.println("Confirm button is not present on the next page.");
        }
    }




    public static void main(String[] args) {

        Main obj = new Main();
        obj.launchBrowser();
        obj.TestCase2();
        obj.TestCase3();
        obj.TestCase4();
        obj.TestCase5();



}


//Testcase 2: Verify that user can select 'other' option and input the amount to purchase a gift card


    public void TestCase2() {

        System.setProperty("webdriver.chrome.driver",
                "/Users/kohilnamdeo/Desktop/Phorest/chromedriver");
        driver = new ChromeDriver();

        driver.get("https://gift-cards.phorest.com/salons/demous#");

        //Open link in a new tab

        WebElement radioButton = driver.findElement(By.id("optionOther"));
        radioButton.click();

        WebElement otherAmountField = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[1]/div/ul/li[4]/div/input"));
        otherAmountField.sendKeys("200");
    }


//Testcase 3: Verify that user can purchase a gift card for the amount of their choice

    public void TestCase3() {

            System.setProperty("webdriver.chrome.driver",
                    "/Users/kohilnamdeo/Desktop/Phorest/chromedriver");
            driver = new ChromeDriver();

            driver.get("https://gift-cards.phorest.com/salons/demous#");

            //Open link in a new tab

            WebElement radioButton = driver.findElement(By.id("optionOther"));
            radioButton.click();

            WebElement otherAmountField = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[1]/div/ul/li[4]/div/input"));
            otherAmountField.sendKeys("200");

            WebElement SendToSomeoneElse = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div/nav/a[2]\n"));
            SendToSomeoneElse.click();

            //Enter data in the email address feild
            WebElement emailField = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div/div/input"));
            emailField.sendKeys("oliver@gmail.com");

            // Enter data in the first name field
            WebElement firstNameField = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div/div/div[2]/div/div[1]/input"));
            firstNameField.sendKeys("Abby");

            // Enter data in the last name field
            WebElement lastNameField = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div/div/div[2]/div/div[2]/input"));
            lastNameField.sendKeys("Rose");

            //Enter recipient email address
            WebElement recipientEmailInput = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div/div/div[4]/input"));
            recipientEmailInput.sendKeys(("abby.rose@gmail.com"));


            //To input a message to recipient
            WebElement recipientMessageInput = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div/div/div[4]/textarea"));
            recipientMessageInput.sendKeys("Gift for your special day");

            //To click on checkout button
        WebElement checkoutButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[1]/div[2]/div[2]/button"));
        checkoutButton.click();

        //To click on 'Confirm Details' button

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement confirmButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/button")));
        confirmButton.click();

        if (confirmButton.isDisplayed()) {
            System.out.println("Confirm button is present on the next page.");
            //Click the confirm button
            confirmButton.click();

            try {
                Thread.sleep(10000); // Adjust the sleep duration as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //To go to the iframe so that user can input the payment details

            WebElement iframeElement1 = driver.findElement(By.tagName("iframe"));
            driver.switchTo().frame(iframeElement1);


            // Input payment details

            WebElement cardholderNameField = driver.findElement(By.id("card-name"));
            cardholderNameField.sendKeys("Abby Rose");

            // Enter zipcode
            WebElement zipCodeField = driver.findElement(By.id("card-zip"));
            zipCodeField.sendKeys("92606");

            //Enter card number
            WebElement cardNumberField = driver.findElement(By.id("card-number"));
            cardNumberField.sendKeys("4111 1111 1111 1111");


            //Enter card expiration date
            WebElement expirationField = driver.findElement(By.id("card-expiry"));
            expirationField.sendKeys("12/23");

            //Enter CVC of the card
            WebElement cvcField = driver.findElement(By.id("card-security"));
            cvcField.sendKeys("999");

            WebElement submitButton = driver.findElement(By.id("submitButton"));
            submitButton.click();


        } else {
            System.out.println("Confirm button is not present on the next page.");
        }

        }



    //Testcase 4: Verify that user can purchase a 100$ gift card for someone else

    public void TestCase4() {

        System.setProperty("webdriver.chrome.driver",
                "/Users/kohilnamdeo/Desktop/Phorest/chromedriver");
        driver = new ChromeDriver();

        driver.get("https://gift-cards.phorest.com/salons/demous#");

        //Open link in a new tab

        WebElement radioButton = driver.findElement(By.id("option100"));
        radioButton.click();

        WebElement SendToSomeoneElse = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div/nav/a[2]\n"));
        SendToSomeoneElse.click();

        //Enter data in the email address feild
        WebElement emailField = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div/div/input"));
        emailField.sendKeys("james@mail.com");

        // Enter data in the first name field
        WebElement firstNameField = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div/div/div[2]/div/div[1]/input"));
        firstNameField.sendKeys("Margo");

        // Enter data in the last name field
        WebElement lastNameField = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div/div/div[2]/div/div[2]/input"));
        lastNameField.sendKeys("Rose");

        //Enter recipient email address
        WebElement recipientEmailInput = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div/div/div[4]/input"));
        recipientEmailInput.sendKeys(("margo.rose@gmail.com"));


        //To input a message to recipient
        WebElement recipientMessageInput = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div/div/div[4]/textarea"));
        recipientMessageInput.sendKeys("Gift for your special day");

        //To click on checkout button
        WebElement checkoutButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[1]/div[2]/div[2]/button"));
        checkoutButton.click();

        //To click on 'Confirm Details' button

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement confirmButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/button")));
        confirmButton.click();

        if (confirmButton.isDisplayed()) {
            System.out.println("Confirm button is present on the next page.");
            //Click the confirm button
            confirmButton.click();

            try {
                Thread.sleep(10000); // Adjust the sleep duration as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //To go to the iframe so that user can input the payment details

            WebElement iframeElement1 = driver.findElement(By.tagName("iframe"));
            driver.switchTo().frame(iframeElement1);


            // Input payment details

            WebElement cardholderNameField = driver.findElement(By.id("card-name"));
            cardholderNameField.sendKeys("James Bond");

            // Enter zipcode
            WebElement zipCodeField = driver.findElement(By.id("card-zip"));
            zipCodeField.sendKeys("92606");

            //Enter card number
            WebElement cardNumberField = driver.findElement(By.id("card-number"));
            cardNumberField.sendKeys("4111 1111 1111 1111");


            //Enter card expiration date
            WebElement expirationField = driver.findElement(By.id("card-expiry"));
            expirationField.sendKeys("12/23");

            //Enter CVC of the card
            WebElement cvcField = driver.findElement(By.id("card-security"));
            cvcField.sendKeys("999");

            WebElement submitButton = driver.findElement(By.id("submitButton"));
            submitButton.click();


        } else {
            System.out.println("Confirm button is not present on the next page.");
        }

    }

}
//Testcase 5: Verify that user can purchase a 150$ gift card for someone else
    public void TestCase5() {

        System.setProperty("webdriver.chrome.driver",
                "/Users/kohilnamdeo/Desktop/Phorest/chromedriver");
        driver = new ChromeDriver();

        driver.get("https://gift-cards.phorest.com/salons/demous#");

        //Open link in a new tab

        WebElement radioButton = driver.findElement(By.id("option150"));
        radioButton.click();

        WebElement SendToSomeoneElse = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div/nav/a[2]\n"));
        SendToSomeoneElse.click();

        //Enter data in the email address feild
        WebElement emailField = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div/div/input"));
        emailField.sendKeys("james@mail.com");

        // Enter data in the first name field
        WebElement firstNameField = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div/div/div[2]/div/div[1]/input"));
        firstNameField.sendKeys("Margo");

        // Enter data in the last name field
        WebElement lastNameField = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div/div/div[2]/div/div[2]/input"));
        lastNameField.sendKeys("Rose");

        //Enter recipient email address
        WebElement recipientEmailInput = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div/div/div[4]/input"));
        recipientEmailInput.sendKeys(("margo.rose@gmail.com"));


        //To input a message to recipient
        WebElement recipientMessageInput = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div/div/div[4]/textarea"));
        recipientMessageInput.sendKeys("Gift for your special day");

        //To click on checkout button
        WebElement checkoutButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[1]/div[2]/div[2]/button"));
        checkoutButton.click();

        //To click on 'Confirm Details' button

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement confirmButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/button")));
        confirmButton.click();

        if (confirmButton.isDisplayed()) {
            System.out.println("Confirm button is present on the next page.");
            //Click the confirm button
            confirmButton.click();

            try {
                Thread.sleep(10000); // Adjust the sleep duration as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //To go to the iframe so that user can input the payment details

            WebElement iframeElement1 = driver.findElement(By.tagName("iframe"));
            driver.switchTo().frame(iframeElement1);


            // Input payment details

            WebElement cardholderNameField = driver.findElement(By.id("card-name"));
            cardholderNameField.sendKeys("James Bond");

            // Enter zipcode
            WebElement zipCodeField = driver.findElement(By.id("card-zip"));
            zipCodeField.sendKeys("92606");

            //Enter card number
            WebElement cardNumberField = driver.findElement(By.id("card-number"));
            cardNumberField.sendKeys("4111 1111 1111 1111");


            //Enter card expiration date
            WebElement expirationField = driver.findElement(By.id("card-expiry"));
            expirationField.sendKeys("12/23");

            //Enter CVC of the card
            WebElement cvcField = driver.findElement(By.id("card-security"));
            cvcField.sendKeys("999");

            WebElement submitButton = driver.findElement(By.id("submitButton"));
            submitButton.click();


        } else {
            System.out.println("Confirm button is not present on the next page.");
        }

    }

}















