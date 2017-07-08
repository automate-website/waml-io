package website.automate.waml.io.serializer;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import website.automate.waml.io.model.action.Action;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import static java.lang.ClassLoader.getSystemResourceAsStream;
import static org.junit.Assert.assertEquals;

public class AlertActionSerializerIT extends SerializerBase {

    @Test
    public void alertActionIsSerialized() throws Exception {
        String testFileName = "alert-action.yaml";
        InputStream alertAction = getSystemResourceAsStream(getBasePath() + "/" + testFileName);
        Action action = mapper.readValue(alertAction, Action.class);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        mapper.writeValue(outputStream, action);

        assertEquals(IOUtils.toString(getSystemResourceAsStream(getBasePath() + "/" + testFileName), "UTF-8"), outputStream.toString("UTF-8"));
    }

    @Test
    public void alertActionShortNotationIsSerialized() throws Exception {
        String testFileName = "alert-action-short-notation.yaml";
        InputStream alertAction = getSystemResourceAsStream(getBasePath() + "/" + testFileName);
        Action action = mapper.readValue(alertAction, Action.class);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        mapper.writeValue(outputStream, action);

        assertEquals(IOUtils.toString(getSystemResourceAsStream(getBasePath() + "/" + testFileName), "UTF-8"), outputStream.toString("UTF-8"));
    }

}
