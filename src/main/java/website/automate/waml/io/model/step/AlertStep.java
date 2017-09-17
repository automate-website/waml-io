package website.automate.waml.io.model.step;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import website.automate.waml.io.model.criteria.AlertCriteria;

public class AlertStep extends BasicStep {

  static final String TYPE_NAME = "alert";

  private AlertCriteria alert;
  
  @JsonCreator
  public AlertStep(@JsonProperty("when") String when,
      @JsonProperty("unless") String unless,
      @JsonProperty("register") String register, 
      @JsonProperty("timeout") String timeout,
      @JsonProperty("invert") String invert,
      @JsonProperty("alert") AlertCriteria alert){
    super(when, unless, register, timeout, invert);
    this.alert = alert;
  }
  
  public AlertCriteria getAlert() {
    return alert;
  }
}
