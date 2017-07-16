package website.automate.waml.io.model.step;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import website.automate.waml.io.model.criteria.OpenCriteria;

public class OpenStep extends BasicStep {

  static final String TYPE_NAME = "open";
  
  private OpenCriteria open;

  @JsonCreator
  public OpenStep(@JsonProperty("when") String when,
      @JsonProperty("register") String register, 
      @JsonProperty("timeout") String timeout,
      @JsonProperty("invert") String invert,
      @JsonProperty("open") OpenCriteria open){
    super(when, register, timeout, invert);
    this.open = open;
  }
  
  public OpenCriteria getOpen() {
    return open;
  }
}
