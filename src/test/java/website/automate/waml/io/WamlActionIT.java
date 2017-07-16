package website.automate.waml.io;

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

import website.automate.waml.io.model.action.Action;

@RunWith(Parameterized.class)
public class WamlActionIT {

  @Parameter
  public File actionFile;

  @Test
  public void scenarioIsDeserializedAndSerialized() throws Exception {
    Action action = getObjectMapper().readValue(actionFile, Action.class);
    String expectedSerializedAction = readFile(actionFile);
    String actualSerializedAction = getObjectMapper().writeValueAsString(action);

    assertEquals(expectedSerializedAction, actualSerializedAction);
  }

  @Parameters(name = "{0}")
  public static Iterable<? extends Object> data() {
    Collection<File> files = getSamples("website/automate/waml/io/model/action");
    return files;
  }
}
