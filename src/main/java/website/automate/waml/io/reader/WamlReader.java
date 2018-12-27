package website.automate.waml.io.reader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import website.automate.waml.io.model.main.Scenario;
import website.automate.waml.io.model.main.action.Action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import static java.text.MessageFormat.format;

public class WamlReader {

    private ObjectMapper objectMapper;

    public WamlReader(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Scenario read(File file) {
        String path = file.getPath();
        String name = file.getName();

        try {
            List<Action> steps = readSteps(new FileInputStream(file));
            return createScenario(name, path, steps);
        } catch (Exception e) {
            throw new WamlDeserializationException(format("Failed to open file {0}.", path), e);
        }
    }

    private Scenario createScenario(String name, String path, List<Action> steps) {
        Scenario scenario = new Scenario();
        scenario.setPath(path);
        scenario.setName(name);
        scenario.setSteps(steps);
        return scenario;
    }

    private List<Action> readSteps(InputStream inputStream) {
        try {
            return objectMapper.readValue(
                inputStream,
                objectMapper
                    .getTypeFactory()
                    .constructType(new TypeReference<List<Action>>() {
                    })
            );
        } catch (Exception e) {
            if (e instanceof WamlDeserializationException) {
                throw (WamlDeserializationException) e;
            } else {
                throw new WamlDeserializationException(
                    "Failed to deserialize from stream.", e);
            }
        }
    }

}
