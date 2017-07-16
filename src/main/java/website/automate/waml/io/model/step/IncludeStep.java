package website.automate.waml.io.model.step;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import website.automate.waml.io.model.criteria.IncludeCriteria;

public class IncludeStep extends BasicStep {

  static final String TYPE_NAME = "include";
  
  private IncludeCriteria include;

  @JsonCreator
  public IncludeStep(@JsonProperty("when") String when,
      @JsonProperty("register") String register, 
      @JsonProperty("timeout") String timeout,
      @JsonProperty("invert") String invert,
      @JsonProperty("include") IncludeCriteria include){
    super(when, register, timeout, invert);
    this.include = include;
  }
  
  public IncludeCriteria getInclude() {
    return include;
  }

  public void setInclude(IncludeCriteria include) {
    this.include = include;
  }
}
