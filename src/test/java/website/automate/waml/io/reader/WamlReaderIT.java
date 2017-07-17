package website.automate.waml.io.reader;

import org.junit.Test;

import website.automate.waml.io.reader.WamlDeserializationException;
import website.automate.waml.io.reader.WamlReader;

public class WamlReaderIT {

  private WamlReader reader = new WamlReader();
  
  @Test(expected=WamlDeserializationException.class)
  public void readerFailsWithDeserializationException(){
    reader.read(WamlReaderIT.class.getClassLoader().getResourceAsStream("website/automate/waml/io/reader/unknown-step-scenario.yaml"));
  }
}
