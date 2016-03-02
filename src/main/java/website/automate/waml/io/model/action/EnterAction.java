package website.automate.waml.io.model.action;

import website.automate.waml.io.model.CriterionValue;

public class EnterAction extends FilterAction {

    private CriterionValue input;
    
    public CriterionValue getInput() {
        return input;
    }

    public void setInput(Object input) {
        this.input = new CriterionValue(input);
    }
}
