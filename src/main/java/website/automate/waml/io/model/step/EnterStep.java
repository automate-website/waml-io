package website.automate.waml.io.model.step;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import website.automate.waml.io.model.criteria.EnterCriteria;
import website.automate.waml.io.report.StepReport;

public class EnterStep extends BasicStep {
  
  static final String TYPE_NAME = "enter";
  
  private EnterCriteria enter;
  
  @JsonCreator
  public EnterStep(@JsonProperty("when") String when,
      @JsonProperty("unless") String unless,
      @JsonProperty("register") String register, 
      @JsonProperty("timeout") String timeout,
      @JsonProperty("invert") String invert,
      @JsonProperty("enter") EnterCriteria enter,
      @JsonProperty("report") StepReport report){
    super(when, unless, register, timeout, invert, report);
    this.enter = enter;
  }

  public EnterCriteria getEnter() {
    return enter;
  }

  @Override
  public String getName() {
    return TYPE_NAME;
  }
}
