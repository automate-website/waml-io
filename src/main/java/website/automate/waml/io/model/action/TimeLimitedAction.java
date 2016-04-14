package website.automate.waml.io.model.action;

public abstract class TimeLimitedAction extends ConditionalAction {

    private String timeout;

    public String getTimeout() {
        return timeout;
    }

    public void setTimeout(String timeout){
        this.timeout = timeout;
    }
    
    public boolean canBeShortNotated(){
        return timeout == null
                && super.canBeShortNotated();
    }
}
