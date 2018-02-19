package website.automate.waml.io.model.action;

import website.automate.waml.io.model.criteria.AlertCriteria;

public class AlertAction extends TimeLimitedAction {

    static final String TYPE_NAME = "alert";

    private AlertCriteria alert;

    public AlertCriteria getAlert() {
        return alert;
    }

    public void setAlert(AlertCriteria alert) {
        this.alert = alert;
    }

    @Override
    public String getName() {
        return TYPE_NAME;
    }
}
