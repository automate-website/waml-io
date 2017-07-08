package website.automate.waml.io.model.action;

public class AlertAction extends TimeLimitedAction {

    private String confirm;
    private String text;
    private String input;

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    @Override
    public Object getDefaultCriterionValue() {
        return confirm;
    }
}
