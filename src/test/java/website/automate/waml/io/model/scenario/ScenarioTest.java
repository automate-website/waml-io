package website.automate.waml.io.model.scenario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class ScenarioTest {

  private static final String SCENARIO_NAME = "foo";

  @Test
  public void scenariosAreEqualWhenNameEqual() {
    Scenario left = createScenario(SCENARIO_NAME);
    Scenario right = createScenario(SCENARIO_NAME);

    assertEquals(left, right);
  }

  @Test
  public void scenarioHashCodesAreEqualWhenNameEqual() {
    Scenario left = createScenario(SCENARIO_NAME);
    Scenario right = createScenario(SCENARIO_NAME);

    assertEquals(left.hashCode(), right.hashCode());
  }

  @Test
  public void scenarioIsNotEqualToNull() {
    Scenario left = createScenario(SCENARIO_NAME);

    assertNotEquals(left, null);
  }

  @Test
  public void scenariosAreNotEqualWhenNameNotEqual() {
    Scenario left = createScenario(SCENARIO_NAME);
    Scenario right = createScenario("other");

    assertNotEquals(left, right);
  }

  @Test
  public void scenariosAreNotEqualWhenNameOfOneIsNull() {
    Scenario left = createScenario(SCENARIO_NAME);
    Scenario right = createScenario(null);

    assertNotEquals(left, right);
  }

  private Scenario createScenario(String name) {
    return new Scenario(name, null, null, null, null, null, null, null);
  }
}
