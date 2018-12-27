package website.automate.waml.io.model.report;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.File;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static website.automate.waml.io.WamlTestUtils.*;

@RunWith(Parameterized.class)
public class WamlReportIT {

    @Parameterized.Parameter
    public File reportFile;

    @Test
    public void wamlReportIsDeserializedAndSerialized() throws Exception {
        WamlReport report = getObjectMapper().readValue(reportFile, WamlReport.class);
        String expectedSerializedReport = readFile(reportFile);
        String actualSerializedReport = getObjectMapper().writeValueAsString(report);

        assertEquals(expectedSerializedReport, actualSerializedReport);
    }

    @Parameterized.Parameters(name = "{0}")
    public static Iterable<? extends Object> data() {
        Collection<File> files = getSamples("model/report");
        return files;
    }
}
