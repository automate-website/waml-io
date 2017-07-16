package website.automate.waml.io.model.action;

import website.automate.waml.io.model.criteria.DefineCriteria;

public class DefineAction extends BasicAction {

  static final String TYPE_NAME = "define";
  
  private DefineCriteria define;

  public DefineCriteria getDefine() {
    return define;
  }

  public void setDefine(DefineCriteria define) {
    this.define = define;
  }
}
