package website.automate.waml.io.model.main.criteria;

public class ExecuteCriteria implements Criteria {

    private static final String DEFAULT_CRITERION_NAME = "script";

    private String script;

    public ExecuteCriteria() {
        super();
    }

    public ExecuteCriteria(String script) {
        this();
        this.script = script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    @Override
    public boolean canBeShortNotated() {
        return true;
    }

    @Override
    public String getDefaultCriterionName() {
        return DEFAULT_CRITERION_NAME;
    }

    @Override
    public Object getDefaultCriterionValue() {
        return getScript();
    }

    public String getScript() {
        return script;
    }
}
