package website.automate.waml.io.model.step;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import website.automate.waml.io.model.criteria.FilterCriteria;
import website.automate.waml.io.report.StepReport;

public class ClickStep extends BasicStep {

  static final String TYPE_NAME = "click";
  
  private FilterCriteria click;
  
  @JsonCreator
  public ClickStep(@JsonProperty("when") String when,
      @JsonProperty("unless") String unless,
      @JsonProperty("register") String register, 
      @JsonProperty("timeout") String timeout,
      @JsonProperty("invert") String invert,
      @JsonProperty("click") FilterCriteria click,
      @JsonProperty("report") StepReport report){
    super(when, unless, register, timeout, invert, report);
    this.click = click;
  }

  public FilterCriteria getClick() {
    return click;
  }

  @Override
  public String getName() {
    return TYPE_NAME;
  }
}
