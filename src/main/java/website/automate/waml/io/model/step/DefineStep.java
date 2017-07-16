package website.automate.waml.io.model.step;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import website.automate.waml.io.model.criteria.DefineCriteria;

public class DefineStep extends BasicStep {

  static final String TYPE_NAME = "define";
  
  private DefineCriteria define;

  @JsonCreator
  public DefineStep(@JsonProperty("when") String when,
      @JsonProperty("register") String register, 
      @JsonProperty("timeout") String timeout,
      @JsonProperty("invert") String invert,
      @JsonProperty("define") DefineCriteria define){
    super(when, register, timeout, invert);
    this.define = define;
  }
  
  public DefineCriteria getDefine() {
    return define;
  }
}
