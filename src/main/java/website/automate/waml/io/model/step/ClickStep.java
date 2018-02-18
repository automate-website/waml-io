package website.automate.waml.io.model.step;

import website.automate.waml.io.model.criteria.FilterCriteria;

public class ClickStep extends BasicStep {

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
}
