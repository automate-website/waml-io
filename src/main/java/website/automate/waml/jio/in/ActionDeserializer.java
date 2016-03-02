package website.automate.waml.jio.in;

import static java.util.Collections.singletonMap;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import website.automate.waml.jio.model.ActionType;
import website.automate.waml.jio.model.action.Action;
import website.automate.waml.jio.model.action.ClickAction;
import website.automate.waml.jio.model.action.EnsureAction;
import website.automate.waml.jio.model.action.EnterAction;
import website.automate.waml.jio.model.action.MoveAction;
import website.automate.waml.jio.model.action.OpenAction;
import website.automate.waml.jio.model.action.WaitAction;

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

    private Map<String, Class<? extends Action>> registry = new HashMap<>();

    protected ActionDeserializer() {
        super(Action.class);
        registerAction(ActionType.CLICK.getName(), ClickAction.class);
        registerAction(ActionType.ENSURE.getName(), EnsureAction.class);
        registerAction(ActionType.MOVE.getName(), MoveAction.class);
        registerAction(ActionType.ENTER.getName(), EnterAction.class);
        registerAction(ActionType.OPEN.getName(), OpenAction.class);
        registerAction(ActionType.WAIT.getName(), WaitAction.class);
    }

    void registerAction(String attributeKey, Class<? extends Action> actionType) {
        registry.put(attributeKey, actionType);
    }

    @Override
    public Action deserialize(JsonParser jsonParser,
            DeserializationContext deserializationContext) throws IOException,
            JsonProcessingException {
        ObjectMapper mapper = (ObjectMapper) jsonParser.getCodec();
        ObjectNode root = (ObjectNode) mapper.readTree(jsonParser);

        Class<? extends Action> animalClass = null;
        Iterator<Entry<String, JsonNode>> elementsIterator = root.fields();
        String key = null;
        while (elementsIterator.hasNext()) {
            Entry<String, JsonNode> element = elementsIterator.next();
            String name = element.getKey();
            if (registry.containsKey(name)) {
                animalClass = registry.get(name);
                key = name;
                break;
            }
        }

        if (animalClass == null){
            return null;
        }
        
        JsonNode object = root.get(key);
        if (object.isTextual()
                || !object.isObject()) {
            ActionType actionType = ActionType.findByName(key);
            JsonNode wrapper = new ObjectNode(JsonNodeFactory.instance,
                    singletonMap(actionType.getDefaultCriteriaType().getName(),
                            object));
            return mapper.convertValue(wrapper, animalClass);
        }
        
        return mapper.convertValue(root.get(key), animalClass);
    }
}
