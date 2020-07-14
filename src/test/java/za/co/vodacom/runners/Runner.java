package za.co.vodacom.runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Before;
import org.junit.runner.RunWith;
import vfs.automation.core.utilities.SystemUtilities;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = "src/test/resources/features/web",
        tags = "@merchantweblogin,@merchantweblogoff",
        glue = "za.co.vodacom.stepDefinitions",
        plugin = {"pretty",
                "json:target/report/json/cucumber.json",
                "junit:target/report/TEST-za.co.vodacom.runners.Runner.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class Runner{
    @Before
    public void setup()throws Exception{
        //Setup test environment on construction. Environment variables hold priority over properties file variables.
        new SystemUtilities().setSystemProperty("env",new SystemUtilities().getPropertyValue("Environment","env"));
    }
}