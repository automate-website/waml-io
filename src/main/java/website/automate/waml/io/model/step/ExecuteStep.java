package website.automate.waml.io.model.step;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import website.automate.waml.io.model.criteria.ExecuteCriteria;

public class ExecuteStep extends BasicStep {

  static final String TYPE_NAME = "execute";
  
  private ExecuteCriteria execute;

  @JsonCreator
  public ExecuteStep(@JsonProperty("when") String when,
      @JsonProperty("unless") String unless,
      @JsonProperty("register") String register, 
      @JsonProperty("timeout") String timeout,
      @JsonProperty("invert") String invert,
      @JsonProperty("debug") ExecuteCriteria execute){
    super(when, unless, register, timeout, invert);
    this.execute = execute;
  }
  
  public ExecuteCriteria getExecute() {
    return execute;
  }
}
