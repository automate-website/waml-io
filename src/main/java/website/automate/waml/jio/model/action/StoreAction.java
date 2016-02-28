package website.automate.waml.jio.model.action;

import java.util.Map;

import website.automate.waml.jio.model.CriterionValue;

public class StoreAction extends FilterAction {

    private Map<String, CriterionValue> values;
    
    public Map<String, CriterionValue> getValues() {
        return values;
    }

    public void setValues(Map<String, CriterionValue> values) {
        this.values = values;
    }
}
