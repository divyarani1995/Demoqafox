package com.tutorialsninja.automation.framework;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.tutorialsninja.automation.base.Base;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
    public static Logger log = Logger.getLogger(Browser.class);

    public static WebDriver startBrowser() {
        String browser = Base.reader.getBrowser() != null ? Base.reader.getBrowser().toLowerCase() : "chrome";  // Default to Chrome
        log.info("Selected Browser is: " + browser);

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                Base.driver = new ChromeDriver();
                log.info("Chrome Browser is Started " + Base.driver.hashCode());
                return Base.driver;

            case "ie":
                WebDriverManager.iedriver().setup();
                Base.driver = new InternetExplorerDriver();
                log.info("Internet Explorer Browser is Started " + Base.driver.hashCode());
                return Base.driver;

           

            default:
                WebDriverManager.firefoxdriver().setup();
                Base.driver = new FirefoxDriver();
                log.info("Firefox Browser is Started " + Base.driver.hashCode());
                return Base.driver;
        }
    }

    public static void maximize() {
        Base.driver.manage().window().maximize();
    }
    public static void openApplicationURL() {
    	 Base.driver.get(Base.reader.getUrl());
    }

    public static byte[] takeScreenshot() {
        try {
            return ((TakesScreenshot) Base.driver).getScreenshotAs(OutputType.BYTES);
        } catch (Exception e) {
            log.error("Exception occurred while taking screenshot: " + e.getMessage(), e);
            return null;
        }
    }
}
