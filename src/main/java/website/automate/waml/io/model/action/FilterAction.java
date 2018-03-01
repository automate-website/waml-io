package website.automate.waml.io.model.action;

import com.fasterxml.jackson.annotation.JsonIgnore;
import website.automate.waml.io.model.criteria.FilterCriteria;

public abstract class FilterAction<T extends FilterCriteria> extends TimeLimitedAction {

    @JsonIgnore
    public abstract T getFilter();

    @JsonIgnore
    public abstract void setFilter(T filter);
}
