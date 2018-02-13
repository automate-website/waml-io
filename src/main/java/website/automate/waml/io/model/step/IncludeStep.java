package website.automate.waml.io.model.step;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import website.automate.waml.io.model.criteria.IncludeCriteria;
import website.automate.waml.io.report.StepReport;

public class IncludeStep extends BasicStep {

  static final String TYPE_NAME = "include";
  
  private IncludeCriteria include;

  @JsonCreator
  public IncludeStep(@JsonProperty("when") String when,
      @JsonProperty("unless") String unless,
      @JsonProperty("register") String register, 
      @JsonProperty("timeout") String timeout,
      @JsonProperty("invert") String invert,
      @JsonProperty("include") IncludeCriteria include,
      @JsonProperty("report") StepReport report){
    super(when, unless, register, timeout, invert, report);
    this.include = include;
  }
  
  public IncludeCriteria getInclude() {
    return include;
  }

  @Override
  public String getName() {
    return TYPE_NAME;
  }
}
