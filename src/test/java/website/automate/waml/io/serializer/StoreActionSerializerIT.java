package website.automate.waml.io.serializer;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import website.automate.waml.io.model.action.Action;
import static java.lang.ClassLoader.getSystemResourceAsStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StoreActionSerializerIT extends SerializerBase {

    @Test
    public void storeActionIsSerialized() throws Exception {
        String testFileName = "store-action.yaml";
        InputStream storeAction = getSystemResourceAsStream(getBasePath() + "/" + testFileName);
        Action action = mapper.readValue(storeAction, Action.class);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        mapper.writeValue(outputStream, action);

        assertThat(outputStream.toString("UTF-8"), is(IOUtils.toString(getSystemResourceAsStream(getBasePath() + "/" + testFileName), "UTF-8")));
    }

    @Test
    public void storeActionShortNotationIsSerialized() throws Exception {
        String testFileName = "store-action-short-notation.yaml";
        InputStream storeAction = getSystemResourceAsStream(getBasePath() + "/" + testFileName);
        Action action = mapper.readValue(storeAction, Action.class);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        mapper.writeValue(outputStream, action);

        assertThat(outputStream.toString("UTF-8"), is(IOUtils.toString(getSystemResourceAsStream(getBasePath() + "/" + testFileName), "UTF-8")));
    }
}
