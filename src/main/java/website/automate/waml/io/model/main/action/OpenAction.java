package website.automate.waml.io.model.main.action;

import website.automate.waml.io.model.main.criteria.OpenCriteria;

public class OpenAction extends ConditionalAction {

    static final String TYPE_NAME = "open";

    private OpenCriteria open;

    public OpenCriteria getOpen() {
        return open;
    }

    public void setOpen(OpenCriteria open) {
        this.open = open;
    }

    @Override
    public String getTypeName() {
        return TYPE_NAME;
    }
}
