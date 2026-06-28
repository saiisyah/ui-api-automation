package runners;

import org.junit.platform.suite.api.*;

@Suite
@SelectClasspathResource("API")
@ConfigurationParameters({
        @ConfigurationParameter(key = "cucumber.glue", value = "hooks, APIStepDefinitions"),
        @ConfigurationParameter(key = "cucumber.filter.tags", value = "@api")
})
public class APIRunnerTes {
}
