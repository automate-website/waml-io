package website.automate.waml.io.deserializer;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import website.automate.waml.io.model.action.Action;
import website.automate.waml.io.model.action.ClickAction;
import static java.lang.ClassLoader.getSystemResourceAsStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ClickActionDeserializerIT extends DeserializerBase {

    @Test
    public void clickActionIsDeserialized() throws JsonParseException, JsonMappingException, IOException{
        InputStream clickAction = getSystemResourceAsStream(getBasePath() + "/click-action.yaml");
        Action action = mapper.readValue(clickAction, Action.class);
        
        assertNotNull(action);
        assertTrue(action instanceof ClickAction);
        ClickAction actualClickAction = ClickAction.class.cast(action);
        assertThat(actualClickAction.getSelector(), is("a.sign-up"));
        assertThat(actualClickAction.getText(), is("Join now for free!"));
        assertThat(actualClickAction.getWhen(), is("${isDesktop}"));
        assertThat(actualClickAction.getUnless(), is("${isMobile}"));
        assertThat(actualClickAction.getTimeout(), is("100"));
        assertThat(actualClickAction.getValue(), is("val"));
    }
    
    @Test
    public void clickActionShortNotationIsDeserialized() throws JsonParseException, JsonMappingException, IOException{
        InputStream clickAction = getSystemResourceAsStream(getBasePath() + "/click-action-short-notation.yaml");
        Action action = mapper.readValue(clickAction, Action.class);
        
        assertNotNull(action);
        assertTrue(action instanceof ClickAction);
        ClickAction actualClickAction = ClickAction.class.cast(action);
        assertThat(actualClickAction.getSelector(), is("a.sign-up"));
    }
    
    @Test
    public void clickActionParentIsDeserialized() throws JsonParseException, JsonMappingException, IOException{
        InputStream clickAction = getSystemResourceAsStream(getBasePath() + "/click-action-parent.yaml");
        Action action = mapper.readValue(clickAction, Action.class);
        
        assertNotNull(action);
        assertTrue(action instanceof ClickAction);
        ClickAction actualClickAction = ClickAction.class.cast(action);
        assertThat(actualClickAction.getSelector(), is("a.sign-up"));
        assertThat(actualClickAction.getParent().getSelector(), is("div.main"));
        assertThat(actualClickAction.getParent().getText(), is("some text"));
        assertThat(actualClickAction.getParent().getValue(), is("some value"));
    }
}
