package website.automate.waml.io.deserializer;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import website.automate.waml.io.model.action.Action;
import website.automate.waml.io.model.action.EnterAction;
import static java.lang.ClassLoader.getSystemResourceAsStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class EnterActionDeserializerIT extends DeserializerBase {

    @Test
    public void enterActionIsDeserialized() throws JsonParseException, JsonMappingException, IOException{
        InputStream enterAction = getSystemResourceAsStream(getBasePath() + "/enter-action.yaml");
        Action action = mapper.readValue(enterAction, Action.class);
        
        assertNotNull(action);
        assertTrue(action instanceof EnterAction);
        EnterAction enterEnterAction = EnterAction.class.cast(action);
        assertThat(enterEnterAction.getEnter().getSelector(), is("a.sign-up"));
        assertThat(enterEnterAction.getEnter().getText(), is("Join now for free!"));
        assertThat(enterEnterAction.getWhen(), is("${isDesktop}"));
        assertThat(enterEnterAction.getTimeout(), is("100"));
        assertThat(enterEnterAction.getEnter().getValue(), is("val"));
    }
    
    @Test
    public void enterActionShortNotationIsDeserialized() throws JsonParseException, JsonMappingException, IOException{
        InputStream enterAction = getSystemResourceAsStream(getBasePath() + "/enter-action-short-notation.yaml");
        Action action = mapper.readValue(enterAction, Action.class);
        
        assertNotNull(action);
        assertTrue(action instanceof EnterAction);
        EnterAction actualEnterAction = EnterAction.class.cast(action);
        assertThat(actualEnterAction.getEnter().getInput(), is("hello"));
    }
    
    @Test
    public void enterActionParentIsDeserialized() throws JsonParseException, JsonMappingException, IOException{
        InputStream enterAction = getSystemResourceAsStream(getBasePath() + "/enter-action-parent.yaml");
        Action action = mapper.readValue(enterAction, Action.class);
        
        assertNotNull(action);
        assertTrue(action instanceof EnterAction);
        EnterAction actualEnterAction = EnterAction.class.cast(action);
        assertThat(actualEnterAction.getEnter().getSelector(), is("a.sign-up"));
        assertThat(actualEnterAction.getEnter().getParent(), is("div.main"));
    }
}
