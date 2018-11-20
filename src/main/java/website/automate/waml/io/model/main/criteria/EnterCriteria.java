package website.automate.waml.io.model.main.criteria;

public class EnterCriteria extends FilterCriteria {

    public EnterCriteria() {
        super();
    }

    public EnterCriteria(String selector) {
        super(selector);
    }

    private String input;

    private String clear;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getClear() {
        return clear;
    }

    public void setClear(String clear) {
        this.clear = clear;
    }

    @Override
    public boolean canBeShortNotated() {
        return input == null && super.canBeShortNotated();
    }
}
