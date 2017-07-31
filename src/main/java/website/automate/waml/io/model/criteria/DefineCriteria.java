package website.automate.waml.io.model.criteria;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;

public class DefineCriteria implements Criteria {

  private static final String DEFAULT_CRITERION_NAME = "facts";
  
  private Map<String, Object> facts;
  
  @JsonCreator
  public DefineCriteria(Map<String, Object> facts){
    super();
    this.facts = facts;
  }
  
  public Map<String, Object> getFacts() {
      return facts;
  }

  @Override
  public boolean canBeShortNotated(){
    return true;
  }

  @Override
  public String getDefaultCriterionName() {
    return DEFAULT_CRITERION_NAME;
  }

  @Override
  public Map<String, Object> getDefaultCriterionValue() {
    return getFacts();
  }
}
