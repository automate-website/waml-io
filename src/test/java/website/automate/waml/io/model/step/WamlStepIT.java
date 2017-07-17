package website.automate.waml.io.model.step;

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

import website.automate.waml.io.model.step.Step;

@RunWith(Parameterized.class)
public class WamlStepIT {

  @Parameter
  public File stepFile;

  @Test
  public void scenarioIsDeserializedAndSerialized() throws Exception {
    Step step = getObjectMapper().readValue(stepFile, Step.class);
    String expectedSerializedStep = readFile(stepFile);
    String actualSerializedStep = getObjectMapper().writeValueAsString(step);

    assertEquals(expectedSerializedStep, actualSerializedStep);
  }

  @Parameters(name = "{0}")
  public static Iterable<? extends Object> data() {
    Collection<File> files = getSamples("website/automate/waml/io/model/step");
    return files;
  }
}
