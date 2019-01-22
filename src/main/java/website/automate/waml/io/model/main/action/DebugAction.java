package website.automate.waml.io.model.main.action;

import website.automate.waml.io.model.main.criteria.DebugCriteria;

public class DebugAction extends ConditionalAction {

    static final String TYPE_NAME = "debug";

    private DebugCriteria debug;

    public DebugCriteria getDebug() {
        return debug;
    }

    public void setDebug(DebugCriteria debug) {
        this.debug = debug;
    }

    @Override
    public String getTypeName() {
        return TYPE_NAME;
    }
}
