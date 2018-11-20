package website.automate.waml.io.model.main.criteria;

public class OpenCriteria implements Criteria {

    private static final String DEFAULT_CRITERION_NAME = "url";

    public OpenCriteria() {
        super();
    }

    public OpenCriteria(String url) {
        this();
        this.url = url;
    }

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean canBeShortNotated() {
        return true;
    }

    @Override
    public String getDefaultCriterionName() {
        return DEFAULT_CRITERION_NAME;
    }

    @Override
    public String getDefaultCriterionValue() {
        return getUrl();
    }

}
