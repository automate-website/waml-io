package website.automate.waml.io.model.action;

import website.automate.waml.io.model.CriterionValue;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class ConditionalAction implements Action {

    @JsonProperty("if")
    private CriterionValue when;
    
    private CriterionValue unless;
    
    public CriterionValue getWhen() {
        return when;
    }

    public void setWhen(CriterionValue when) {
        this.when = when;
    }

    public CriterionValue getUnless() {
        return unless;
    }

    public void setUnless(CriterionValue unless) {
        this.unless = unless;
    }
    
    public boolean canBeShortNotated(){
        return when == null
                && unless == null;
    }
}
