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

  private static final WamlReader WAML_READER = new WamlReader();

  private static final WamlWriter WAML_WRITER = new WamlWriter();

  @Parameter
  public File scenariosFile;

  @Test
  public void scenarioIsDeserializedAndSerialized() throws Exception {
    List<Scenario> scenarios = WAML_READER.read(new FileInputStream(scenariosFile));
    String expectedSerializedScenarios = readFile(scenariosFile);
    String actualSerializedScenarios = serializeScenarios(scenarios);

    assertEquals(expectedSerializedScenarios, actualSerializedScenarios);
  }

  @Parameters(name = "{0}")
  public static Iterable<? extends Object> data() {
    Collection<File> files = getSamples("website/automate/waml/io");
    return files;
  }

  private String serializeScenarios(List<Scenario> scenarios) throws Exception {
    ByteArrayOutputStream scenariosOutputStream = new ByteArrayOutputStream();
    WAML_WRITER.write(scenariosOutputStream, scenarios);
    return scenariosOutputStream.toString(StandardCharsets.UTF_8.name());
  }
}
