package website.automate.waml.io;

import java.io.OutputStream;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import website.automate.waml.io.model.scenario.Scenario;

public class WamlWriter {
	
	private ObjectMapper objectMapper = WamlConfig.getInstance().getMapper();
	
	public void write(OutputStream scenarioStream, List<Scenario> scenarios){
        try {
            for(Scenario scenario : scenarios){
                objectMapper.writeValue(scenarioStream, scenario);
            }
        } catch (Exception e) {
            throw new WamlSerializationException("Unable to write the suite to desired format.", e);
        }
	}
}
