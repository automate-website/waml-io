package website.automate.waml.io.model.action;

import website.automate.waml.io.model.criteria.IncludeCriteria;

public class IncludeAction extends BasicAction {

  private IncludeCriteria include = new IncludeCriteria();

  public IncludeCriteria getInclude() {
    return include;
  }

  public void setInclude(IncludeCriteria include) {
    this.include = include;
  }
}
