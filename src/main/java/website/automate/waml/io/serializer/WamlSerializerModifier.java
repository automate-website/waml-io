package website.automate.waml.io.serializer;

import website.automate.waml.io.model.criteria.Criteria;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;

public class WamlSerializerModifier extends BeanSerializerModifier {

    @Override
    public JsonSerializer<?> modifySerializer(SerializationConfig config, BeanDescription beanDesc,
            JsonSerializer<?> serializer) {
        if (Criteria.class.isAssignableFrom(beanDesc.getBeanClass())) {
            return new CriteriaSerializer(serializer);
        }
        return serializer;
    }
}
