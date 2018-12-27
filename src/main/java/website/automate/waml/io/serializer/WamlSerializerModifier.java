package website.automate.waml.io.serializer;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import website.automate.waml.io.model.main.criteria.Criteria;

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
