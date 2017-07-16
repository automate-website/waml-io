package website.automate.waml.io.model.step;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import website.automate.waml.io.model.criteria.WaitCriteria;

public class WaitStep extends BasicStep {

  static final String TYPE_NAME = "wait";

  private WaitCriteria wait;

  @JsonCreator
  public WaitStep(@JsonProperty("when") String when,
      @JsonProperty("register") String register, 
      @JsonProperty("timeout") String timeout,
      @JsonProperty("invert") String invert,
      @JsonProperty("wait") WaitCriteria wait) {
    super(when, register, timeout, invert);
    this.wait = wait;
  }

  public WaitCriteria getWait() {
    return wait;
  }
}
