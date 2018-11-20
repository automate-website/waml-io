package website.automate.waml.io.model.main.criteria;

public class DebugCriteria implements Criteria {

    private static final String DEFAULT_CRITERION_NAME = "msg";

    private String msg;

    private String verbosity;

    public DebugCriteria() {
        super();
    }

    public DebugCriteria(String msg) {
        this();
        this.msg = msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setVerbosity(String verbosity) {
        this.verbosity = verbosity;
    }

    @Override
    public boolean canBeShortNotated() {
        return verbosity == null;
    }

    @Override
    public String getDefaultCriterionName() {
        return DEFAULT_CRITERION_NAME;
    }

    @Override
    public Object getDefaultCriterionValue() {
        return getMsg();
    }

    public String getMsg() {
        return msg;
    }

    public String getVerbosity() {
        return verbosity;
    }
}
