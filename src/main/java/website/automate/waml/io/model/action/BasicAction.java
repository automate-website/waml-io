package website.automate.waml.io.model.action;

import static java.text.MessageFormat.format;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import website.automate.waml.io.deserializer.UnknownActionException;


public abstract class BasicAction implements Action {

  public static final Map<String, Class<? extends Action>> TYPE_NAMES;
  
  static {
    TYPE_NAMES = new HashMap<>();
    TYPE_NAMES.put(AlertAction.TYPE_NAME, AlertAction.class);
    TYPE_NAMES.put(ClickAction.TYPE_NAME, ClickAction.class);
    TYPE_NAMES.put(DefineAction.TYPE_NAME, DefineAction.class);
    TYPE_NAMES.put(EnsureAction.TYPE_NAME, EnsureAction.class);
    TYPE_NAMES.put(EnterAction.TYPE_NAME, EnterAction.class);
    TYPE_NAMES.put(IncludeAction.TYPE_NAME, IncludeAction.class);
    TYPE_NAMES.put(MoveAction.TYPE_NAME, MoveAction.class);
    TYPE_NAMES.put(OpenAction.TYPE_NAME, OpenAction.class);
    TYPE_NAMES.put(SelectAction.TYPE_NAME, SelectAction.class);
    TYPE_NAMES.put(WaitAction.TYPE_NAME, WaitAction.class);
  }
  
  private String when;

  private String register;

  private String timeout;

  private String invert;
  
  public static Class<? extends Action> findClazzByNames(final Collection<String> names){
    Optional<String> matchinTypeName = TYPE_NAMES.keySet().stream().filter(typeName -> names.contains(typeName)).findFirst();
    if(matchinTypeName.isPresent()){
      return TYPE_NAMES.get(matchinTypeName.get());
    }
    throw new UnknownActionException(format("Could not identify any step using keys: {0}.", names));
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
