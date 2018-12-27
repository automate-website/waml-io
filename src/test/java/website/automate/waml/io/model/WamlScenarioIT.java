package website.automate.waml.io.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import website.automate.waml.io.WamlConfig;
import website.automate.waml.io.model.main.Scenario;
import website.automate.waml.io.reader.WamlReader;

import java.io.File;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static website.automate.waml.io.WamlTestUtils.*;

@RunWith(Parameterized.class)
public class WamlScenarioIT {

    private WamlReader wamlReader = WamlConfig.getInstance().getWamlReader();

    @Parameter
    public File scenarioFile;

    @Test
    public void scenarioIsDeserializedAndSerialized() throws Exception {
        Scenario scenario = wamlReader.read(scenarioFile);
        String expectedSerializedScenario = readFile(scenarioFile);
        String actualSerializedScenario = getObjectMapper().writeValueAsString(scenario);

        assertEquals(expectedSerializedScenario, actualSerializedScenario);
    }

    @Parameters(name = "{0}")
    public static Iterable<? extends Object> data() {
        Collection<File> files = getSamples("model");
        return files;
    }
}
