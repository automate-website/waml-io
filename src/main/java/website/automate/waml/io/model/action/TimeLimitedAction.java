package website.automate.waml.io.model.action;

public abstract class TimeLimitedAction extends ConditionalAction {

    private String timeout;

    @Override
    public String getTimeout() {
        return timeout;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }
}
