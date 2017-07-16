package website.automate.waml.io.model.criteria;

public class IncludeCriteria implements Criteria {

  private static final String DEFAULT_CRITERION_NAME = "scenario";
  
  private String scenario;
  
  public IncludeCriteria(String scenario){
    super();
    this.scenario = scenario;
  }

  public String getScenario() {
    return scenario;
  }

  @Override
  public boolean canBeShortNotated() {
    return true;
  }

  @Override
  public String getDefaultCriterionName() {
    return DEFAULT_CRITERION_NAME;
  }

  @Override
  public String getDefaultCriterionValue() {
    return scenario;
  }
}
