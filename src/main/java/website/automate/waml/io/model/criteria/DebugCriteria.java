package website.automate.waml.io.model.criteria;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DebugCriteria implements Criteria {

  private static final String DEFAULT_CRITERION_NAME = "msg";
  
  private String msg;
  
  private String verbosity;
  
  public DebugCriteria(@JsonProperty("msg") String msg, 
      @JsonProperty("verbosity") String verbosity){
    this(msg);
    this.verbosity = verbosity;
  }
  
  public DebugCriteria(String msg){
    super();
    this.msg = msg;
  }
  
  @Override
  public boolean canBeShortNotated() {
    return verbosity == null;
  }

  @Override
  public String getDefaultCriterionName() {
    return DEFAULT_CRITERION_NAME;
  }

  @Override
  public Object getDefaultCriterionValue() {
    return getMsg();
  }

  public String getMsg() {
    return msg;
  }

  public String getVerbosity() {
    return verbosity;
  }
}
