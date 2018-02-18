package website.automate.waml.io.model.criteria;

public class AlertCriteria implements Criteria {

    private static final String DEFAULT_CRITERION_NAME = "confirm";

    private String confirm;

    private String text;

    private String input;

    public AlertCriteria() {
        super();
    }

    public AlertCriteria(String confirm) {
        this();
        this.confirm = confirm;
    }

    public String getConfirm() {
        return confirm;
    }

    public String getText() {
        return text;
    }

    public String getInput() {
        return input;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setInput(String input) {
        this.input = input;
    }

    @Override
    public boolean canBeShortNotated() {
        return text == null && input == null;
    }

    @Override
    public String getDefaultCriterionName() {
        return DEFAULT_CRITERION_NAME;
    }

    @Override
    public String getDefaultCriterionValue() {
        return getConfirm();
    }
}
