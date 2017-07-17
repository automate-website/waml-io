package website.automate.waml.io.reader;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

import website.automate.waml.io.WamlConfig;
import website.automate.waml.io.model.scenario.Scenario;

public class WamlReader {

    private ObjectMapper objectMapper = WamlConfig.getInstance().getMapper();

    public List<Scenario> read(InputStream inputStream) {
        List<Scenario> scenarios = new LinkedList<>();
        Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8.name());
        
        try {
            scanner.useDelimiter("\r?\n---\r?\n");
            
            while(scanner.hasNext()){
                String content = scanner.next();
                scenarios.add(objectMapper.readValue(content, Scenario.class));
            }
                
        } catch (Exception e) {
        	if(e instanceof WamlDeserializationException){
        		throw (WamlDeserializationException)e;
        	} else {
	            throw new WamlDeserializationException(
	                    "Unable to read the suite from the desired format.", e);
        	}
        } finally {
            scanner.close();
        }
        return scenarios;
    }
   
}
