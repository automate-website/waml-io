package website.automate.waml.io.deserializer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import website.automate.waml.io.model.CriterionValue;
import website.automate.waml.io.model.action.Action;
import website.automate.waml.io.model.action.StoreAction;
import static java.lang.ClassLoader.getSystemResourceAsStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static website.automate.waml.io.model.CriterionValue.of;

public class StoreActionDeserializerIT extends DeserializerBase {

    @Test
    public void storeActionIsDeserialized() throws JsonParseException, JsonMappingException, IOException{
        InputStream storeAction = getSystemResourceAsStream("./website/automate/waml/io/store-action.yaml");
        Action action = mapper.readValue(storeAction, Action.class);
        
        assertNotNull(action);
        assertTrue(action instanceof StoreAction);
        StoreAction actualStoreAction = StoreAction.class.cast(action);
        assertThat(actualStoreAction.getWhen(), is("${isDesktop}"));
        assertThat(actualStoreAction.getUnless(), is("${isMobile}"));
        Map<String, CriterionValue> value = actualStoreAction.getValue();
        assertThat(value.get("keyA"), is(of("valueA")));
        assertThat(value.get("keyB"), is(of("valueB")));
    }
    
    @Test
    public void storeActionShortNotationIsDeserialized() throws JsonParseException, JsonMappingException, IOException{
        InputStream storeAction = getSystemResourceAsStream("./website/automate/waml/io/store-action-short-notation.yaml");
        Action action = mapper.readValue(storeAction, Action.class);
        
        assertNotNull(action);
        assertTrue(action instanceof StoreAction);
        StoreAction actualStoreAction = StoreAction.class.cast(action);
        Map<String, CriterionValue> value = actualStoreAction.getValue();
        assertThat(value.get("keyA"), is(of("valueA")));
        assertThat(value.get("keyB"), is(of("valueB")));
    }
}
