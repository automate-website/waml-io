package website.automate.waml.io.model.action;

import website.automate.waml.io.model.criteria.FilterCriteria;

public class MoveAction extends BasicAction {

  private FilterCriteria move = new FilterCriteria();

  public FilterCriteria getMove() {
    return move;
  }

  public void setMove(FilterCriteria move) {
    this.move = move;
  }
}
