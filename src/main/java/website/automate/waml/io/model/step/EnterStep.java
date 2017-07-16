package website.automate.waml.io.model.step;

import website.automate.waml.io.model.criteria.EnterCriteria;

public class EnterStep extends BasicStep {
  
  static final String TYPE_NAME = "enter";
  
  private EnterCriteria enter;

  public EnterCriteria getEnter() {
    return enter;
  }

  public void setEnter(EnterCriteria enter) {
    this.enter = enter;
  }
}
