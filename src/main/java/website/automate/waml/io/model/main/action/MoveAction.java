package website.automate.waml.io.model.main.action;

import website.automate.waml.io.model.main.criteria.FilterCriteria;

public class MoveAction extends FilterAction<FilterCriteria> {

    static final String TYPE_NAME = "move";

    private FilterCriteria move;

    public FilterCriteria getMove() {
        return move;
    }

    public void setMove(FilterCriteria move) {
        this.move = move;
    }

    @Override
    public String getTypeName() {
        return TYPE_NAME;
    }

    @Override
    public FilterCriteria getFilter() {
        return move;
    }

    @Override
    public void setFilter(FilterCriteria filter) {
        this.move = filter;
    }

}
