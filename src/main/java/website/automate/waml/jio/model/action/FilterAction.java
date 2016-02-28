package website.automate.waml.jio.model.action;

public abstract class FilterAction extends TimeLimitedAction {

    private String selector;
    
    private String text;
    
    private String value;
    
    private ParentCriteria parent;
    
    public String getSelector() {
        return selector;
    }

    public void setSelector(String selector) {
        this.selector = selector;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ParentCriteria getParent() {
        return parent;
    }

    public void setParent(ParentCriteria parent) {
        this.parent = parent;
    }
}
