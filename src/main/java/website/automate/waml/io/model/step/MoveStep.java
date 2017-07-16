package website.automate.waml.io.model.step;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import website.automate.waml.io.model.criteria.FilterCriteria;

public class MoveStep extends BasicStep {

  static final String TYPE_NAME = "move";
  
  private FilterCriteria move;

  @JsonCreator
  public MoveStep(@JsonProperty("when") String when,
      @JsonProperty("register") String register, 
      @JsonProperty("timeout") String timeout,
      @JsonProperty("invert") String invert,
      @JsonProperty("move") FilterCriteria move){
    super(when, register, timeout, invert);
    this.move = move;
  }
  
  public FilterCriteria getMove() {
    return move;
  }
}
