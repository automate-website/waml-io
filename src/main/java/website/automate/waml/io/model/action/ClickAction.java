package website.automate.waml.io.model.action;

import website.automate.waml.io.model.criteria.FilterCriteria;

public class ClickAction extends FilterAction {

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
}
