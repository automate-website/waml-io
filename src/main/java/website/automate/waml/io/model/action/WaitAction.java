package website.automate.waml.io.model.action;

import website.automate.waml.io.model.criteria.WaitCriteria;

public class WaitAction extends ConditionalAction {

    static final String TYPE_NAME = "wait";

    private WaitCriteria wait;

    public WaitCriteria getWait() {
        return wait;
    }

    public void setWait(WaitCriteria wait) {
        this.wait = wait;
    }

    @Override
    public String getName() {
        return TYPE_NAME;
    }
}
