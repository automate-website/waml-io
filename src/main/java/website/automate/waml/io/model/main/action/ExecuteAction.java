package website.automate.waml.io.model.main.action;

import website.automate.waml.io.model.main.criteria.ExecuteCriteria;

public class ExecuteAction extends ConditionalAction {

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
