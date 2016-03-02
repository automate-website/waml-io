package website.automate.waml.io;

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
import static website.automate.waml.io.model.CriterionValue.of;

public class EnterActionDeserializerIT extends DeserializerBase {

    @Test
    public void enterActionIsDeserialized() throws JsonParseException, JsonMappingException, IOException{
        InputStream enterAction = getSystemResourceAsStream("./website/automate/waml/io/enter-action.yaml");
        Action action = mapper.readValue(enterAction, Action.class);
        
        assertNotNull(action);
        assertTrue(action instanceof EnterAction);
        EnterAction enterEnterAction = EnterAction.class.cast(action);
        assertThat(enterEnterAction.getSelector(), is("a.sign-up"));
        assertThat(enterEnterAction.getText(), is("Join now for free!"));
        assertThat(enterEnterAction.getWhen(), is("${isDesktop}"));
        assertThat(enterEnterAction.getUnless(), is("${isMobile}"));
        assertThat(enterEnterAction.getTimeout(), is(of(100)));
        assertThat(enterEnterAction.getValue(), is("val"));
    }
    
    @Test
    public void enterActionShortNotationIsDeserialized() throws JsonParseException, JsonMappingException, IOException{
        InputStream enterAction = getSystemResourceAsStream("./website/automate/waml/io/enter-action-short-notation.yaml");
        Action action = mapper.readValue(enterAction, Action.class);
        
        assertNotNull(action);
        assertTrue(action instanceof EnterAction);
        EnterAction actualEnterAction = EnterAction.class.cast(action);
        assertThat(actualEnterAction.getInput(), is(of("hello")));
    }
    
    @Test
    public void enterActionParentIsDeserialized() throws JsonParseException, JsonMappingException, IOException{
        InputStream enterAction = getSystemResourceAsStream("./website/automate/waml/io/enter-action-parent.yaml");
        Action action = mapper.readValue(enterAction, Action.class);
        
        assertNotNull(action);
        assertTrue(action instanceof EnterAction);
        EnterAction actualEnterAction = EnterAction.class.cast(action);
        assertThat(actualEnterAction.getSelector(), is("a.sign-up"));
        assertThat(actualEnterAction.getParent().getSelector(), is("div.main"));
        assertThat(actualEnterAction.getParent().getText(), is("some text"));
        assertThat(actualEnterAction.getParent().getValue(), is("some value"));
    }
}
