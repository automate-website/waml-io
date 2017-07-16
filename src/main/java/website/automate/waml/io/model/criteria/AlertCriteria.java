package website.automate.waml.io.model.criteria;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AlertCriteria implements Criteria{

  private static final String DEFAULT_CRITERION_NAME = "confirm";

  private String confirm;

  private String text;

  private String input;

  public AlertCriteria(String confirm){
    this.confirm = confirm;
  }
  
  @JsonCreator
  public AlertCriteria(@JsonProperty("confirm") String confirm, 
      @JsonProperty("text") String text, @JsonProperty("input") String input){
    this(confirm);
    this.text = text;
    this.input = input;
  }
  
  public String getConfirm() {
    return confirm;
  }

  public String getText() {
    return text;
  }

  public String getInput() {
    return input;
  }

  @Override
  public boolean canBeShortNotated() {
    return text == null && input == null;
  }

  @Override
  public String getDefaultCriterionName() {
    return DEFAULT_CRITERION_NAME;
  }

  @Override
  public String getDefaultCriterionValue() {
    return confirm;
  }
}
