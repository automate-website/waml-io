package website.automate.waml.io.model.step;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import website.automate.waml.io.model.criteria.FilterCriteria;
import website.automate.waml.io.report.StepReport;

public class MoveStep extends BasicStep {

  static final String TYPE_NAME = "move";
  
  private FilterCriteria move;

  @JsonCreator
  public MoveStep(@JsonProperty("when") String when,
      @JsonProperty("unless") String unless,
      @JsonProperty("register") String register, 
      @JsonProperty("timeout") String timeout,
      @JsonProperty("invert") String invert,
      @JsonProperty("move") FilterCriteria move,
      @JsonProperty("report") StepReport report){
    super(when, unless, register, timeout, invert, report);
    this.move = move;
  }
  
  public FilterCriteria getMove() {
    return move;
  }

  @Override
  public String getName() {
    return TYPE_NAME;
  }
}
