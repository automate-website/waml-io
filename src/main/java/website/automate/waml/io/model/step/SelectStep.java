package website.automate.waml.io.model.step;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import website.automate.waml.io.model.criteria.FilterCriteria;

public class SelectStep extends BasicStep {

  static final String TYPE_NAME = "select";
  
  private FilterCriteria select;

  @JsonCreator
  public SelectStep(@JsonProperty("when") String when,
      @JsonProperty("register") String register, 
      @JsonProperty("timeout") String timeout,
      @JsonProperty("invert") String invert,
      @JsonProperty("select") FilterCriteria select){
    super(when, register, timeout, invert);
    this.select = select;
  }
  
  public FilterCriteria getSelect() {
    return select;
  }
}
