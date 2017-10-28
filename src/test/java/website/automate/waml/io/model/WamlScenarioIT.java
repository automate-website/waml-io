package website.automate.waml.io.model;

import static org.junit.Assert.assertEquals;
import static website.automate.waml.io.WamlTestUtils.getObjectMapper;
import static website.automate.waml.io.WamlTestUtils.getSamples;
import static website.automate.waml.io.WamlTestUtils.readFile;

import java.io.File;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import website.automate.waml.io.model.Scenario;

@RunWith(Parameterized.class)
public class WamlScenarioIT {

  @Parameter
  public File scenarioFile;

  @Test
  public void scenarioIsDeserializedAndSerialized() throws Exception {
    Scenario scenario = getObjectMapper().readValue(scenarioFile, Scenario.class);
    String expectedSerializedScenario = readFile(scenarioFile);
    String actualSerializedScenario = getObjectMapper().writeValueAsString(scenario);

    assertEquals(expectedSerializedScenario, actualSerializedScenario);
  }

  @Parameters(name = "{0}")
  public static Iterable<? extends Object> data() {
    Collection<File> files = getSamples("website/automate/waml/io/model");
    return files;
  }
}
