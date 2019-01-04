package website.automate.waml.io.model.main.action;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.io.File;
import java.util.Collection;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static website.automate.waml.io.WamlTestUtils.*;

@RunWith(Parameterized.class)
public class WamlActionIT {

    @Parameter
    public File actionFile;

    @Test
    public void scenarioIsDeserializedAndSerialized() throws Exception {
        Action action = getObjectMapper().readValue(actionFile, Action.class);
        String expectedSerializedAction = readFile(actionFile);
        String actualSerializedAction = getObjectMapper().writeValueAsString(action);

        assertThat(actualSerializedAction, is(expectedSerializedAction));
    }

    @Parameters(name = "{0}")
    public static Iterable<? extends Object> data() {
        Collection<File> files = getSamples("model/main/action");
        return files;
    }
}
