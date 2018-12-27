package website.automate.waml.io.model.main.action;

import website.automate.waml.io.deserializer.UnknownActionException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static java.text.MessageFormat.format;
import static java.util.Arrays.asList;

public class ActionRegistry {

    private static Map<String, Class<? extends Action>> ACTION_NAME_CLASS_MAP = new HashMap<>();

    private static Map<Class<? extends Action>, String> ACTION_CLASS_NAME_MAP = new HashMap<>();

    private static Collection<Class<? extends Action>> EXPLICIT_ACTIONS =
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
        register(UriAction.TYPE_NAME, UriAction.class);
    }

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
        Optional<String> matchingTypeName = ACTION_NAME_CLASS_MAP.keySet().stream()
            .filter(typeName -> names.contains(typeName)).findFirst();
        if (matchingTypeName.isPresent()) {
            return ACTION_NAME_CLASS_MAP.get(matchingTypeName.get());
        }
        throw new UnknownActionException(
            format("Could not identify any action using keys: {0}.", names));
    }
}
