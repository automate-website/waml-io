package website.automate.waml.io.model.criteria;

import static website.automate.waml.io.model.CriterionNames.FACTS;
import static website.automate.waml.io.model.CriterionNames.INPUT;
import static website.automate.waml.io.model.CriterionNames.SELECTOR;
import static website.automate.waml.io.model.CriterionNames.TEXT;
import static website.automate.waml.io.model.CriterionNames.VALUE;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({SELECTOR, TEXT, VALUE, FACTS, INPUT})
public interface Criteria{

  @JsonIgnore
  boolean canBeShortNotated();

  @JsonIgnore
  String getDefaultCriterionName();
  
  @JsonIgnore
  Object getDefaultCriterionValue();
}
