package com.crossover.e2e;

import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Properties;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GMailTest extends TestCase {
    private WebDriver driver;
    private Properties properties = new Properties();

    public void setUp() throws Exception {

        properties.load(new FileReader(new File("src/test/resources/test.properties")));
        //Dont Change below line. Set this value in test.properties file incase you need to change it..
        System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
        driver = new ChromeDriver();
    }

    public void tearDown() throws Exception {
           driver.quit();
    }

    /*
     * Please focus on completing the task
     *
     */
    @Test
    public void testSendEmail() throws Exception {
        driver.manage().deleteAllCookies();
        driver.get("https://mail.google.com/");

//- Login to Gmail
        WebElement userElement = driver.findElement(By.id("identifierId"));
        userElement.sendKeys(properties.getProperty("username"));

        driver.findElement(By.id("identifierNext")).click();

        Thread.sleep(1000);

        WebElement passwordElement = driver.findElement(By.name("password"));
        passwordElement.sendKeys(properties.getProperty("password"));
        driver.findElement(By.id("passwordNext")).click();

        Thread.sleep(1000);

//- Compose an email from subject and body as mentioned in src/test/resources/test.properties
        WebElement composeElement = driver.findElement(By.cssSelector("div[class= 'T-I J-J5-Ji T-I-KE L3']"));
        composeElement.click();



//- Send the email to the same account which was used to login (from and to addresses would be the same)
        WebElement toTextArea = driver.findElement(By.name("to"));
        toTextArea.clear();
        toTextArea.click();
        toTextArea.sendKeys(String.format("%s@gmail.com", properties.getProperty("username")));

        // EmailSubject and emailbody to be used in this unit test.
        String emailSubject = properties.getProperty("email.subject");
        String emailBody = properties.getProperty("email.body");

        //Fill in the subject
        WebElement subjectArea = driver.findElement(By.name("subjectbox"));
        subjectArea.click();
        subjectArea.clear();
        subjectArea.sendKeys(emailSubject);

        //Fill in the body of the email
        WebElement bodyArea = driver.findElement(By.cssSelector("div [class='Am Al editable LW-avf']"));
        bodyArea.click();
        bodyArea.clear();
        bodyArea.sendKeys(emailBody);

        //- Label email as "Social"
        WebElement moreOptions = driver.findElement(By.xpath("//div[@id=':js']/div[@class='J-J5-Ji J-JN-M-I-JG']"));
        moreOptions.click();
        WebElement labelels = driver.findElement(By.xpath("//div[@id=':jv']/div[@class='J-N-Jz']"));
        labelels.click();
        Thread.sleep(2000);
        WebElement social = driver.findElement(By.xpath("//body[@class='aAU aWh']/div[38]//input[@type='text']"));
        social.sendKeys("Social");
        social.sendKeys(Keys.ENTER);

        //Click send
        WebElement send = driver.findElement(By.cssSelector("div[aria-label*=\"Send\"]"));
        send.click();

        //- Wait for the email to arrive in the Inbox
          Thread.sleep(5000);

        //  Mark email as starred
        WebElement StarBtn = driver.findElement(By.cssSelector("span[class = 'aXw T-KT']"));
        StarBtn.click();

        //Open the received email
       WebElement inboxlinkage = driver.findElement(By.xpath("//a[contains(text(),'Inbox')]"));
       inboxlinkage.click();

       WebElement inboxBtn = driver.findElement(By.xpath("//tr[contains(@class,'zA')]"));;
       inboxBtn.click();


        // Verify the subject and body of the received email
        WebElement subjectA = driver.findElement(By.cssSelector("h2[class = 'hP']"));
        Assert.assertEquals(emailSubject,subjectA.getText());

        WebElement bodyA = driver.findElement(By.cssSelector("div[class='nH aHU'] div[dir = 'ltr']"));
        Assert.assertEquals(emailBody,bodyA.getText());


//        - Generate test execution report at the end


    }
}