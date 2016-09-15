package website.automate.waml.io.serliazer;


import java.io.IOException;

import website.automate.waml.io.model.action.ParentCriteria;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ResolvableSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class ParentCriteriaSerializer extends StdSerializer<ParentCriteria> implements ResolvableSerializer {

    private static final long serialVersionUID = 7861146712268855092L;
    
    @SuppressWarnings("rawtypes")
    private final JsonSerializer defaultSerializer;
    
    @SuppressWarnings("rawtypes") 
    public ParentCriteriaSerializer(JsonSerializer defaultSerializer) {
        super(ParentCriteria.class);
        this.defaultSerializer = defaultSerializer;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public void serialize(ParentCriteria parentCriteria, JsonGenerator generator,
            SerializerProvider provider) throws IOException {
        if(parentCriteria.canBeShortNotated()){
            Object defaultCriterionValue = parentCriteria.getDefaultCriterionValue();
            generator.writeObject(defaultCriterionValue);
        } else {
            defaultSerializer.serialize(parentCriteria, generator, provider);
        }
    }

    @Override
    public void resolve(SerializerProvider provider)
            throws JsonMappingException {
        ((ResolvableSerializer) defaultSerializer).resolve(provider);
    }

}
