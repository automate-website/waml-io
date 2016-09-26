package website.automate.waml.io.model.action;

public abstract class ElementStoreAction extends FilterAction {

    private String store;

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }
    
    @Override
    public boolean canBeShortNotated(){
        return store == null
                && super.canBeShortNotated();
    }
}
