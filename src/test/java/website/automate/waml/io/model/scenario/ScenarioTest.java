package website.automate.waml.io.model.scenario;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ScenarioTest {

  private static final String SCENARIO_NAME = "foo";
  
  @Test
  public void scenariosAreEqualWhenNameEquals(){
    Scenario left = createScenario(SCENARIO_NAME);
    Scenario right = createScenario(SCENARIO_NAME);
    
    assertEquals(left, right);
  }
  
  @Test
  public void scnearioHashCodesAreEqualWhenNameEquals(){
    Scenario left = createScenario(SCENARIO_NAME);
    Scenario right = createScenario(SCENARIO_NAME);
    
    assertEquals(left.hashCode(), right.hashCode());
  }
  
  private Scenario createScenario(String name){
    return new Scenario(name, null, null, null, null, null, null);
  }
}
