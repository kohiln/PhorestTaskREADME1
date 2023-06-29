<h1>Project: GiftCardPurchase</h1>
A website where user can purchase a gift card for themselves or for someone else to use in a Salon or Spa service

<h1>Authors</h1>
@kohiln

<h1>🚀 About Me</h1>
A QA professional who is enthusiastic and goal driven to deliver best quality software product

<h1>Tech Stack</h1>

1. IDE: IntelliJ
2. Programming: Java, Selenium
3. CI Tool: Github
4. Dependencies: Selenium, ChromeDriver

<h1>Setting up IDE</h1>

To set up the IDE, please make sure you have the following installed:
1. Java JDK [version 17 or above]
2. IntelliJ IDE [Community Version]
3. Selenium Grid for Java [Version 4]
4. ChromeDriver Extension [As per your chrome browser version]

<h1>Creating Java Project</h1>

1. Open the IntelliJ IDE
2. Create new Java Project
3. Create Java Package
4. Create Java Class

<h1>Adding Dependencies</h1>
To add dependencies, open java project and follow the steps:

1. Go to Project Structure
2. Go to Modules
3. Select Dependencies
4. Click '+' to select selenium 'Jar' dependent files
5. Click Apply
6. Importing Libraries

  
> To import selenium libraries, we can write the following import commands:

    import org.openqa.selenium.*;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.WebDriverWait;
    import java.time.Duration;
    
<h1>Launching Chrome Browser</h1>

To launch the browser using the main class in java project, we can using 'WEBDRIVER' method. 
You can also set the property of chrome browser and the path.

You can copy the path of the chrome extension by going to local downloads > Copy as path

We will use 'get()' method to launch the website on chrome browser

    public class Main {

    WebDriver driver;

    System.setProperty("webdriver.chrome.driver",
    "//Users/kohilnamdeo/Downloads/chromedriver_mac64/  chromedriver"); //Provide the path to Chromedriver.exe in your local machine

    driver = new ChromeDriver();

    driver.get("https://gift-cards.phorest.com/salons/demous#");
    
In the section below, we will uncover postive and negative test scenarios related to the website.

Lets begin the positive test cases first.

<h1>Positive Test Case 1</h1>

To test the first scenario, follow the steps below.

<h5>Test case: Verify that user can purchase $50 gift card for themselves </h5>
<h5>Actual Result: User can purchase $50 gift card for themselves </h5>
<h5>Expected Result: User can purchase $50 gift card for themselves </h5>
<h5>Test Status: Pass </h5>

To write a test script for the test case, please refer to the code snippet below:

Below, we have used 'Find element' method to locate the fields.

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
    Thread.sleep(5000); 
    } catch (InterruptedException e) {
    e.printStackTrace();
    }
//Used switch to method so that user can input payment details

    WebElement iframeElement = driver.findElement(By.tagName("iframe"));
    driver.switchTo().frame(iframeElement);
    
// Input payment details

    WebElement cardholderNameField = driver.findElement(By.id("card-name"));
    cardholderNameField.sendKeys("Jane Smith");
    
// Enter zipcode WebElement 

    zipCodeField = driver.findElement(By.id("card-zip")); 
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
    
Screenshots <img width="1186" alt="PositiveTestCase1" src="https://github.com/kohiln/PhorestTaskREADME1/assets/137426778/ecf0ac57-0043-4e75-ad14-c736a461b423">


## Positive Test Case 2

To test the second scenario, follow the steps below. 

<h5>Test case: Verify that user can purchase a gift card for someone else for a custom amount</h5>
<h5>Actual Result: User can purchase gift card for someone else </h5>
<h5>Expected Result: User can purchase $50 gift card for someone else </h5>
<h5>Test Status: Pass </h5>

To write a test script for the test case, please refer to the code snippet below: 

Below, we have used 'Find element' method to locate the fields. 

// Declare a new class for the test case 

    public void TestCase2() {
    System.setProperty("webdriver.chrome.driver",
    "//Users/kohilnamdeo/Downloads/chromedriver_mac64/chromedriver"); 
    
//Set the path using local path from the computer

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


## ## Screenshots
// Other option selected with custom amount entered 
<img width="1181" alt="Testcase2 1" src="https://github.com/kohiln/PhorestTaskREADME1/assets/137426778/42490fe1-69fd-457e-9a96-b377a2a562f6">


//Successful purchase of gift card for someone else 
<img width="1195" alt="TestCase2 2" src="https://github.com/kohiln/PhorestTaskREADME1/assets/137426778/0e68ed10-d937-4c91-9f56-e6191fb3985e">


## Negative Test Case 1

Now lets run some negative test paths to validate functionalities of the website 

<h5>Test case: Verify that user cannot go to checkout using invalid email address</h5>
<h5>Actual Result: User cannot go to checkout using invalid email address </h5>
<h5>Expected Result: User cannot go to checkout using invalid email address </h5>
<h5>Test Status: Pass </h5>

Lets begin by creating another class for this test case

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

## ## Screenshots

//Error Message Displayed on the screen 

<img width="1190" alt="Testcase3 1" src="https://github.com/kohiln/PhorestTaskREADME1/assets/137426778/f2bea955-57bb-4691-9f39-8b0ae288a201">


## Negative Test Case 2

Now lets run another negative test path to validate functionalities of the website 

<h5>Test case: Verify that user cannot complete checkout with invalid card expiry date</h5>
<h5>Actual Result: User cannot complete checkout with invalid card expiry </h5>
<h5>Expected Result: User cannot complete checkout with invalid card expiry </h5>
<h5>Test Status: Pass </h5>

Lets begin by creating another class for this test case

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


## ## Screenshots

//Error Message Displayed on the screen 
<img width="1196" alt="testcase4 1" src="https://github.com/kohiln/PhorestTaskREADME1/assets/137426778/12d4a2fd-2d23-4b49-8376-07133f20a3fb">


## ## Github Integration 

Now that our test scripts are ready, we can commit and push the code to Github. To do that, please ensure you have a github account and dloow the steps below: 

1. Save the changes you have made on your IDE
2. Run test scripts to ensure no error
3. Open your git account
4. Create a new repository
5. In your IDE, select 'Git commit'
6. Select the files you want to commit
7. Input a commit message 
8. Click 'Commit' or 'Commit and Push' to push the code 


After a few seconds, your code will be pushed to the git repository



## ## Additional Bug Found 

<h5>In the process, I found 1 additional minor bug. Below is the bug report for the identified bug. </h5>

1. Test Case Id: 1
2. Test Case Title: Entering custom gift card amount
3. Test Case Description: When user edits custom gift card amount, the gift card still displays an amount
4. Test Steps:
     a. Go to https://gift-cards.phorest.com/salons/demous#
     b. In gift card value, select 'other' option
     c. Enter a gift card amount (For eg: 900$)
     d. Delete the card amount

5. Expected Result: Gift card displays 0 amount as Other amount field is empty
6. Actual Result: Gift card displays an amount when other amount field is empty
7. Severity: Low
8. Priotity: Medium 
9. Screenshot of the bug: 
<img width="1083" alt="Bug1" src="https://github.com/kohiln/PhorestTaskREADME1/assets/137426778/fcf9c2a7-6838-4c9b-9b11-6cf5796fd3e2">




















