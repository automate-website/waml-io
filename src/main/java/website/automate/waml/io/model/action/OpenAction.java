package website.automate.waml.io.model.action;

import website.automate.waml.io.model.criteria.OpenCriteria;

public class OpenAction extends BasicAction {

  private OpenCriteria open = new OpenCriteria();

  public OpenCriteria getOpen() {
    return open;
  }

  public void setOpen(OpenCriteria open) {
    this.open = open;
  }
}
