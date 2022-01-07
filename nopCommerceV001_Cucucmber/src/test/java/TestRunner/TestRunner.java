package TestRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		publish = true,
        features = {".//Features/"},
        glue = "StepDef",
        dryRun = false,
        monochrome = true,
        plugin = {"pretty",
                "html:target/report.html"
        }
)

public class TestRunner {
}
