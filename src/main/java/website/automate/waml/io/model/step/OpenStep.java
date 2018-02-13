package website.automate.waml.io.model.step;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import website.automate.waml.io.model.criteria.OpenCriteria;
import website.automate.waml.io.report.StepReport;

public class OpenStep extends BasicStep {

  static final String TYPE_NAME = "open";
  
  private OpenCriteria open;

  @JsonCreator
  public OpenStep(@JsonProperty("when") String when,
      @JsonProperty("unless") String unless,
      @JsonProperty("register") String register, 
      @JsonProperty("timeout") String timeout,
      @JsonProperty("invert") String invert,
      @JsonProperty("open") OpenCriteria open,
      @JsonProperty("report") StepReport report){
    super(when, unless, register, timeout, invert, report);
    this.open = open;
  }
  
  public OpenCriteria getOpen() {
    return open;
  }

  @Override
  public String getName() {
    return TYPE_NAME;
  }
}
