package website.automate.waml.io.model.action;

import website.automate.waml.io.model.criteria.FilterCriteria;

public class ClickAction extends BasicAction {

  static final String TYPE_NAME = "click";
  
  private FilterCriteria click;

  public FilterCriteria getClick() {
    return click;
  }

  public void setClick(FilterCriteria click) {
    this.click = click;
  }
}
