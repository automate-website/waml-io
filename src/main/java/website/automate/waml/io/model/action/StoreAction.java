package website.automate.waml.io.model.action;

import java.util.Collections;
import java.util.Map;

public class StoreAction extends ElementStoreAction {

    private Map<String, String> facts = Collections.emptyMap();
    
    public Map<String, String> getFacts() {
        return facts;
    }

    public void setFacts(Map<String, String> facts) {
        this.facts = facts;
    }
    
    @Override
    public Object getDefaultCriterionValue(){
        return facts;
    }
    
    @Override
    public boolean canBeShortNotated(){
      return getSelector() == null
          && super.canBeShortNotated();
    }
}