package website.automate.waml.io.deserializer;

import org.junit.Before;

import website.automate.waml.io.WamlConfig;
import website.automate.waml.io.deserializer.ActionDeserializer;
import website.automate.waml.io.model.action.Action;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public abstract class DeserializerBase {

    protected ObjectMapper mapper = WamlConfig.getInstance().getMapper();
    
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
