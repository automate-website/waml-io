package website.automate.waml.io.model.step;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import website.automate.waml.io.model.criteria.FilterCriteria;

public class ClickStep extends BasicStep {

  static final String TYPE_NAME = "click";
  
  private FilterCriteria click;
  
  @JsonCreator
  public ClickStep(@JsonProperty("when") String when,
      @JsonProperty("register") String register, 
      @JsonProperty("timeout") String timeout,
      @JsonProperty("invert") String invert,
      @JsonProperty("click") FilterCriteria click){
    super(when, register, timeout, invert);
    this.click = click;
  }

  public FilterCriteria getClick() {
    return click;
  }
}
