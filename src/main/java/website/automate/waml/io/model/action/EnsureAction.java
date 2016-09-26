package website.automate.waml.io.model.action;

public class EnsureAction extends ElementStoreAction {

    private String absent;
    
    public String getAbsent() {
        return absent;
    }
    
    public void setAbsent(String absent) {
        this.absent = absent;
    }
    
    @Override
    public boolean canBeShortNotated(){
        return absent == null
                && super.canBeShortNotated();
    }
}
