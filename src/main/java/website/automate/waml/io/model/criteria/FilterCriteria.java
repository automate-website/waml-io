package website.automate.waml.io.model.criteria;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FilterCriteria implements Criteria {

  private static final String DEFAULT_CRITERION_NAME = "selector";
  
  private String selector;

  private String text;

  private String value;
  
  private String parent;

  private String element;

  public FilterCriteria(String selector){
    super();
    this.selector = selector;
  }
 
  @JsonCreator
  public FilterCriteria(@JsonProperty("selector") String selector, 
      @JsonProperty("text") String text, @JsonProperty("value") String value,
      @JsonProperty("parent") String parent,
      @JsonProperty("element") String element){
    this(selector);
    this.text = text;
    this.value = value;
    this.parent = parent;
    this.element = element;
  }

  public String getSelector() {
    return selector;
  }

  public String getText() {
    return text;
  }

  public String getValue() {
    return value;
  }

  public String getParent() {
    return parent;
  }

  public String getElement() {
    return element;
  }

  @Override
  public boolean canBeShortNotated() {
    return text == null
        && value == null
        && parent == null;
  }

  @Override
  public String getDefaultCriterionName() {
    return DEFAULT_CRITERION_NAME;
  }

  @Override
  public String getDefaultCriterionValue() {
    return getSelector();
  }
}
