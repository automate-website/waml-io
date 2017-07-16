package website.automate.waml.io.model.step;

import website.automate.waml.io.model.criteria.OpenCriteria;

public class OpenStep extends BasicStep {

  static final String TYPE_NAME = "open";
  
  private OpenCriteria open;

  public OpenCriteria getOpen() {
    return open;
  }

  public void setOpen(OpenCriteria open) {
    this.open = open;
  }
}
