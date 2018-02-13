package website.automate.waml.io.model.step;

import static java.text.MessageFormat.format;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import website.automate.waml.io.deserializer.UnknownStepException;
import website.automate.waml.io.report.StepReport;


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
    TYPE_NAMES.put(DebugStep.TYPE_NAME, DebugStep.class);
    TYPE_NAMES.put(ExecuteStep.TYPE_NAME, ExecuteStep.class);
  }
  
  private String when;

  private String unless;
  
  private String register;

  private String timeout;

  private String invert;
  
  private StepReport report;
  
  @JsonCreator
  public BasicStep(@JsonProperty("when") String when,
      @JsonProperty("unless") String unless,
      @JsonProperty("register") String register, 
      @JsonProperty("timeout") String timeout,
      @JsonProperty("invert") String invert,
      @JsonProperty("report") StepReport report) {
    super();
    this.when = when;
    this.unless = unless;
    this.register = register;
    this.timeout = timeout;
    this.invert = invert;
    this.report = report;
  }
  
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

  @Override
  public String getRegister() {
    return register;
  }

  @Override
  public String getTimeout() {
    return timeout;
  }

  @Override
  public String getInvert() {
    return invert;
  }
  
  @Override
  public String getUnless() {
    return unless;
  }
  
  @Override
  public StepReport getReport() {
      return report;
  }

}
