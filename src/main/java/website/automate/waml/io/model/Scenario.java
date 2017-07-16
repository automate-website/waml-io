package website.automate.waml.io.model;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import website.automate.waml.io.model.action.Action;

@JsonPropertyOrder({"name", "precedence", "description", "fragment", "timeout", "when", "steps"})
public class Scenario {

  private String name;

  private Integer precedence;

  private String description;

  private Boolean fragment;

  private String timeout;

  private String when;

  private List<Action> steps;

  @JsonCreator
  public Scenario(@JsonProperty("name") String name,
      @JsonProperty("precendence") Integer precedence,
      @JsonProperty("description") String description, @JsonProperty("fragment") Boolean fragment,
      @JsonProperty("timeout") String timeout, @JsonProperty("when") String when,
      @JsonProperty("steps") List<Action> steps) {
    super();
    this.name = name;
    this.precedence = precedence;
    this.description = description;
    this.fragment = fragment;
    this.timeout = timeout;
    this.when = when;
    this.steps = steps;
  }
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

  public List<Action> getSteps() {
    return steps;
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
