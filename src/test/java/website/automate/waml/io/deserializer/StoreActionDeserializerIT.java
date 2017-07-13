package website.automate.waml.io.deserializer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import website.automate.waml.io.model.action.Action;
import website.automate.waml.io.model.action.DefineAction;
import static java.lang.ClassLoader.getSystemResourceAsStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class StoreActionDeserializerIT extends DeserializerBase {

    @Test
    public void storeActionIsDeserialized() throws JsonParseException, JsonMappingException, IOException{
        InputStream storeAction = getSystemResourceAsStream(getBasePath() + "/store-action.yaml");
        Action action = mapper.readValue(storeAction, Action.class);
        
        assertNotNull(action);
        assertTrue(action instanceof DefineAction);
        DefineAction actualStoreAction = DefineAction.class.cast(action);
        assertThat(actualStoreAction.getWhen(), is("${isDesktop}"));
        Map<String, String> value = actualStoreAction.getDefine().getFacts();
        assertThat(value.get("keyA"), is("valueA"));
        assertThat(value.get("keyB"), is("valueB"));
    }
    
    @Test
    public void storeActionShortNotationIsDeserialized() throws JsonParseException, JsonMappingException, IOException{
        InputStream storeAction = getSystemResourceAsStream(getBasePath() + "/store-action-short-notation.yaml");
        Action action = mapper.readValue(storeAction, Action.class);
        
        assertNotNull(action);
        assertTrue(action instanceof DefineAction);
        DefineAction actualStoreAction = DefineAction.class.cast(action);
        Map<String, String> value = actualStoreAction.getDefine().getFacts();
        assertThat(value.get("keyA"), is("valueA"));
        assertThat(value.get("keyB"), is("valueB"));
    }
}
