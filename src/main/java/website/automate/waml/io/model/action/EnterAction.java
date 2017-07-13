package website.automate.waml.io.model.action;

import website.automate.waml.io.model.criteria.EnterCriteria;

public class EnterAction extends BasicAction {

  private EnterCriteria enter = new EnterCriteria();

  public EnterCriteria getEnter() {
    return enter;
  }

  public void setEnter(EnterCriteria enter) {
    this.enter = enter;
  }
}
