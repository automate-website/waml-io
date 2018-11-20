package website.automate.waml.io.mappers;

import com.fasterxml.jackson.databind.ObjectMapper;
import website.automate.waml.io.model.main.Scenario;

public class ScenarioMapper {

    private ObjectMapper objectMapper;

    public ScenarioMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Scenario map(Scenario action) throws Exception {
        try {
            return objectMapper.readValue(objectMapper.writeValueAsString(action),
                    action.getClass());
        } catch (Exception e) {
            throw new RuntimeException("Can't map scenario!", e);
        }
    }
}
