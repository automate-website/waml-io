package website.automate.waml.io.model.main;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonValue;
import website.automate.waml.io.model.main.action.Action;

@JsonPropertyOrder({"name", "precedence", "description", "fragment", "timeout", "when", "unless",
        "report", "steps"})
public class Scenario {

    private static final String FRAGMENT_PREFIX = "_";

    private String name;

    private String path;

    private List<Action> steps;

    @JsonIgnore
    public String getName() {
        return name;
    }

    @JsonValue
    public List<Action> getSteps() {
        return steps;
    }

    public void setSteps(List<Action> steps) {
        this.steps = steps;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public boolean isFragment() {
        return getPath().startsWith(FRAGMENT_PREFIX);
    }

    @JsonIgnore
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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
