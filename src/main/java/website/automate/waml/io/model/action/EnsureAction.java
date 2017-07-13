package website.automate.waml.io.model.action;

import website.automate.waml.io.model.criteria.FilterCriteria;

public class EnsureAction extends BasicAction {

  private FilterCriteria ensure = new FilterCriteria();

  public FilterCriteria getEnsure() {
    return ensure;
  }

  public void setEnsure(FilterCriteria ensure) {
    this.ensure = ensure;
  }
}
