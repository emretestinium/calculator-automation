package com.testcase1;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.junit.Assert; 
import org.junit.BeforeClass;
import org.openqa.selenium.By;  
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.WebElement;  

/**
 * Unit test for simple App.
 */
public class case1 {
    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.get("https://catchylabs-webclient.testinium.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement divWithText = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Open Calculator']")));
        divWithText.click();

        System.out.println("User is logged in and the page is loaded.");
    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void testAddition() {

        try {
            driver.findElement(By.xpath("//div[text()='AC']")).click();
            driver.findElement(By.xpath("//div[text()='7']")).click();
            driver.findElement(By.xpath("//div[text()='+']")).click();
            driver.findElement(By.xpath("//div[text()='3']")).click();
            driver.findElement(By.xpath("//div[text()='=']")).click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }

            WebElement result = driver.findElement(By.xpath("//span[contains(text(), '= ')]"));
            String cleanResult = result.getText().replace("= ", "");
            Assert.assertEquals(cleanResult, "10");
        } finally {

        }
    }

    @Test
    public void testDivision() {

        try {
            driver.findElement(By.xpath("//div[text()='AC']")).click();
            
            driver.findElement(By.xpath("//div[text()='8']")).click();
            driver.findElement(By.xpath("//div[text()='/']")).click();
            driver.findElement(By.xpath("//div[text()='2']")).click();
            driver.findElement(By.xpath("//div[text()='=']")).click();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }

            WebElement result = driver.findElement(By.xpath("//span[contains(text(), '= ')]"));
            String cleanResult = result.getText().replace("= ", "");
            Assert.assertEquals(cleanResult, "4");
        } finally {
        }
    }

    @Test
    public void testMultiply() {

        try {

            driver.findElement(By.xpath("//div[text()='AC']")).click();
            driver.findElement(By.xpath("//div[text()='9']")).click();
            driver.findElement(By.xpath("//div[text()='-']")).click();
            driver.findElement(By.xpath("//div[text()='5']")).click();
            driver.findElement(By.xpath("//div[text()='=']")).click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
            WebElement result = driver.findElement(By.xpath("//span[contains(text(), '= ')]"));
            String cleanResult = result.getText().replace("= ", "");
            Assert.assertEquals(cleanResult, "4");
        } finally {
        }
    }
}
