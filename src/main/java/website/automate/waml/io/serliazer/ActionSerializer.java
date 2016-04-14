package website.automate.waml.io.serliazer;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import website.automate.waml.io.model.ActionType;
import website.automate.waml.io.model.action.Action;
import website.automate.waml.io.model.action.ClickAction;
import website.automate.waml.io.model.action.EnsureAction;
import website.automate.waml.io.model.action.EnterAction;
import website.automate.waml.io.model.action.IncludeAction;
import website.automate.waml.io.model.action.MoveAction;
import website.automate.waml.io.model.action.OpenAction;
import website.automate.waml.io.model.action.StoreAction;
import website.automate.waml.io.model.action.WaitAction;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ResolvableSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class ActionSerializer extends StdSerializer<Action> implements ResolvableSerializer {

    private static final long serialVersionUID = 7861146712268855092L;

    private Map<Class<? extends Action>, ActionType> registry = new HashMap<>();
    
    @SuppressWarnings("rawtypes")
    private final JsonSerializer defaultSerializer;
    
    @SuppressWarnings("rawtypes") 
    public ActionSerializer(JsonSerializer defaultSerializer) {
        super(Action.class);
        this.defaultSerializer = defaultSerializer;
        
        registerAction(ClickAction.class, ActionType.CLICK);
        registerAction(EnsureAction.class, ActionType.ENSURE);
        registerAction(MoveAction.class, ActionType.MOVE);
        registerAction(EnterAction.class, ActionType.ENTER);
        registerAction(OpenAction.class, ActionType.OPEN);
        registerAction(WaitAction.class, ActionType.WAIT);
        registerAction(IncludeAction.class, ActionType.INCLUDE);
        registerAction(StoreAction.class, ActionType.STORE);
    }

    void registerAction(Class<? extends Action> actionClass, ActionType actionType) {
        registry.put(actionClass, actionType);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public void serialize(Action action, JsonGenerator generator,
            SerializerProvider provider) throws IOException {
        ActionType actionType = registry.get(action.getClass());
        generator.writeStartObject();
        generator.writeFieldName(actionType.getName());
        if(action.canBeShortNotated()){
            Object defaultCriterionValue = action.getDefaultCriterionValue();
            generator.writeObject(defaultCriterionValue);
        } else {
            defaultSerializer.serialize(action, generator, provider);
        }
        generator.writeEndObject();
    }

    @Override
    public void resolve(SerializerProvider provider)
            throws JsonMappingException {
        ((ResolvableSerializer) defaultSerializer).resolve(provider);
    }

}
