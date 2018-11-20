package website.automate.waml.io.model;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import website.automate.waml.io.model.action.Action;
import website.automate.waml.io.model.report.ScenarioReport;

@JsonPropertyOrder({"name", "precedence", "description", "fragment", "timeout", "when", "unless",
        "report", "steps"})
public class Scenario {

    private static final String FRAGMENT_PREFIX = "_";

    private String name;

    private String path;

    private String when;

    private String unless;

    private String metadata;

    private ScenarioReport report;

    private List<Action> steps;

    public String getName() {
        return name;
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

    public List<Action> getSteps() {
        return steps;
    }

    public void setSteps(List<Action> steps) {
        this.steps = steps;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFragment() {
        return getPath().startsWith(FRAGMENT_PREFIX);
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scenario scenario = (Scenario) o;
        return Objects.equals(getName(), scenario.getName()) &&
            Objects.equals(getPath(), scenario.getPath());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPath());
    }
}
