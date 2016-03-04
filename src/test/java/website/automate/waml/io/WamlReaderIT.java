package website.automate.waml.io;

import static java.lang.ClassLoader.getSystemResourceAsStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static website.automate.waml.io.model.CriterionValue.of;

import java.io.InputStream;
import java.util.List;

import org.junit.Test;

import website.automate.waml.io.model.Scenario;

public class WamlReaderIT {

    private WamlReader reader = new WamlReader();
    
    @Test
    public void multipleScenariosAreDeserialized() throws Exception {
        InputStream scenarioStream = getSystemResourceAsStream("./website/automate/waml/io/multiple-scenario.yaml");
        List<Scenario> scenarios = reader.read(scenarioStream);
        
        Scenario scenario = scenarios.get(0);
        assertNotNull(scenario);
        assertThat(scenario.getName(), is("scenario-name"));
        verifyProperties(scenario);
        
        Scenario anotherScenario = scenarios.get(1);
        assertNotNull(anotherScenario);
        assertThat(anotherScenario.getName(), is("another-scenario-name"));
        verifyProperties(anotherScenario);
    }
    
    private void verifyProperties(Scenario scenario){
        assertThat(scenario.getDescription(), is("scenario-description"));
        assertThat(scenario.getUnless(), is("${isMobile}"));
        assertThat(scenario.getWhen(), is("${isDesktop}"));
        assertThat(scenario.getTimeout(), is(of(100)));
    }
}
