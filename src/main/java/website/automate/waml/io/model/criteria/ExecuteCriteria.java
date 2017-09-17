package website.automate.waml.io.model.criteria;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExecuteCriteria implements Criteria {

  private static final String DEFAULT_CRITERION_NAME = "script";
  
  private String script;
  
  private String local;
  
  public ExecuteCriteria(@JsonProperty("script") String script, 
      @JsonProperty("local") String local){
    this(script);
    this.local = local;
  }
  
  public ExecuteCriteria(String script){
    super();
    this.script = script;
  }
  
  @Override
  public boolean canBeShortNotated() {
    return local == null;
  }

  @Override
  public String getDefaultCriterionName() {
    return DEFAULT_CRITERION_NAME;
  }

  @Override
  public Object getDefaultCriterionValue() {
    return getScript();
  }

  public String getScript() {
    return script;
  }

  public String getLocal() {
    return local;
  }
}
