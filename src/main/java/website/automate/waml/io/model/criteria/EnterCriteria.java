package website.automate.waml.io.model.criteria;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EnterCriteria extends FilterCriteria {

  public EnterCriteria(String selector){
    super(selector);
  }
  
  @JsonCreator
  public EnterCriteria(@JsonProperty("selector") String selector, 
      @JsonProperty("text") String text, @JsonProperty("value") String value,
      @JsonProperty("parent") String parent, @JsonProperty("input")String input) {
    super(selector, text, value, parent);
    this.input = input;
  }

  private String input;
  
  public String getInput() {
    return input;
  }

  @Override
  public boolean canBeShortNotated() {
    return input == null &&
        super.canBeShortNotated();
  }
}
