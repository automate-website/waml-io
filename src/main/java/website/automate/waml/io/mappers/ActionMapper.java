package website.automate.waml.io.mappers;

import com.fasterxml.jackson.databind.ObjectMapper;
import website.automate.waml.io.model.action.Action;

public class ActionMapper {

    private ObjectMapper objectMapper;

    public ActionMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @SuppressWarnings("unchecked")
    public <T extends Action> T map(T action) {
        try {
            return (T) objectMapper.readValue(objectMapper.writeValueAsString(action),
                    action.getClass());
        } catch (Exception e) {
            throw new RuntimeException("Can't map action!", e);
        }
    }
}
