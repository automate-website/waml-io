package website.automate.waml.io.model.step;

import static java.text.MessageFormat.format;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import website.automate.waml.io.deserializer.UnknownStepException;


public abstract class BasicStep implements Step {

  public static final Map<String, Class<? extends Step>> TYPE_NAMES;
  
  static {
    TYPE_NAMES = new HashMap<>();
    TYPE_NAMES.put(AlertStep.TYPE_NAME, AlertStep.class);
    TYPE_NAMES.put(ClickStep.TYPE_NAME, ClickStep.class);
    TYPE_NAMES.put(DefineStep.TYPE_NAME, DefineStep.class);
    TYPE_NAMES.put(EnsureStep.TYPE_NAME, EnsureStep.class);
    TYPE_NAMES.put(EnterStep.TYPE_NAME, EnterStep.class);
    TYPE_NAMES.put(IncludeStep.TYPE_NAME, IncludeStep.class);
    TYPE_NAMES.put(MoveStep.TYPE_NAME, MoveStep.class);
    TYPE_NAMES.put(OpenStep.TYPE_NAME, OpenStep.class);
    TYPE_NAMES.put(SelectStep.TYPE_NAME, SelectStep.class);
    TYPE_NAMES.put(WaitStep.TYPE_NAME, WaitStep.class);
  }
  
  private String when;

  private String register;

  private String timeout;

  private String invert;
  
  public static Class<? extends Step> findClazzByNames(final Collection<String> names){
    Optional<String> matchinTypeName = TYPE_NAMES.keySet().stream().filter(typeName -> names.contains(typeName)).findFirst();
    if(matchinTypeName.isPresent()){
      return TYPE_NAMES.get(matchinTypeName.get());
    }
    throw new UnknownStepException(format("Could not identify any step using keys: {0}.", names));
  }
  
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