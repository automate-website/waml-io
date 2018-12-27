package website.automate.waml.io.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import website.automate.waml.io.WamlConfig;
import website.automate.waml.io.model.main.action.Action;

import java.io.InputStream;

public class ActionDeserializerIT {

    private ObjectMapper objectMapper = WamlConfig.getInstance().getMapper();

    @Test(expected = UnknownActionException.class)
    public void actionDeserializerFailsWithUnknownActionException() throws Exception {
        objectMapper.readValue(
                getResourceAsStream("deserializer/unknown-action.yaml"),
                Action.class);
    }

    @Test(expected = UnknownCriterionException.class)
    public void actionDeserializerFailsWithUnknownCriterionException() throws Exception {
        objectMapper.readValue(
                getResourceAsStream("deserializer/unknown-criterion.yaml"),
                Action.class);
    }

    private InputStream getResourceAsStream(String path) {
        return ActionDeserializerIT.class.getClassLoader().getResourceAsStream(path);
    }

}
