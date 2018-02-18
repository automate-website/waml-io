package website.automate.waml.io.model.step;

import website.automate.waml.io.model.criteria.DebugCriteria;

public class DebugStep extends BasicStep {

static final String TYPE_NAME = "debug";
  
  private DebugCriteria debug;

  public DebugCriteria getDebug() {
    return debug;
  }

  public void setDebug(DebugCriteria debug) {
        this.debug = debug;
    }
  
  @Override
  public String getName() {
    return TYPE_NAME;
  }
}
