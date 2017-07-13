package website.automate.waml.io.model.criteria;

public class AlertCriteria implements Criteria{

  private static final String DEFAULT_CRITERION_NAME = "confirm";

  private String confirm;

  private String text;

  private String input;

  public String getConfirm() {
    return confirm;
  }

  public void setConfirm(String confirm) {
    this.confirm = confirm;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getInput() {
    return input;
  }

  public void setInput(String input) {
    this.input = input;
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
