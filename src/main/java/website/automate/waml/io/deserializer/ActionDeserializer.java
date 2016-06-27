package website.automate.waml.io.deserializer;

import static java.text.MessageFormat.format;
import static java.util.Collections.singletonMap;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

import website.automate.waml.io.model.ActionType;
import website.automate.waml.io.model.CriterionType;
import website.automate.waml.io.model.action.Action;
import website.automate.waml.io.model.action.StoreAction;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ActionDeserializer extends StdDeserializer<Action> {

    private static final long serialVersionUID = 8037140456765531389L;

    public ActionDeserializer() {
        super(Action.class);
    }

    @Override
    public Action deserialize(JsonParser jsonParser,
            DeserializationContext deserializationContext) throws IOException,
            JsonProcessingException {
        ObjectMapper mapper = (ObjectMapper) jsonParser.getCodec();
        ObjectNode root = (ObjectNode) mapper.readTree(jsonParser);

        Class<? extends Action> actionClass = null;
        Iterator<Entry<String, JsonNode>> elementsIterator = root.fields();
        String key = null;
        while (elementsIterator.hasNext()) {
            Entry<String, JsonNode> element = elementsIterator.next();
            String name = element.getKey();
            if(elementsIterator.hasNext()){
                String anotherName = elementsIterator.next().getKey();
                throw new TooManyActionsException(format("Single step name expected, but found at least: {0}, {1}", name, anotherName));
            }
            ActionType actionType = ActionType.findByName(name);
            if (actionType == null){
                throw new UnknownActionException(format("Unknown step {0}.", name));
            }
            
            actionClass = actionType.getClazz();
            key = name;
        }
        
        JsonNode object = root.get(key);
        if (isShortNotated(actionClass, object)) {
            ActionType actionType = ActionType.findByName(key);
            JsonNode wrapper = new ObjectNode(JsonNodeFactory.instance,
                    singletonMap(actionType.getDefaultCriteriaType().getName(),
                            object));
            object = wrapper;
        }
        
        return mapper.convertValue(object, actionClass);
    }
    
    private boolean isShortNotated(Class<? extends Action> actionClass, JsonNode object){
        if(object.isTextual()){
            return true;
        }
        if(actionClass == StoreAction.class){
            return !object.has(CriterionType.IF.getName())
                    && !object.has(CriterionType.UNLESS.getName())
                    && !object.has(CriterionType.VALUE.getName());
        }
        return !object.isObject();
    }
}
