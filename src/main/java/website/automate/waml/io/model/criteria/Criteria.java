package website.automate.waml.io.model.criteria;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"selector", "text", "value", "input", "facts", "local", "script"})
public interface Criteria{

  @JsonIgnore
  boolean canBeShortNotated();

  @JsonIgnore
  String getDefaultCriterionName();
  
  @JsonIgnore
  Object getDefaultCriterionValue();
}
