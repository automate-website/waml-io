package website.automate.waml.jio.model.action;

import website.automate.waml.jio.model.CriterionValue;

public class WaitAction extends ConditionalAction {

    private CriterionValue time;
    
    public CriterionValue getTime() {
        return time;
    }

    public void setTime(CriterionValue time) {
        this.time = time;
    }
}
