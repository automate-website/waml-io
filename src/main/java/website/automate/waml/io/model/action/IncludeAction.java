package website.automate.waml.io.model.action;

import website.automate.waml.io.model.CriterionValue;

public class IncludeAction extends ConditionalAction {

    private String scenario;

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }
    
    @Override
    public CriterionValue getDefaultCriterionValue(){
        return new CriterionValue(scenario);
    }
}
