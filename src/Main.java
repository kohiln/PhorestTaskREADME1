import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Main {

    WebDriver driver;

    //PositiveTestCase1
    //TestCase1: Verify that user can purchase a $50 gift card for themselves

    //Created a class to launch the website on chrome
    public void launchBrowser() {
        System.setProperty("webdriver.chrome.driver",
                "//Users/kohilnamdeo/Downloads/chromedriver_mac64/chromedriver"); //Provide the path to Chromedriver.exe in your local machine
        driver = new ChromeDriver();

        driver.get("https://gift-cards.phorest.com/salons/demous#");

        //Find and select the radio button
        WebElement radioButtonOption50 = driver.findElement(By.id("option50"));
        radioButtonOption50.click();

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


        // Add an if/else block to validate the selection of confirm button
        if (confirmButton.isDisplayed()) {
            System.out.println("Confirm button is present on the next page.");
            //Click the confirm button
            confirmButton.click();

            try {
                Thread.sleep(5000); // Adjust the sleep duration as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //Used switch to method so that user can input payment details

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

            //Click Submit Button
            WebElement submitButton = driver.findElement(By.id("submitButton"));
            submitButton.click();


        } else {
            System.out.println("Confirm button is not present on the next page.");
        }
    }

//Created a public class to run and execute all test cases
    public static void main(String[] args) {

        Main obj = new Main();
        obj.launchBrowser();
        obj.TestCase2();
        obj.TestCase3();
        obj.TestCase4();



    }
//PositiveTestCase2
//TestCase2: Verify that user can purchase a gift card for someone else for a custom amount
public void TestCase2() {

    System.setProperty("webdriver.chrome.driver",
            "//Users/kohilnamdeo/Downloads/chromedriver_mac64/chromedriver");
    driver = new ChromeDriver();

    driver.get("https://gift-cards.phorest.com/salons/demous#");

// To select the radiobutton option
    WebElement radioButtonOtherOption = driver.findElement(By.id("optionOther"));
    radioButtonOtherOption.click();

    //To enter a custom gift card amount
    WebElement otherAmountField = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[1]/div/ul/li[4]/div/input"));
    otherAmountField.sendKeys("200");

    //To select option to send gift card to someone else
    WebElement SendToSomeoneElseOption = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div/nav/a[2]\n"));
    SendToSomeoneElseOption.click();

    //Enter data in the email address feild
    WebElement emailAddressField = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div/div/input"));
    emailAddressField.sendKeys("oliver@gmail.com");

    // Enter data in the first name field
    WebElement firstNameInputField = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div/div/div[2]/div/div[1]/input"));
    firstNameInputField.sendKeys("Abby");

    // Enter data in the last name field
    WebElement lastNameInputField = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div/div/div[2]/div/div[2]/input"));
    lastNameInputField.sendKeys("Rose");

    //Enter recipient email address
    WebElement recipientEmailInput = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div/div/div[4]/input"));
    recipientEmailInput.sendKeys(("abby.rose@gmail.com"));

    //To input a gift card message to the recipient
    WebElement recipientMessageInput = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div/div/div[4]/textarea"));
    recipientMessageInput.sendKeys("Gift for your special day");

    //To click on checkout button
    WebElement checkoutButton_Testcase2 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[1]/div[2]/div[2]/button"));
    checkoutButton_Testcase2.click();

    //User wait variable to give time for successful execution
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    WebElement confirmButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/button")));
    confirmButton.click();

    System.out.println("confirmButton.isDisplayed()");
    //To give time so that payment page is loaded successfully
    try {
        Thread.sleep(15000); // Adjust the sleep duration as needed
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    //To go to the iframe so that user can input the payment details

    WebDriverWait waitPayment = new WebDriverWait(driver, Duration.ofSeconds(15));
    WebElement iframeElement = driver.findElement(By.xpath("(//iframe)[position()=1]"));
    driver.switchTo().frame(iframeElement);

    System.out.println("Text");

    // Input payment details

    WebElement cardholderNameField = driver.findElement(By.id("card-name"));
    cardholderNameField.sendKeys("Abby Rose");


    // Enter zipcode
    WebElement zipCodeField = driver.findElement(By.name("cardZip"));
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

    //To submit the payment details
    WebElement submitButton = driver.findElement(By.id("submitButton"));
    submitButton.click();

}

//NegativeTestCase3
 //TestCase3: Verify that user cannot go to checkout using invalid email address
    public void TestCase3() {

        System.setProperty("webdriver.chrome.driver",
                "//Users/kohilnamdeo/Downloads/chromedriver_mac64/chromedriver");
        driver = new ChromeDriver();

        driver.get("https://gift-cards.phorest.com/salons/demous#");

        //Select the radio button
        WebElement radioButtonOption100 = driver.findElement(By.id("option100"));
        radioButtonOption100.click();

        //Enter invalid data in the email address feild
        WebElement emailFieldAddress = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div/div/input"));
        emailFieldAddress.sendKeys("agamail.com");

        // Enter data in the first name field
        WebElement firstNameField = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div/div/div[2]/div/div[1]/input"));
        firstNameField.sendKeys("Aga");

        // Enter data in the last name field
        WebElement lastNameField = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div/div/div[2]/div/div[2]/input"));
        lastNameField.sendKeys("Jones");

        //To select the checkout button
        WebElement checkoutButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[1]/div[2]/div[2]/button"));
        checkoutButton.click();


    }


//NegativeTestCase4
//TestCase4: Verify that user cannot complete gift card checkout with invalid card expiry date

    public void TestCase4() {

        System.setProperty("webdriver.chrome.driver",
                "//Users/kohilnamdeo/Downloads/chromedriver_mac64/chromedriver");
        driver = new ChromeDriver();

        driver.get("https://gift-cards.phorest.com/salons/demous#");

        //Select the radio button
        WebElement radioButtonOption150 = driver.findElement(By.id("option150"));
        radioButtonOption150.click();

        //To select so that user can send gift card to someone else
        WebElement SendToSomeoneElseOption = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div/nav/a[2]\n"));
        SendToSomeoneElseOption.click();

        //Enter data in the email address feild
        WebElement emailAddressData = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div/div/input"));
        emailAddressData.sendKeys("christie@mail.com");

        // Enter data in the first name field
        WebElement firstNameData = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div/div/div[2]/div/div[1]/input"));
        firstNameData.sendKeys("Nick");

        // Enter data in the last name field
        WebElement lastNameData = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div/div/div[2]/div/div[2]/input"));
        lastNameData.sendKeys("Jonas");

        //Enter recipient email address
        WebElement recipientEmailData = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div/div/div[4]/input"));
        recipientEmailData.sendKeys(("nick@jonas.com"));

        //To input a message to recipient
        WebElement recipientMessageData = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div/div/div[4]/textarea"));
        recipientMessageData.sendKeys("Gift for your special day");

        //To click on checkout button
        WebElement checkoutButton_Testcase4 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[1]/div[2]/div[2]/button"));
        checkoutButton_Testcase4.click();

        // To wait for successful execution
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
       WebElement confirmButtonCheckout = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/button")));
       confirmButtonCheckout.click();

        System.out.println("confirmButton.isDisplayed()");
        //To give time so that payment page is loaded successfully
        try {
            Thread.sleep(15000); // Adjust the sleep duration as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //To go to the iframe so that user can input the payment details

        WebDriverWait waitPayment = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement iframeElement = driver.findElement(By.xpath("(//iframe)[position()=1]"));
        driver.switchTo().frame(iframeElement);

        System.out.println("Text");

        // Input payment details

        WebElement cardholderNameData = driver.findElement(By.id("card-name"));
        cardholderNameData.sendKeys("Christie Rose");


        // Enter zipcode
        WebElement zipCodeFieldData = driver.findElement(By.name("cardZip"));
        zipCodeFieldData.sendKeys("92606");

        //Enter card number
        WebElement cardNumberFieldData = driver.findElement(By.id("card-number"));
        cardNumberFieldData.sendKeys("4111 1111 1111 1111");


        //Enter invalid card expiration date
        WebElement expirationFieldData= driver.findElement(By.id("card-expiry"));
        expirationFieldData.sendKeys("12/21");

        //Enter CVC of the card
        WebElement cvcFieldData = driver.findElement(By.id("card-security"));
        cvcFieldData.sendKeys("999");

        //To submit payment details
        WebElement submitButtonCheckout = driver.findElement(By.id("submitButton"));
        submitButtonCheckout.click();


    }
}






















