package website.automate.waml.io.deserializer;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import website.automate.waml.io.model.action.Action;
import website.automate.waml.io.model.action.OpenAction;
import static java.lang.ClassLoader.getSystemResourceAsStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class OpenActionDeserializerIT extends DeserializerBase {

    @Test
    public void openActionIsDeserialized() throws JsonParseException, JsonMappingException, IOException{
        InputStream openAction = getSystemResourceAsStream(getBasePath() + "/open-action.yaml");
        Action action = mapper.readValue(openAction, Action.class);
        
        assertNotNull(action);
        assertTrue(action instanceof OpenAction);
        OpenAction actualOpenAction = OpenAction.class.cast(action);
        assertThat(actualOpenAction.getUrl(), is("https://www.google.de"));
        assertThat(actualOpenAction.getWhen(), is("${isDesktop}"));
        assertThat(actualOpenAction.getUnless(), is("${isMobile}"));
    }
    
    @Test
    public void openActionShortNotationIsDeserialized() throws JsonParseException, JsonMappingException, IOException{
        InputStream openAction = getSystemResourceAsStream(getBasePath() + "/open-action-short-notation.yaml");
        Action action = mapper.readValue(openAction, Action.class);
        
        assertNotNull(action);
        assertTrue(action instanceof OpenAction);
        OpenAction actualOpenAction = OpenAction.class.cast(action);
        assertThat(actualOpenAction.getUrl(), is("https://www.google.de"));
    }
}
