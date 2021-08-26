package com.tests;

import com.steps.CartSteps;
import com.steps.LoginSteps;
import com.steps.ProductDetailsSteps;
import com.steps.WishlistSteps;
import com.steps.flowsteps.ProductFlowSteps;
import com.tools.constants.EnvironmentConstants;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.StepEventBus;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@RunWith(SerenityRunner.class)
public class BaseTest {
    @Managed(uniqueSession = true)
    WebDriver webdriver;
    protected WebDriver driver;
    @Steps
    protected LoginSteps loginSteps;
    @Steps
    protected CartSteps cartSteps;
    @Steps
    protected ProductFlowSteps productFlowSteps;
    @Steps
    protected ProductDetailsSteps productDetailsSteps;
    @Steps
    protected WishlistSteps wishlistSteps;
    @Before
    public void setup() {
        System.setProperty("env", "qa2-env");
        webdriver.navigate().to(EnvironmentConstants.BASE_URL);
    }

    @After
    public void tearDown() {
        StepEventBus.getEventBus().clearStepFailures();
        webdriver.quit();
    }
}
