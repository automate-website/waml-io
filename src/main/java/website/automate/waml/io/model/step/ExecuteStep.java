package website.automate.waml.io.model.step;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import website.automate.waml.io.model.criteria.ExecuteCriteria;
import website.automate.waml.io.report.StepReport;

public class ExecuteStep extends BasicStep {

  static final String TYPE_NAME = "execute";
  
  private ExecuteCriteria execute;

  @JsonCreator
  public ExecuteStep(@JsonProperty("when") String when,
      @JsonProperty("unless") String unless,
      @JsonProperty("register") String register, 
      @JsonProperty("timeout") String timeout,
      @JsonProperty("invert") String invert,
      @JsonProperty("debug") ExecuteCriteria execute,
      @JsonProperty("report") StepReport report){
    super(when, unless, register, timeout, invert, report);
    this.execute = execute;
  }
  
  public ExecuteCriteria getExecute() {
    return execute;
  }

  @Override
  public String getName() {
    return TYPE_NAME;
  }
}
