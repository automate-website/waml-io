package website.automate.waml.io.model.action;

import website.automate.waml.io.model.criteria.WaitCriteria;

public class WaitAction extends BasicAction {

  private WaitCriteria wait;

  public WaitCriteria getWait() {
    return wait;
  }

  public void setWait(WaitCriteria wait) {
    this.wait = wait;
  }
}
