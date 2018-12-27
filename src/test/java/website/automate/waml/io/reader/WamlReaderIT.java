package website.automate.waml.io.reader;

import org.junit.Test;
import website.automate.waml.io.WamlConfig;

import java.io.File;

public class WamlReaderIT {

    private WamlReader reader = WamlConfig.getInstance().getWamlReader();

    @Test(expected = WamlDeserializationException.class)
    public void readerFailsWithDeserializationException() {
        reader.read(new File(WamlReaderIT.class.getClassLoader().getResource(
                "reader/unknown-action-scenario.yaml").getFile()));
    }
}
