package website.automate.waml.io.model.action;

public abstract class FilterAction extends TimeLimitedAction {

    private String selector;
    
    private String text;
    
    private String value;
    
    private String frame;
    
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

    public String getFrame() {
      return frame;
    }
  
    public void setFrame(String frame) {
      this.frame = frame;
    }

    @Override
    public boolean canBeShortNotated(){
        return text == null
                && value == null
                && parent == null
                && frame == null
                && super.canBeShortNotated();
    }
    
    @Override
    public Object getDefaultCriterionValue(){
        return selector;
    }
    
    public boolean hasFilterCriteria(){
        return selector != null
                || text != null
                || value != null
                || parent != null
                || frame != null;
    }
}
