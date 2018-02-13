package website.automate.waml.io.model.step;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import website.automate.waml.io.model.criteria.DebugCriteria;
import website.automate.waml.io.report.StepReport;

public class DebugStep extends BasicStep {

  static final String TYPE_NAME = "debug";
  
  private DebugCriteria debug;

  @JsonCreator
  public DebugStep(@JsonProperty("when") String when,
      @JsonProperty("unless") String unless,
      @JsonProperty("register") String register, 
      @JsonProperty("timeout") String timeout,
      @JsonProperty("invert") String invert,
      @JsonProperty("debug") DebugCriteria debug,
      @JsonProperty("report") StepReport report){
    super(when, unless, register, timeout, invert, report);
    this.debug = debug;
  }
  
  public DebugCriteria getDebug() {
    return debug;
  }

  @Override
  public String getName() {
    return TYPE_NAME;
  }
}
