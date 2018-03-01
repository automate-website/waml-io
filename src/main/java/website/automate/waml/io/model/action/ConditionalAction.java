package website.automate.waml.io.model.action;

public abstract class ConditionalAction extends Action {

    private String when;

    private String unless;

    public String getWhen() {
        return when;
    }

    public void setWhen(String when) {
        this.when = when;
    }

    public String getUnless() {
        return unless;
    }

    public void setUnless(String unless) {
        this.unless = unless;
    }
}
