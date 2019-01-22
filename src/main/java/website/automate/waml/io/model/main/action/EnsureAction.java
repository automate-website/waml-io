package website.automate.waml.io.model.main.action;

import website.automate.waml.io.model.main.criteria.FilterCriteria;

public class EnsureAction extends FilterAction<FilterCriteria> {

    static final String TYPE_NAME = "ensure";

    private FilterCriteria ensure;

    public FilterCriteria getEnsure() {
        return ensure;
    }

    public void setEnsure(FilterCriteria ensure) {
        this.ensure = ensure;
    }

    @Override
    public String getTypeName() {
        return TYPE_NAME;
    }

    @Override
    public FilterCriteria getFilter() {
        return ensure;
    }

    @Override
    public void setFilter(FilterCriteria filter) {
        this.ensure = filter;
    }
}
