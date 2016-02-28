package website.automate.waml.jio.in;

import org.junit.Before;

import website.automate.waml.jio.model.action.Action;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public abstract class ActionDeserializerBase {

    protected ObjectMapper mapper;
    
    @Before
    public void init(){
        ActionDeserializer deserializer =  new ActionDeserializer();  
        SimpleModule module =  
          new SimpleModule("PolymorphicActionDeserializerModule",  
              Version.unknownVersion());  
        module.addDeserializer(Action.class, deserializer);  
          
        mapper = new ObjectMapper(new YAMLFactory());  
        mapper.registerModule(module);
    }
}
