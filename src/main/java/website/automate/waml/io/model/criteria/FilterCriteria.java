package website.automate.waml.io.model.criteria;

public class FilterCriteria implements Criteria {

  private static final String DEFAULT_CRITERION_NAME = "selector";
  
  private String selector;

  private String text;

  private String value;

  private String parent;

  public String getSelector() {
    return selector;
  }

  public void setSelector(String selector) {
    this.selector = selector;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getParent() {
    return parent;
  }

  public void setParent(String parent) {
    this.parent = parent;
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
    return selector;
  }
}
