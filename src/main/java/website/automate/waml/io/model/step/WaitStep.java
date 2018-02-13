package website.automate.waml.io.model.step;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import website.automate.waml.io.model.criteria.WaitCriteria;
import website.automate.waml.io.report.StepReport;

public class WaitStep extends BasicStep {

  static final String TYPE_NAME = "wait";

  private WaitCriteria wait;

  @JsonCreator
  public WaitStep(@JsonProperty("when") String when,
      @JsonProperty("unless") String unless,
      @JsonProperty("register") String register, 
      @JsonProperty("timeout") String timeout,
      @JsonProperty("invert") String invert,
      @JsonProperty("wait") WaitCriteria wait,
      @JsonProperty("report") StepReport report) {
    super(when, unless, register, timeout, invert, report);
    this.wait = wait;
  }

  public WaitCriteria getWait() {
    return wait;
  }

  @Override
  public String getName() {
    return TYPE_NAME;
  }
}
