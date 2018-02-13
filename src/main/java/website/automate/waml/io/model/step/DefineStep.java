package website.automate.waml.io.model.step;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import website.automate.waml.io.model.criteria.DefineCriteria;
import website.automate.waml.io.report.StepReport;

public class DefineStep extends BasicStep {

  static final String TYPE_NAME = "define";
  
  private DefineCriteria define;

  @JsonCreator
  public DefineStep(@JsonProperty("when") String when,
      @JsonProperty("unless") String unless,
      @JsonProperty("register") String register, 
      @JsonProperty("timeout") String timeout,
      @JsonProperty("invert") String invert,
      @JsonProperty("define") DefineCriteria define,
      @JsonProperty("report") StepReport report){
    super(when, unless, register, timeout, invert, report);
    this.define = define;
  }
  
  public DefineCriteria getDefine() {
    return define;
  }

  @Override
  public String getName() {
    return TYPE_NAME;
  }
}
