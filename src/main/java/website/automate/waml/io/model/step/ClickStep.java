package website.automate.waml.io.model.step;

import website.automate.waml.io.model.criteria.FilterCriteria;

public class ClickStep extends BasicStep {

  static final String TYPE_NAME = "click";
  
  private FilterCriteria click;

  public FilterCriteria getClick() {
    return click;
  }

  public void setClick(FilterCriteria click) {
    this.click = click;
  }
}
