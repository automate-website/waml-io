package website.automate.waml.io.model.step;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import website.automate.waml.io.model.criteria.FilterCriteria;

public class EnsureStep extends BasicStep {

  static final String TYPE_NAME = "ensure";
  
  private FilterCriteria ensure;

  @JsonCreator
  public EnsureStep(@JsonProperty("when") String when,
      @JsonProperty("register") String register, 
      @JsonProperty("timeout") String timeout,
      @JsonProperty("invert") String invert,
      @JsonProperty("ensure") FilterCriteria ensure){
    super(when, register, timeout, invert);
    this.ensure = ensure;
  }
  
  public FilterCriteria getEnsure() {
    return ensure;
  }
}
