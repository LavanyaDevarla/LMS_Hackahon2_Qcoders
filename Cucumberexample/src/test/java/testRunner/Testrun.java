package testRunner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions
(
		features=".//Featureexample/Login1.feature",
		glue ="stepDefinition",
		dryRun=false,
		monochrome=true,
        plugin= {"pretty",
        		"html:target/cu.html"}
)
public class Testrun {
  
}
