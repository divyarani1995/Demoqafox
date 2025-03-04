
package com.tutorialsninja.automation.stepdef;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.util.PathHelper;
import com.tutorialsninja.automation.config.PropertyFileReader;
import com.tutorialsninja.automation.framework.Browser;
import io.cucumber.java.Scenario;
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class Hooks {
    private static Logger log = Logger.getLogger(Hooks.class);

    @Before
    public void setUp(Scenario scenario) {
        PropertyConfigurator.configure(PathHelper.getResourcePath("/src/main/resources/ConfigurationFile/log4j.properties"));
        log.info("Scenario Started: " + scenario.getName());

        // Initialize PropertyReader and Browser
        Base.reader = new PropertyFileReader();  
        Browser.startBrowser();
        Browser.maximize();
    }

    @After
    public void closeBrowser(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = Browser.takeScreenshot(); // Ensure this returns byte[]
            if (screenshot != null) {
                scenario.attach(screenshot, "image/png", "Failed Screenshot");
            }
        }
        log.info("Scenario Completed: " + scenario.getName());
        log.info("Scenario Status is: " + scenario.getStatus());

        if (Base.driver != null) {  // Always check if driver is initialized
            Base.driver.quit();
        }
    }
}