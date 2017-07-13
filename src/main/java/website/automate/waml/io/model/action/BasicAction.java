package website.automate.waml.io.model.action;

public abstract class BasicAction implements Action {

  private String when;

  private String register;

  private String timeout;

  private String invert;
  
  @Override
  public String getWhen() {
    return when;
  }

  public void setWhen(String when) {
    this.when = when;
  }

  @Override
  public String getRegister() {
    return register;
  }

  public void setRegister(String register) {
    this.register = register;
  }

  @Override
  public String getTimeout() {
    return timeout;
  }

  public void setTimeout(String timeout) {
    this.timeout = timeout;
  }

  public String getInvert() {
    return invert;
  }

  public void setInvert(String invert) {
    this.invert = invert;
  }
}
