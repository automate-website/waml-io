package website.automate.waml.jio.model.action;

import website.automate.waml.jio.model.CriterionValue;

public class EnterAction extends FilterAction {

    private CriterionValue input;
    
    public CriterionValue getInput() {
        return input;
    }

    public void setInput(Object input) {
        this.input = new CriterionValue(input);
    }
}
