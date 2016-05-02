package website.automate.waml.io.model.action;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class ConditionalAction implements Action {

    @JsonProperty("if")
    private String when;
    
    private String unless;
    
    private String meta;
    
    public String getWhen() {
        return when;
    }

    public void setWhen(String when) {
        this.when = when;
    }

    public String getUnless() {
        return unless;
    }

    public void setUnless(String unless) {
        this.unless = unless;
    }
    
    @Override
    public boolean canBeShortNotated(){
        return when == null
                && unless == null
                && meta == null;
    }
    
    @Override
    public String getMeta() {
        return meta;
    }

    @Override
    public void setMeta(String meta) {
        this.meta = meta;
    }
}
