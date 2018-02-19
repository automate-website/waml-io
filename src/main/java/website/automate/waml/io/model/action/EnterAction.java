package website.automate.waml.io.model.action;

import website.automate.waml.io.model.criteria.EnterCriteria;
import website.automate.waml.io.model.criteria.FilterCriteria;

public class EnterAction extends FilterAction {

    static final String TYPE_NAME = "enter";

    private EnterCriteria enter;

    public EnterCriteria getEnter() {
        return enter;
    }

    public void setEnter(EnterCriteria enter) {
        this.enter = enter;
    }

    @Override
    public String getName() {
        return TYPE_NAME;
    }

    @Override
    public FilterCriteria getFilter() {
        return enter;
    }
}
