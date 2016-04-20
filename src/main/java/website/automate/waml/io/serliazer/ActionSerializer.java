package website.automate.waml.io.serliazer;


import java.io.IOException;

import website.automate.waml.io.model.ActionType;
import website.automate.waml.io.model.action.Action;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ResolvableSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class ActionSerializer extends StdSerializer<Action> implements ResolvableSerializer {

    private static final long serialVersionUID = 7861146712268855092L;
    
    @SuppressWarnings("rawtypes")
    private final JsonSerializer defaultSerializer;
    
    @SuppressWarnings("rawtypes") 
    public ActionSerializer(JsonSerializer defaultSerializer) {
        super(Action.class);
        this.defaultSerializer = defaultSerializer;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public void serialize(Action action, JsonGenerator generator,
            SerializerProvider provider) throws IOException {
        ActionType actionType = ActionType.findByClazz(action.getClass());
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
