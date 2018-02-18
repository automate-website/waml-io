package website.automate.waml.io.model.step;

import website.automate.waml.io.model.criteria.IncludeCriteria;

public class IncludeStep extends BasicStep {

    static final String TYPE_NAME = "include";

    private IncludeCriteria include;

    public IncludeCriteria getInclude() {
        return include;
    }

    public void setInclude(IncludeCriteria include) {
        this.include = include;
    }

    @Override
    public String getName() {
        return TYPE_NAME;
    }
}
