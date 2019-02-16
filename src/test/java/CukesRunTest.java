import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions
        (
            features = {"src/test/features"},
            glue = {"clsspath:common/steps","classpath:common.setup","classpath:products"},
            plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html",
                    "pretty","html:target/cucumber-reports","json:target/cucumber-reports"},
                monochrome = true
            )


public class CukesRunTest {

    @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File("config/report.xml"));

    }
}
