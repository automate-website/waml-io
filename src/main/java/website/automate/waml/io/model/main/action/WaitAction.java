package website.automate.waml.io.model.main.action;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import website.automate.waml.io.model.main.criteria.WaitCriteria;

public class WaitAction extends ConditionalAction {

    static final String TYPE_NAME = "wait";

    @JsonInclude(Include.ALWAYS)
    private WaitCriteria wait;

    public WaitCriteria getWait() {
        return wait;
    }

    public void setWait(WaitCriteria wait) {
        this.wait = wait;
    }

    @Override
    public String getTypeName() {
        return TYPE_NAME;
    }
}
