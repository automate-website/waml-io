package website.automate.waml.io.model.action;

import website.automate.waml.io.model.CriterionValue;

public class OpenAction extends ConditionalAction {

    private String url;
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    @Override
    public CriterionValue getDefaultCriterionValue(){
        return new CriterionValue(url);
    }
}
