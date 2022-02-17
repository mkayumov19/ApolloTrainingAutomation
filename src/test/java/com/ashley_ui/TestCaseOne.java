package com.ashley_ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCaseOne {

    public static void main(String[] args) {

        String str ="Hello Ashley";
        String str2 = str;
        System.out.println(str);

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ashleyfurniture.com/");

        String expected = "Ashley Furniture HomeStore  Home Furniture & Decor";
        String actual = driver.getTitle();

//        Assert.assertEquals(actual, expected);
        Assert.assertTrue(actual.equals(expected));
        System.out.println("Test Passed");

        driver.quit();

    }

}
