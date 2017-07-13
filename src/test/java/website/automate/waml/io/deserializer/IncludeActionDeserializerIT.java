package website.automate.waml.io.deserializer;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import website.automate.waml.io.model.action.Action;
import website.automate.waml.io.model.action.IncludeAction;
import static java.lang.ClassLoader.getSystemResourceAsStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class IncludeActionDeserializerIT extends DeserializerBase {

    @Test
    public void includeActionIsDeserialized() throws JsonParseException, JsonMappingException, IOException{
        InputStream includeAction = getSystemResourceAsStream(getBasePath() + "/include-action.yaml");
        Action action = mapper.readValue(includeAction, Action.class);
        
        assertNotNull(action);
        assertTrue(action instanceof IncludeAction);
        IncludeAction actualIncludeAction = IncludeAction.class.cast(action);
        assertThat(actualIncludeAction.getInclude().getScenario(), is("included-scenario"));
        assertThat(actualIncludeAction.getWhen(), is("${isDesktop}"));
    }
    
    @Test
    public void includeActionShortNotationIsDeserialized() throws JsonParseException, JsonMappingException, IOException{
        InputStream includeAction = getSystemResourceAsStream(getBasePath() + "/include-action-short-notation.yaml");
        Action action = mapper.readValue(includeAction, Action.class);
        
        assertNotNull(action);
        assertTrue(action instanceof IncludeAction);
        IncludeAction actualIncludeAction = IncludeAction.class.cast(action);
        assertThat(actualIncludeAction.getInclude().getScenario(), is("included-scenario"));
    }
}
