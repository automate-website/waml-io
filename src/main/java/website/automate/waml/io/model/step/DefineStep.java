package website.automate.waml.io.model.step;

import website.automate.waml.io.model.criteria.DefineCriteria;

public class DefineStep extends BasicStep {

  static final String TYPE_NAME = "define";
  
  private DefineCriteria define;

  public DefineCriteria getDefine() {
    return define;
  }

  public void setDefine(DefineCriteria define) {
    this.define = define;
  }
}
