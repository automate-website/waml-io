package website.automate.waml.io.serializer;

import website.automate.waml.io.WamlConfig;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class SerializerBase {

    protected ObjectMapper mapper = WamlConfig.getInstance().getMapper();
    
    protected String getBasePath(){
        return "./website/automate/waml/io/serializer";
    }
}
