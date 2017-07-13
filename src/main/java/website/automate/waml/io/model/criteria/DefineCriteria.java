package website.automate.waml.io.model.criteria;

import java.util.Collections;
import java.util.Map;

public class DefineCriteria implements Criteria {

  private static final String DEFAULT_CRITERION_NAME = "facts";
  
  private Map<String, String> facts = Collections.emptyMap();
  
  public Map<String, String> getFacts() {
      return facts;
  }

  public void setFacts(Map<String, String> facts) {
      this.facts = facts;
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
  public Map<String, String> getDefaultCriterionValue() {
    return facts;
  }
}
