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
        assertThat(actualClickAction.getClick().getSelector(), is("a.sign-up"));
        assertThat(actualClickAction.getClick().getText(), is("Join now for free!"));
        assertThat(actualClickAction.getWhen(), is("${isDesktop}"));
        assertThat(actualClickAction.getTimeout(), is("100"));
        assertThat(actualClickAction.getClick().getValue(), is("val"));
    }
    
    @Test
    public void clickActionShortNotationIsDeserialized() throws JsonParseException, JsonMappingException, IOException{
        InputStream clickAction = getSystemResourceAsStream(getBasePath() + "/click-action-short-notation.yaml");
        Action action = mapper.readValue(clickAction, Action.class);
        
        assertNotNull(action);
        assertTrue(action instanceof ClickAction);
        ClickAction actualClickAction = ClickAction.class.cast(action);
        assertThat(actualClickAction.getClick().getSelector(), is("a.sign-up"));
    }
    
    @Test
    public void clickActionStoreElementIsDeserialized() throws JsonParseException, JsonMappingException, IOException{
        InputStream clickAction = getSystemResourceAsStream(getBasePath() + "/click-action-store-element.yaml");
        Action action = mapper.readValue(clickAction, Action.class);
        
        assertNotNull(action);
        assertTrue(action instanceof ClickAction);
        ClickAction actualClickAction = ClickAction.class.cast(action);
        assertThat(actualClickAction.getClick().getSelector(), is("a.sign-up"));
        assertThat(actualClickAction.getClick().getText(), is("Join now for free!"));
    }
    
    @Test(expected=UnknownActionException.class)
    public void unknownActionCausesException() throws JsonParseException, JsonMappingException, IOException{
        InputStream clickAction = getSystemResourceAsStream(getBasePath() + "/unknown-action.yaml");
        mapper.readValue(clickAction, Action.class);
    }
    
    @Test(expected=UnknownCriterionException.class)
    public void unknownCriterionCausesException() throws JsonParseException, JsonMappingException, IOException{
        InputStream clickAction = getSystemResourceAsStream(getBasePath() + "/unknown-criterion.yaml");
        mapper.readValue(clickAction, Action.class);
    }
    
    @Test(expected=TooManyActionsException.class)
    public void multipleStepNamesCauseException() throws JsonParseException, JsonMappingException, IOException{
        InputStream clickAction = getSystemResourceAsStream(getBasePath() + "/too-many-steps.yaml");
        mapper.readValue(clickAction, Action.class);
    }
    
    @Test
    public void clickActionParentIsDeserialized() throws JsonParseException, JsonMappingException, IOException{
        InputStream clickAction = getSystemResourceAsStream(getBasePath() + "/click-action-parent.yaml");
        Action action = mapper.readValue(clickAction, Action.class);
        
        assertNotNull(action);
        assertTrue(action instanceof ClickAction);
        ClickAction actualClickAction = ClickAction.class.cast(action);
        assertThat(actualClickAction.getClick().getSelector(), is("a.sign-up"));
        assertThat(actualClickAction.getClick().getParent(), is("div.main"));
    }
    
    @Test
    public void clickActionParentShortNotationIsDeserialized() throws JsonParseException, JsonMappingException, IOException{
        InputStream clickAction = getSystemResourceAsStream(getBasePath() + "/click-action-parent-short-notation.yaml");
        Action action = mapper.readValue(clickAction, Action.class);
        
        assertNotNull(action);
        assertTrue(action instanceof ClickAction);
        ClickAction actualClickAction = ClickAction.class.cast(action);
        assertThat(actualClickAction.getClick().getSelector(), is("a.sign-up"));
        assertThat(actualClickAction.getClick().getParent(), is("div.main"));
    }
}
