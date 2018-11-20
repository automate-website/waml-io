package website.automate.waml.io;

import static org.junit.Assert.assertEquals;
import static website.automate.waml.io.WamlTestUtils.getSamples;
import static website.automate.waml.io.WamlTestUtils.readFile;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import website.automate.waml.io.model.Scenario;
import website.automate.waml.io.reader.WamlReader;
import website.automate.waml.io.writer.WamlWriter;

@RunWith(Parameterized.class)
public class WamlIT {

    private static final WamlReader WAML_READER = WamlConfig.getInstance().getWamlReader();

    private static final WamlWriter WAML_WRITER =  WamlConfig.getInstance().getWamlWriter();

    @Parameter
    public File scenariosFile;

    @Test
    public void scenarioIsDeserializedAndSerialized() throws Exception {
        Scenario scenario = WAML_READER.read(scenariosFile);
        String expectedSerializedScenario = readFile(scenariosFile);
        String actualSerializedScenario = serializeScenario(scenario);

        assertEquals(expectedSerializedScenarios, actualSerializedScenarios);
    }

    @Parameters(name = "{0}")
    public static Iterable<? extends Object> data() {
        Collection<File> files = getSamples("website/automate/waml/io");
        return files;
    }

    private String serializeScenario(Scenario scenario) throws Exception {
        ByteArrayOutputStream scenariosOutputStream = new ByteArrayOutputStream();
        WAML_WRITER.write(scenario);
        return scenariosOutputStream.toString(StandardCharsets.UTF_8.name());
    }
}
