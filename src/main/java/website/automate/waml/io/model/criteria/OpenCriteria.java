package website.automate.waml.io.model.criteria;

public class OpenCriteria implements Criteria {

  private static final String DEFAULT_CRITERION_NAME = "url";

  public OpenCriteria(String url) {
    super();
    this.url = url;
  }

  private String url;

  public String getUrl() {
    return url;
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
