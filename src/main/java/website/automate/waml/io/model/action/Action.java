package website.automate.waml.io.model.action;

import static website.automate.waml.io.model.CriterionNames.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import website.automate.waml.io.model.CriterionValue;

@JsonPropertyOrder({IF, UNLESS, SELECTOR, TIME, SCENARIO, URL, TEXT, VALUE, INPUT, TIMEOUT})
public interface Action {
    boolean canBeShortNotated();
    
    @JsonIgnore
    CriterionValue getDefaultCriterionValue();
}