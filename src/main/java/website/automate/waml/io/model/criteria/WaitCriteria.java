package website.automate.waml.io.model.criteria;

public class WaitCriteria implements Criteria {

  private static final String DEFAULT_CRITERION_NAME = "time";
  
  public WaitCriteria(String time){
    super();
    this.time = time;
  }
  
  public WaitCriteria(int number){
    this(Integer.toString(number));
  }
  
  private String time;
  
  public String getTime() {
      return time;
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
