package StepsForTests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features", glue={"StepsForTests"},
        monochrome = true,
        plugin = {"pretty", "html:src/test/resources/reports/reportsHtml/report.html",
                "json:src/test/resources/reports/reportsJson/report.json",
                "html:src/test/resources/reports/reportXml/report.xml"})
public class Config {
}
