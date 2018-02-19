package website.automate.waml.io.model;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import website.automate.waml.io.model.action.Action;
import website.automate.waml.io.report.ScenarioReport;

@JsonPropertyOrder({"name", "precedence", "description", "fragment", "timeout", "when", "unless",
        "report", "steps"})
public class Scenario {

    private String name;

    private Integer precedence;

    private String description;

    private Boolean fragment;

    private String timeout;

    private String when;

    private String unless;

    private ScenarioReport report;

    @JsonProperty("steps")
    private List<Action> actions;

    public String getName() {
        return name;
    }

    public Integer getPrecedence() {
        return precedence;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getFragment() {
        return fragment;
    }

    public String getTimeout() {
        return timeout;
    }

    public String getWhen() {
        return when;
    }

    public String getUnless() {
        return unless;
    }

    public ScenarioReport getReport() {
        return report;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrecedence(Integer precedence) {
        this.precedence = precedence;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFragment(Boolean fragment) {
        this.fragment = fragment;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    public void setWhen(String when) {
        this.when = when;
    }

    public void setUnless(String unless) {
        this.unless = unless;
    }

    public void setReport(ScenarioReport report) {
        this.report = report;
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
