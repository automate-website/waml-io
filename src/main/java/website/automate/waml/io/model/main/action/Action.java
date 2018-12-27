package website.automate.waml.io.model.main.action;

import static java.text.MessageFormat.format;
import static java.util.Arrays.asList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import website.automate.waml.io.deserializer.UnknownActionException;

@JsonPropertyOrder({
    "alert", "click", "debug", "define", "ensure", "enter", "execute", "filter", "include", "move", "open", "select", "wait",
    "when", "unless", "timeout", "failed_when", "register", "with_items", "report"
})
public abstract class Action {

    public static Map<String, Class<? extends Action>> ACTION_NAME_CLASS_MAP = new HashMap<>();

    public static Map<Class<? extends Action>, String> ACTION_CLASS_NAME_MAP = new HashMap<>();

    public static Collection<Class<? extends Action>> EXPLICIT_ACTIONS =
            asList(ClickAction.class, EnterAction.class, MoveAction.class, OpenAction.class,
                    SelectAction.class, WaitAction.class, EnsureAction.class);

    static {
        register(AlertAction.TYPE_NAME, AlertAction.class);
        register(ClickAction.TYPE_NAME, ClickAction.class);
        register(DefineAction.TYPE_NAME, DefineAction.class);
        register(EnsureAction.TYPE_NAME, EnsureAction.class);
        register(EnterAction.TYPE_NAME, EnterAction.class);
        register(IncludeAction.TYPE_NAME, IncludeAction.class);
        register(MoveAction.TYPE_NAME, MoveAction.class);
        register(OpenAction.TYPE_NAME, OpenAction.class);
        register(SelectAction.TYPE_NAME, SelectAction.class);
        register(WaitAction.TYPE_NAME, WaitAction.class);
        register(DebugAction.TYPE_NAME, DebugAction.class);
        register(ExecuteAction.TYPE_NAME, ExecuteAction.class);
    }

    private String register;

    private String timeout;

    @JsonProperty("failed_when")
    private String failedWhen;

    @JsonProperty("with_items")
    private Object withItems;

    private static void register(String name, Class<? extends Action> clazz) {
        ACTION_NAME_CLASS_MAP.put(name, clazz);
        ACTION_CLASS_NAME_MAP.put(clazz, name);
    }

    public static boolean isExplicit(Class<? extends Action> clazz) {
        return EXPLICIT_ACTIONS.contains(clazz);
    }

    public static String findNameByClazz(Class<? extends Action> clazz) {
        return ACTION_CLASS_NAME_MAP.get(clazz);
    }

    public static Class<? extends Action> findClazzByNames(final Collection<String> names) {
        Optional<String> matchinTypeName = ACTION_NAME_CLASS_MAP.keySet().stream()
                .filter(typeName -> names.contains(typeName)).findFirst();
        if (matchinTypeName.isPresent()) {
            return ACTION_NAME_CLASS_MAP.get(matchinTypeName.get());
        }
        throw new UnknownActionException(
                format("Could not identify any action using keys: {0}.", names));
    }

    public String getRegister() {
        return register;
    }

    public String getTimeout() {
        return timeout;
    }

    public String getFailedWhen() {
        return failedWhen;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    public void setFailedWhen(String failedWhen) {
        this.failedWhen = failedWhen;
    }

    @JsonIgnore
    public abstract String getName();

    public Object getWithItems() {
        return withItems;
    }

    public void setWithItems(Object withItems) {
        this.withItems = withItems;
    }
}
