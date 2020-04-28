package presets;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"src/test/resources/features/"},
        glue = {"steps"},
        tags = {"@test"}
)
public class RunTest extends AbstractTestNGCucumberTests{

}

/*@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/"},
        glue = {"steps"},
        tags = {"@test"}
)
public class RunTest {

}*/
