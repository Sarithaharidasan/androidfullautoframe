package Runner_files;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
features = "src\\main\\java\\Header_positive_scenario\\Header_positive_scenario.feature",
glue= {"Header_positive_scenario"},
monochrome = true,publish = true)
public class Header_positive_scenario_runner extends AbstractTestNGCucumberTests {

}
