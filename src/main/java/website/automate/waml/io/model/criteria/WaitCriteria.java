package website.automate.waml.io.model.criteria;

public class WaitCriteria implements Criteria {

  private static final String DEFAULT_CRITERION_NAME = "time";
  
  private String time;
  
  public String getTime() {
      return time;
  }

  public void setTime(String time) {
      this.time = time;
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
    return time;
  }

}
