import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions
        (
            features = {"src/test/resources/features"},
        tags = { "@Smoke", "@Regression" },
        glue = {"classpath:common/steps","classpath:common.setup","classpath:products"},
            plugin = {
            "html:target/cucumber-reports/report","json:target/cucumber-reports/report",
            "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"
            },monochrome = true
            )


public class CukesRunTest {

    @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File("E:\\ZolStaff\\HiQATech\\HiQATechJava\\cucumber-selenium-tests\\src\\test\\java\\config\\report.xml"));

    }
}
