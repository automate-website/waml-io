package website.automate.waml.io.model.criteria;

public class EnterCriteria extends FilterCriteria {

    public EnterCriteria() {
        super();
    }

    public EnterCriteria(String selector) {
        super(selector);
    }

    private String input;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    @Override
    public boolean canBeShortNotated() {
        return input == null && super.canBeShortNotated();
    }
}
