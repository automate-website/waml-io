package website.automate.waml.io.model.action;

import website.automate.waml.io.model.criteria.OpenCriteria;

public class OpenAction extends BasicAction {

  static final String TYPE_NAME = "open";
  
  private OpenCriteria open;

  public OpenCriteria getOpen() {
    return open;
  }

  public void setOpen(OpenCriteria open) {
    this.open = open;
  }
}
