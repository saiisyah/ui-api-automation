package runners;

import org.junit.platform.suite.api.*;

@Suite
@SelectClasspathResource("Web")
@ConfigurationParameters({
        @ConfigurationParameter(key = "cucumber.features", value = "src/test/resources/Web"),
        @ConfigurationParameter(key = "cucumber.glue", value = "hooks, WebStepDefinitions,pages,config"),
        @ConfigurationParameter(key = "cucumber.filter.tags", value = "@web")
})
public class CucumberTest {
}

