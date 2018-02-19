package website.automate.waml.io;

import website.automate.waml.io.deserializer.ActionDeserializer;
import website.automate.waml.io.model.action.Action;
import website.automate.waml.io.serliazer.WamlSerializerModifier;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator.Feature;

public class WamlConfig {
    
    private static final String MODULE_NAME = "waml-io";

    private static final WamlConfig INSTANCE = new WamlConfig();
    
    private ObjectMapper mapper = createMapper();
    
    public static WamlConfig getInstance(){
        return INSTANCE;
    }
    
    private ObjectMapper createMapper(){
        SimpleModule module = new SimpleModule(MODULE_NAME, Version.unknownVersion());
        module.addDeserializer(Action.class, new ActionDeserializer()); 
        module.setSerializerModifier(new WamlSerializerModifier());

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory().enable(Feature.MINIMIZE_QUOTES));  
        mapper.registerModule(module);
        mapper.setSerializationInclusion(Include.NON_NULL);
        return mapper;
    }
    
    public ObjectMapper getMapper(){
        return mapper;
    }
}
