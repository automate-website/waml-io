package website.automate.waml.io.model.main.action;

import website.automate.waml.io.model.main.criteria.IncludeCriteria;

public class IncludeAction extends ConditionalAction {

    static final String TYPE_NAME = "include";

    private IncludeCriteria include;

    public IncludeCriteria getInclude() {
        return include;
    }

    public void setInclude(IncludeCriteria include) {
        this.include = include;
    }

    @Override
    public String getTypeName() {
        return TYPE_NAME;
    }
}
