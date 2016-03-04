package website.automate.waml.io.model.action;

import website.automate.waml.io.model.CriterionValue;

public class WaitAction extends ConditionalAction {

    private CriterionValue time;
    
    public CriterionValue getTime() {
        return time;
    }

    public void setTime(CriterionValue time) {
        this.time = time;
    }
    
    @Override
    public CriterionValue getDefaultCriterionValue(){
        return new CriterionValue(time);
    }
}
