package com.ashley_ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestCaseOne {
    public static void main(String[] args) throws InterruptedException {
        String str ="Hello Ashley";
        String str2 = str;
        System.out.println(str);

        WebDriverManager.chromedriver().setup();
//Below 2 lines disables chrome notification
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.ashleyfurniture.com/");

        String expected = "Ashley HomeStore | Home Furniture & Decor | Ashley Furniture HomeStore";
        String actual = driver.getTitle();
        System.out.println(actual);
        System.out.println(expected);
//        Assert.assertEquals(actual, expected);
        Assert.assertTrue(actual.equals(expected));
        System.out.println("Test Passed");

//Below lines switches to iframe and closes it
        Thread.sleep(5000);
        driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='fcopt-offers']//iframe")));
        driver.findElement(By.xpath("//div[@id='Close2-Item23']")).click();
//Ones we switched to Iframe, we Must switch back to main frame:
        driver.switchTo().defaultContent();

        System.out.println("Closing Browser");
        driver.quit();
//        driver.close();

//=============================================================================================================

        WebDriver driver1 = new ChromeDriver();
        driver1.get("https://www.google.com/");
        driver1.manage().window().maximize();
        String url = driver1.getCurrentUrl();
        System.out.println(url);
        System.out.println("This text was found by Nirosh:    " + driver1.findElement(By.xpath("(//a[@class='MV3Tnb'])[2]")).getText());

        driver1.findElement(By.name("q")).sendKeys("Tampa" + Keys.ENTER);
        System.out.println(driver1.getTitle());
        String expectedTitle = driver1.getTitle();
        String actualTitle = "Tampa - Google Search";
        Assert.assertEquals(expectedTitle, actualTitle);
        System.out.println("Pass");
        System.out.println("Closing browser");
        driver1.quit();


    }
}
