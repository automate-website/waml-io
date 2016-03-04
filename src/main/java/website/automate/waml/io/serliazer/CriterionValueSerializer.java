package website.automate.waml.io.serliazer;

import java.io.IOException;

import website.automate.waml.io.model.CriterionValue;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class CriterionValueSerializer extends StdSerializer<CriterionValue> {

    private static final long serialVersionUID = 9018486705620294767L;

    public CriterionValueSerializer() {
        super(CriterionValue.class);
    }

    @Override
    public void serialize(CriterionValue wrappedValue, JsonGenerator generator,
            SerializerProvider provider) throws IOException {
        Object value = wrappedValue.getValue();
        generator.writeObject(value);
    }

}
