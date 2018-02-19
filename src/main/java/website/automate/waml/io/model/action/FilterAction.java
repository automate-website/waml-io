package website.automate.waml.io.model.action;

import com.fasterxml.jackson.annotation.JsonIgnore;
import website.automate.waml.io.model.criteria.FilterCriteria;

public abstract class FilterAction extends TimeLimitedAction {

    @JsonIgnore
    public abstract FilterCriteria getFilter();
}
