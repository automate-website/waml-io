package website.automate.waml.io.model.step;

import website.automate.waml.io.model.criteria.ExecuteCriteria;

public class ExecuteStep extends BasicStep {

    static final String TYPE_NAME = "execute";

    private ExecuteCriteria execute;

    public void setExecute(ExecuteCriteria execute) {
        this.execute = execute;
    }

    public ExecuteCriteria getExecute() {
        return execute;
    }

    @Override
    public String getName() {
        return TYPE_NAME;
    }
}
