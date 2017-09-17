package website.automate.waml.io.model.step;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import website.automate.waml.io.model.criteria.EnterCriteria;

public class EnterStep extends BasicStep {
  
  static final String TYPE_NAME = "enter";
  
  private EnterCriteria enter;
  
  @JsonCreator
  public EnterStep(@JsonProperty("when") String when,
      @JsonProperty("unless") String unless,
      @JsonProperty("register") String register, 
      @JsonProperty("timeout") String timeout,
      @JsonProperty("invert") String invert,
      @JsonProperty("enter") EnterCriteria enter){
    super(when, unless, register, timeout, invert);
    this.enter = enter;
  }

  public EnterCriteria getEnter() {
    return enter;
  }
}
