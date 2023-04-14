package step_definitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import pages.CommonPage;
import utils.BrowserUtils;

import java.util.List;

public class MultipleWindowSteps implements CommonPage {

    @Then("Verify link text {string} is displayed")
    public void verifyLinkTextIsDisplayed(String buttonName) {
        BrowserUtils.isDisplayed(
                BrowserUtils.getDriver().findElement(By.xpath(
                        String.format(XPATH_TEMPLATE_LINKTEXT, buttonName)
                ))
        );
    }

    @Then("Verify following link texts are displayed:")
    public void verifyFollowingLinkTextsAreDisplayed(List<String> data) {
        for(String each: data){
            BrowserUtils.isDisplayed(
                    BrowserUtils.getDriver().findElement(By.xpath(
                            String.format(XPATH_TEMPLATE_LINKTEXT, each)
                    ))
            );
        }
    }
}
