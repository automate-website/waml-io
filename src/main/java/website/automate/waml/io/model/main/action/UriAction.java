package website.automate.waml.io.model.main.action;

import website.automate.waml.io.model.main.criteria.UriCriteria;

public class UriAction extends TimeLimitedAction {

    static final String TYPE_NAME = "uri";

    private UriCriteria uri;

    public UriCriteria getUri() {
        return uri;
    }

    public void setUri(UriCriteria uri) {
        this.uri = uri;
    }

    @Override
    public String getTypeName() {
        return TYPE_NAME;
    }
}
