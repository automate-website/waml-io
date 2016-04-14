package website.automate.waml.io.model.action;

public class WaitAction extends ConditionalAction {

    private String time;
    
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    @Override
    public String getDefaultCriterionValue(){
        return time;
    }
}
