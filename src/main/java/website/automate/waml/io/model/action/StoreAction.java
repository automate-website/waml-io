package website.automate.waml.io.model.action;

import java.util.Map;

import website.automate.waml.io.model.CriterionValue;

public class StoreAction extends ConditionalAction {

    private Map<String, CriterionValue> value;
    
    public Map<String, CriterionValue> getValue() {
        return value;
    }

    public void setValue(Map<String, CriterionValue> value) {
        this.value = value;
    }
}
