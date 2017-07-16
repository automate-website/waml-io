package website.automate.waml.io.model.step;

import website.automate.waml.io.model.criteria.FilterCriteria;

public class EnsureStep extends BasicStep {

  static final String TYPE_NAME = "ensure";
  
  private FilterCriteria ensure;

  public FilterCriteria getEnsure() {
    return ensure;
  }

  public void setEnsure(FilterCriteria ensure) {
    this.ensure = ensure;
  }
}
