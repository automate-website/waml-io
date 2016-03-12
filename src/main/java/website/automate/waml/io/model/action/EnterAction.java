package website.automate.waml.io.model.action;

import website.automate.waml.io.model.CriterionValue;

public class EnterAction extends FilterAction {

    private CriterionValue input;
    
    private CriterionValue clear;
    
    public CriterionValue getInput() {
        return input;
    }

    public void setInput(CriterionValue input) {
        this.input = input;
    }

    public CriterionValue getClear() {
        return clear;
    }

    public void setClear(CriterionValue clear) {
        this.clear = clear;
    }
}
