package website.automate.waml.io.deserializer;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import website.automate.waml.io.model.action.Action;
import website.automate.waml.io.model.action.MoveAction;
import static java.lang.ClassLoader.getSystemResourceAsStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static website.automate.waml.io.model.CriterionValue.of;

public class MoveActionDeserializerIT extends DeserializerBase {

    @Test
    public void moveActionIsDeserialized() throws JsonParseException, JsonMappingException, IOException{
        InputStream moveAction = getSystemResourceAsStream(getBasePath() + "/move-action.yaml");
        Action action = mapper.readValue(moveAction, Action.class);
        
        assertNotNull(action);
        assertTrue(action instanceof MoveAction);
        MoveAction moveMoveAction = MoveAction.class.cast(action);
        assertThat(moveMoveAction.getSelector(), is("a.sign-up"));
        assertThat(moveMoveAction.getText(), is("Join now for free!"));
        assertThat(moveMoveAction.getWhen(), is(of("${isDesktop}")));
        assertThat(moveMoveAction.getUnless(), is(of("${isMobile}")));
        assertThat(moveMoveAction.getTimeout(), is(of(100)));
        assertThat(moveMoveAction.getValue(), is("val"));
    }
    
    @Test
    public void moveActionShortNotationIsDeserialized() throws JsonParseException, JsonMappingException, IOException{
        InputStream moveAction = getSystemResourceAsStream(getBasePath() + "/move-action-short-notation.yaml");
        Action action = mapper.readValue(moveAction, Action.class);
        
        assertNotNull(action);
        assertTrue(action instanceof MoveAction);
        MoveAction actualMoveAction = MoveAction.class.cast(action);
        assertThat(actualMoveAction.getSelector(), is("a.sign-up"));
    }
    
    @Test
    public void moveActionParentIsDeserialized() throws JsonParseException, JsonMappingException, IOException{
        InputStream moveAction = getSystemResourceAsStream(getBasePath() + "/move-action-parent.yaml");
        Action action = mapper.readValue(moveAction, Action.class);
        
        assertNotNull(action);
        assertTrue(action instanceof MoveAction);
        MoveAction actualMoveAction = MoveAction.class.cast(action);
        assertThat(actualMoveAction.getSelector(), is("a.sign-up"));
        assertThat(actualMoveAction.getParent().getSelector(), is("div.main"));
        assertThat(actualMoveAction.getParent().getText(), is("some text"));
        assertThat(actualMoveAction.getParent().getValue(), is("some value"));
    }
}
