package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.BrowserUtils;
import utils.CucumberLogUtils;

public class Hooks {

    @Before("@hooks")
    public void setUp(Scenario scenario){
        //initialized the driver object to open the browser
        BrowserUtils.getDriver();
        CucumberLogUtils.initScenario(scenario);
    }

    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            CucumberLogUtils.logFail("Scenario failed", true);
        }
        BrowserUtils.quitDriver();
    }

}
