package website.automate.waml.io.model.action;

import java.util.Map;

public class StoreAction extends ElementStoreAction {

    private Map<String, String> facts;

    public Map<String, String> getFacts() {
        return facts;
    }

    public void setFacts(Map<String, String> facts) {
        this.facts = facts;
    }
    
    @Override
    public String getDefaultCriterionValue(){
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean canBeShortNotated(){
      return false;
    }
}