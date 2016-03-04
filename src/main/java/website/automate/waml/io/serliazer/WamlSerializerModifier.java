package website.automate.waml.io.serliazer;

import website.automate.waml.io.model.action.Action;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;

public class WamlSerializerModifier extends BeanSerializerModifier {

    @Override public JsonSerializer<?> modifySerializer(SerializationConfig config, BeanDescription beanDesc, JsonSerializer<?> serializer){
      if (Action.class.isAssignableFrom(beanDesc.getBeanClass())){
          return new ActionSerializer(serializer);
      }
      return serializer;
    }
}
