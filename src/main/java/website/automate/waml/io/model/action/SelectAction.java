package website.automate.waml.io.model.action;

import website.automate.waml.io.model.criteria.FilterCriteria;

public class SelectAction extends FilterAction<FilterCriteria> {

    static final String TYPE_NAME = "select";

    private FilterCriteria select;

    public FilterCriteria getSelect() {
        return select;
    }

    public void setSelect(FilterCriteria select) {
        this.select = select;
    }

    @Override
    public String getName() {
        return TYPE_NAME;
    }

    @Override
    public FilterCriteria getFilter() {
        return select;
    }

    @Override
    public void setFilter(FilterCriteria filter) {
        this.select = filter;
    }
}
