package website.automate.waml.io.writer;

import java.io.OutputStream;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import website.automate.waml.io.model.Scenario;
import website.automate.waml.io.model.report.WamlReport;

public class WamlWriter {

    private ObjectMapper objectMapper;

    public WamlWriter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public void write(OutputStream scenarioStream, List<Scenario> scenarios) {
        try {
            for (Scenario scenario : scenarios) {
                objectMapper.writeValue(scenarioStream, scenario);
            }
        } catch (Exception e) {
            throw new WamlSerializationException("Unable to write the suite to desired format.", e);
        }
    }

    public void write(OutputStream reportStream, WamlReport report) {
        try {
            objectMapper.writeValue(reportStream, report);
        } catch (Exception e) {
            throw new WamlSerializationException("Unable to write the suite to desired format.", e);
        }
    }
}
