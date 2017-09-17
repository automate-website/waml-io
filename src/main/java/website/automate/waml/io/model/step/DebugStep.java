package website.automate.waml.io.model.step;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import website.automate.waml.io.model.criteria.DebugCriteria;

public class DebugStep extends BasicStep {

  static final String TYPE_NAME = "debug";
  
  private DebugCriteria debug;

  @JsonCreator
  public DebugStep(@JsonProperty("when") String when,
      @JsonProperty("unless") String unless,
      @JsonProperty("register") String register, 
      @JsonProperty("timeout") String timeout,
      @JsonProperty("invert") String invert,
      @JsonProperty("debug") DebugCriteria debug){
    super(when, unless, register, timeout, invert);
    this.debug = debug;
  }
  
  public DebugCriteria getDebug() {
    return debug;
  }
}
