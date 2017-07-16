package website.automate.waml.io.model.step;

import website.automate.waml.io.model.criteria.FilterCriteria;

public class MoveStep extends BasicStep {

  static final String TYPE_NAME = "move";
  
  private FilterCriteria move;

  public FilterCriteria getMove() {
    return move;
  }

  public void setMove(FilterCriteria move) {
    this.move = move;
  }
}
