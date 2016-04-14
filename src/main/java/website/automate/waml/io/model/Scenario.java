package website.automate.waml.io.model;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import website.automate.waml.io.model.action.Action;

public class Scenario {

    private String name;
    
    private Integer precedence = -1;
    
    private String description;
    
    private Boolean fragment = false;
    
    private CriterionValue timeout = CriterionValue.of(5);

    @JsonProperty("if")
    private CriterionValue when;
    
    private CriterionValue unless;
    
    private List<Action> steps;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrecedence() {
        return precedence;
    }

    public void setPrecedence(Integer precedence) {
        this.precedence = precedence;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getFragment() {
        return fragment;
    }

    public void setFragment(Boolean fragment) {
        this.fragment = fragment;
    }

    public CriterionValue getTimeout() {
        return timeout;
    }

    public void setTimeout(CriterionValue timeout) {
        this.timeout = timeout;
    }

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

    public List<Action> getSteps() {
        return steps;
    }

    public void setSteps(List<Action> steps) {
        this.steps = steps;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Scenario other = (Scenario) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
}
