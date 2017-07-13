package website.automate.waml.io.model.action;

import website.automate.waml.io.model.criteria.AlertCriteria;

public class AlertAction extends BasicAction {

  private AlertCriteria alert = new AlertCriteria();

  public AlertCriteria getAlert() {
    return alert;
  }

  public void setAlert(AlertCriteria alert) {
    this.alert = alert;
  }
}
