package website.automate.waml.io.model.action;

import java.util.Map;

public class StoreAction extends ConditionalAction {

    private Map<String, String> value;
    
    public Map<String, String> getValue() {
        return value;
    }

    public void setValue(Map<String, String> value) {
        this.value = value;
    }
    
    @Override
    public Object getDefaultCriterionValue(){
        return value;
    }
}