package website.automate.waml.io.model.action;

import static website.automate.waml.io.model.CriterionNames.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({IF, UNLESS, SELECTOR, TIME, SCENARIO, URL, TEXT, VALUE, INPUT, TIMEOUT, META})
public interface Action {
    boolean canBeShortNotated();
    
    @JsonIgnore
    Object getDefaultCriterionValue();
    
    String getMeta();
    
    void setMeta(String meta);
}