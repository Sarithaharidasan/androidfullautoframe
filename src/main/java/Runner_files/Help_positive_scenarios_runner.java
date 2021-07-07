package Runner_files;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
features = "C:\\Users\\Admin\\eclipse-workspace\\Androidauto\\src\\main\\java\\Help_positive_scenarios\\Help_positive_scenarios.feature",
glue= {"Help_positive_scenarios"},
monochrome = true,publish = true)
public class Help_positive_scenarios_runner extends AbstractTestNGCucumberTests {

}
