package website.automate.waml.io.model.action;

import website.automate.waml.io.model.criteria.FilterCriteria;

public class MoveAction extends BasicAction {

  static final String TYPE_NAME = "move";
  
  private FilterCriteria move;

  public FilterCriteria getMove() {
    return move;
  }

  public void setMove(FilterCriteria move) {
    this.move = move;
  }
}
