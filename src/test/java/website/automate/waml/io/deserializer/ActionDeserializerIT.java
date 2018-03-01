package website.automate.waml.io.deserializer;

import java.io.InputStream;
import org.junit.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import website.automate.waml.io.WamlConfig;
import website.automate.waml.io.model.action.Action;

public class ActionDeserializerIT {

    private ObjectMapper objectMapper = WamlConfig.getInstance().getMapper();

    @Test(expected = UnknownActionException.class)
    public void actionDeserializerFailsWithUnknownActionException() throws Exception {
        objectMapper.readValue(
                getResourceAsStream("website/automate/waml/io/deserializer/unknown-action.yaml"),
                Action.class);
    }

    @Test(expected = UnknownCriterionException.class)
    public void actionDeserializerFailsWithUnknownCriterionException() throws Exception {
        objectMapper.readValue(
                getResourceAsStream("website/automate/waml/io/deserializer/unknown-criterion.yaml"),
                Action.class);
    }

    private InputStream getResourceAsStream(String path) {
        return ActionDeserializerIT.class.getClassLoader().getResourceAsStream(path);
    }

}
