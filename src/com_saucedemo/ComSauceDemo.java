package com_saucedemo;
/**
 * 1. Setup Chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Enter the email to email field.
 * 7. Enter the password to password field.
 * 8. Click on Login Button.
 * 9. Print the current url.
 * 10. Navigate to baseUrl
 * 11. Refresh the page.
 * 12. Close the browser.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class ComSauceDemo {

    static String baseUrl = "https://www.saucedemo.com/";
    static String browser = "Chrome";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("EdgeDriver")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }
            //Open Url
            driver.get(baseUrl);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            //Print the title of the page
            System.out.println(driver.getTitle());
            //Print the current Url
            System.out.println(driver.getCurrentUrl());
            //Print the page source
            System.out.println(driver.getPageSource());

            Thread.sleep(5000);
            //Enter the Email to Email field
            driver.findElement(By.id("user-name")).sendKeys("standard_user");

            Thread.sleep(5000);
            //Enter the password to password field
            driver.findElement(By.name("password")).sendKeys("secret_sauce");

            Thread.sleep(5000);
            //Click on Login Button
            driver.findElement(By.id("login-button")).click();

            //Print the current Url
            System.out.println("https://www.saucedemo.com/inventory.html");

            //Navigate to baseUrl
            driver.get(baseUrl);

            //Refresh the page
            driver.navigate().refresh();

            //Close the browser
            driver.quit();

        }
    }
