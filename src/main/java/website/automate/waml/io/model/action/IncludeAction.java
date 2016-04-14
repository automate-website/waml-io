package website.automate.waml.io.model.action;

public class IncludeAction extends ConditionalAction {

    private String scenario;

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }
    
    @Override
    public String getDefaultCriterionValue(){
        return scenario;
    }
}
