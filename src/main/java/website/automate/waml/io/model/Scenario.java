package website.automate.waml.io.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import website.automate.waml.io.model.action.Action;

public class Scenario {

    private String name;
    
    private int precedence = -1;
    
    private String description;
    
    private boolean fragment = false;
    
    private CriterionValue timeout = CriterionValue.of(5);

    @JsonProperty("if")
    private String when;
    
    private String unless;
    
    private List<Action> steps;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrecedence() {
        return precedence;
    }

    public void setPrecedence(int precedence) {
        this.precedence = precedence;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFragment() {
        return fragment;
    }

    public void setFragment(boolean fragment) {
        this.fragment = fragment;
    }

    public CriterionValue getTimeout() {
        return timeout;
    }

    public void setTimeout(CriterionValue timeout) {
        this.timeout = timeout;
    }

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

    public List<Action> getSteps() {
        return steps;
    }

    public void setSteps(List<Action> steps) {
        this.steps = steps;
    }
}
