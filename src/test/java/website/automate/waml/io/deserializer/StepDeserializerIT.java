package website.automate.waml.io.deserializer;

import java.io.InputStream;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import website.automate.waml.io.WamlConfig;
import website.automate.waml.io.model.step.Step;

public class StepDeserializerIT {

  private ObjectMapper objectMapper = WamlConfig.getInstance().getMapper();

  @Test(expected = UnknownStepException.class)
  public void stepDeserializerFailsWithUnknownStepException() throws Exception {
    objectMapper.readValue(
        getResourceAsStream("website/automate/waml/io/deserializer/unknown-step.yaml"), Step.class);
  }
  
  @Test(expected = UnknownCriterionException.class)
  public void stepDeserializerFailsWithUnknownCriterionException() throws Exception {
    objectMapper.readValue(
        getResourceAsStream("website/automate/waml/io/deserializer/unknown-criterion.yaml"), Step.class);
  }

  private InputStream getResourceAsStream(String path) {
    return StepDeserializerIT.class.getClassLoader().getResourceAsStream(path);
  }

}
