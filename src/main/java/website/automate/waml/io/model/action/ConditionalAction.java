package website.automate.waml.io.model.action;

public abstract class ConditionalAction extends BasicAction {

    private String when;

    private String unless;

    @Override
    public String getWhen() {
        return when;
    }

    public void setWhen(String when) {
        this.when = when;
    }

    @Override
    public String getUnless() {
        return unless;
    }

    public void setUnless(String unless) {
        this.unless = unless;
    }
}
