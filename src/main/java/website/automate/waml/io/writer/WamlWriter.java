package website.automate.waml.io.writer;

import com.fasterxml.jackson.databind.ObjectMapper;
import website.automate.waml.io.model.main.Scenario;
import website.automate.waml.io.model.main.action.Action;
import website.automate.waml.io.model.report.WamlReport;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

public class WamlWriter {

    private ObjectMapper objectMapper;

    public WamlWriter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public void write(Scenario scenario){
        try (FileOutputStream outputStream = new FileOutputStream(scenario.getPath())){
            writeSteps(outputStream, scenario.getSteps());
        } catch (Exception e){
            throw new WamlSerializationException("Failed to open stream.", e);
        }
    }

    private void writeSteps(OutputStream outputStream, List<Action> actions){
        try {
            objectMapper.writeValue(outputStream, actions);
        } catch (Exception e) {
            throw new WamlSerializationException("Failed to serialize to stream.", e);
        }
    }

    public void write(WamlReport report) {
        try {
            FileOutputStream outputStream = new FileOutputStream(report.getPath());
            objectMapper.writeValue(outputStream, report);
        } catch (Exception e) {
            throw new WamlSerializationException("Unable to write the suite to desired format.", e);
        }
    }
}
