package website.automate.waml.io.model.step;

import website.automate.waml.io.model.criteria.FilterCriteria;

public class SelectStep extends BasicStep {

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
}
