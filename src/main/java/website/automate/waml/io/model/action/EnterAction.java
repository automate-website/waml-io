package website.automate.waml.io.model.action;

import website.automate.waml.io.model.criteria.EnterCriteria;

public class EnterAction extends BasicAction {
  
  static final String TYPE_NAME = "enter";
  
  private EnterCriteria enter;

  public EnterCriteria getEnter() {
    return enter;
  }

  public void setEnter(EnterCriteria enter) {
    this.enter = enter;
  }
}
