package website.automate.waml.io.serializer;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import website.automate.waml.io.model.action.Action;
import static java.lang.ClassLoader.getSystemResourceAsStream;
import static org.junit.Assert.assertEquals;

public class ClickActionSerializerIT extends SerializerBase {

    @Test
    public void clickActionIsSerialized() throws Exception {
        String testFileName = "click-action.yaml";
        InputStream clickAction = getSystemResourceAsStream(getBasePath() + "/" + testFileName);
        Action action = mapper.readValue(clickAction, Action.class);
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        mapper.writeValue(outputStream, action);
        
        assertEquals(IOUtils.toString(getSystemResourceAsStream(getBasePath() + "/" + testFileName), "UTF-8"), outputStream.toString("UTF-8"));
    }
    
    @Test
    public void clickActionStoreElementIsSerialized() throws Exception {
        String testFileName = "click-action-store-element.yaml";
        InputStream clickAction = getSystemResourceAsStream(getBasePath() + "/" + testFileName);
        Action action = mapper.readValue(clickAction, Action.class);
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        mapper.writeValue(outputStream, action);
        
        assertEquals(IOUtils.toString(getSystemResourceAsStream(getBasePath() + "/" + testFileName), "UTF-8"), outputStream.toString("UTF-8"));
    }
    
    @Test
    public void clickActionShortNotationIsSerialized() throws Exception {
        String testFileName = "click-action-short-notation.yaml";
        InputStream clickAction = getSystemResourceAsStream(getBasePath() + "/" + testFileName);
        Action action = mapper.readValue(clickAction, Action.class);
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        mapper.writeValue(outputStream, action);
        
        assertEquals(IOUtils.toString(getSystemResourceAsStream(getBasePath() + "/" + testFileName), "UTF-8"), outputStream.toString("UTF-8"));
    }
    
    @Test
    public void clickActionWithParentIsSerialized() throws Exception {
        String testFileName = "click-action-parent.yaml";
        InputStream clickAction = getSystemResourceAsStream(getBasePath() + "/" + testFileName);
        Action action = mapper.readValue(clickAction, Action.class);
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        mapper.writeValue(outputStream, action);
        
        assertEquals(IOUtils.toString(getSystemResourceAsStream(getBasePath() + "/" + testFileName), "UTF-8"), outputStream.toString("UTF-8"));
    }
    
    @Test
    public void clickActionWithParentShortNotationIsSerialized() throws Exception {
        String testFileName = "click-action-parent-short-notation.yaml";
        InputStream clickAction = getSystemResourceAsStream(getBasePath() + "/" + testFileName);
        Action action = mapper.readValue(clickAction, Action.class);
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        mapper.writeValue(outputStream, action);
        
        assertEquals(IOUtils.toString(getSystemResourceAsStream(getBasePath() + "/" + testFileName), "UTF-8"), outputStream.toString("UTF-8"));
    }
}
