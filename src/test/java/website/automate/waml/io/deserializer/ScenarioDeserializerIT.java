package website.automate.waml.io.deserializer;

import static java.lang.ClassLoader.getSystemResourceAsStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import website.automate.waml.io.model.Scenario;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class ScenarioDeserializerIT extends DeserializerBase {

    @Test
    public void scenarioIsDeserialized() throws JsonParseException, JsonMappingException, IOException{
        InputStream scenarioStream = getSystemResourceAsStream(getBasePath() + "/scenario.yaml");
        Scenario scenario = mapper.readValue(scenarioStream, Scenario.class);
        
        assertNotNull(scenario);
        assertThat(scenario.getName(), is("scenario-name"));
        assertThat(scenario.getDescription(), is("scenario-description"));
        assertThat(scenario.getUnless(), is("${isMobile}"));
        assertThat(scenario.getWhen(), is("${isDesktop}"));
        assertThat(scenario.getTimeout(), is("100"));
        assertThat(scenario.getMeta(), is("data"));
    }
}
