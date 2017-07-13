package website.automate.waml.io.model.action;


import website.automate.waml.io.model.criteria.DefineCriteria;

public class DefineAction extends BasicAction {

  private DefineCriteria define = new DefineCriteria();

  public DefineCriteria getDefine() {
    return define;
  }

  public void setDefine(DefineCriteria define) {
    this.define = define;
  }
}
