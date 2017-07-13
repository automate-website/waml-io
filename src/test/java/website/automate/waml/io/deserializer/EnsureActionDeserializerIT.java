package website.automate.waml.io.deserializer;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import website.automate.waml.io.model.action.Action;
import website.automate.waml.io.model.action.EnsureAction;
import static java.lang.ClassLoader.getSystemResourceAsStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class EnsureActionDeserializerIT extends DeserializerBase {

    @Test
    public void ensureActionIsDeserialized() throws JsonParseException, JsonMappingException, IOException{
        InputStream ensureAction = getSystemResourceAsStream(getBasePath() + "/ensure-action.yaml");
        Action action = mapper.readValue(ensureAction, Action.class);
        
        assertNotNull(action);
        assertTrue(action instanceof EnsureAction);
        EnsureAction actualEnsureAction = EnsureAction.class.cast(action);
        assertThat(actualEnsureAction.getEnsure().getSelector(), is("a.sign-up"));
        assertThat(actualEnsureAction.getEnsure().getText(), is("Join now for free!"));
        assertThat(actualEnsureAction.getWhen(), is("${isDesktop}"));
        assertThat(actualEnsureAction.getTimeout(), is("100"));
        assertThat(actualEnsureAction.getInvert(), is("true"));
        assertThat(actualEnsureAction.getEnsure().getValue(), is("val"));
    }
    
    @Test
    public void ensureActionShortNotationIsDeserialized() throws JsonParseException, JsonMappingException, IOException{
        InputStream ensureAction = getSystemResourceAsStream(getBasePath() + "/ensure-action-short-notation.yaml");
        Action action = mapper.readValue(ensureAction, Action.class);
        
        assertNotNull(action);
        assertTrue(action instanceof EnsureAction);
        EnsureAction actualEnsureAction = EnsureAction.class.cast(action);
        assertThat(actualEnsureAction.getEnsure().getSelector(), is("a.sign-up"));
    }
    
    @Test
    public void ensureActionParentIsDeserialized() throws JsonParseException, JsonMappingException, IOException{
        InputStream ensureAction = getSystemResourceAsStream(getBasePath() + "/ensure-action-parent.yaml");
        Action action = mapper.readValue(ensureAction, Action.class);
        
        assertNotNull(action);
        assertTrue(action instanceof EnsureAction);
        EnsureAction actualEnsureAction = EnsureAction.class.cast(action);
        assertThat(actualEnsureAction.getEnsure().getSelector(), is("a.sign-up"));
        assertThat(actualEnsureAction.getEnsure().getParent(), is("div.main"));
    }
}
