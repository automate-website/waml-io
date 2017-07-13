package website.automate.waml.io.model.action;

import website.automate.waml.io.model.criteria.FilterCriteria;

public class SelectAction extends BasicAction {

  private FilterCriteria select;

  public FilterCriteria getSelect() {
    return select;
  }

  public void setSelect(FilterCriteria select) {
    this.select = select;
  }
}
