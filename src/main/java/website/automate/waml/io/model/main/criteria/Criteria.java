package website.automate.waml.io.model.main.criteria;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"selector", "text", "value", "element", "input", "facts", "local", "async", "script"})
public interface Criteria {

    @JsonIgnore
    boolean canBeShortNotated();

    @JsonIgnore
    String getDefaultCriterionName();

    @JsonIgnore
    Object getDefaultCriterionValue();
}
