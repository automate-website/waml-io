package website.automate.waml.io.model.main.action;

import website.automate.waml.io.model.main.criteria.FilterCriteria;

public class ClickAction extends FilterAction<FilterCriteria> {

    static final String TYPE_NAME = "click";

    private FilterCriteria click;

    public void setClick(FilterCriteria click) {
        this.click = click;
    }

    public FilterCriteria getClick() {
        return click;
    }

    @Override
    public String getName() {
        return TYPE_NAME;
    }

    @Override
    public FilterCriteria getFilter() {
        return click;
    }

    @Override
    public void setFilter(FilterCriteria filter) {
        this.click = filter;
    }
}
