package website.automate.waml.io.model;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import website.automate.waml.io.model.action.*;

public enum ActionType {

    CLICK("click", CriterionType.SELECTOR, ClickAction.class),
    ENSURE("ensure", CriterionType.SELECTOR, EnsureAction.class),
    ENTER("enter", CriterionType.INPUT, EnterAction.class),
    INCLUDE("include", CriterionType.SCENARIO, IncludeAction.class),
    MOVE("move", CriterionType.SELECTOR, MoveAction.class),
    OPEN("open", CriterionType.URL, OpenAction.class),
    SELECT("select", CriterionType.SELECTOR, SelectAction.class),
    WAIT("wait", CriterionType.TIME, WaitAction.class),
    STORE("store", CriterionType.FACTS, DefineAction.class),
    ALERT("alert", CriterionType.CONFIRM, AlertAction.class);

	public static Set<ActionType> ACTION_TYPES = EnumSet.allOf(ActionType.class);

	public static Set<ActionType> EXPLICIT_ACTION_TYPES = EnumSet.of(CLICK, ENTER, MOVE, OPEN, SELECT, WAIT, ENSURE);

    private static Map<Class<? extends Action>, ActionType> ACTION_CLAZZ_TYPE_MAP = new HashMap<>();

    private static Map<String, ActionType> ACTION_NAME_TYPE_MAP = new HashMap<>();

    static {
        ACTION_CLAZZ_TYPE_MAP.put(ClickAction.class, CLICK);
        ACTION_CLAZZ_TYPE_MAP.put(EnsureAction.class, ENSURE);
        ACTION_CLAZZ_TYPE_MAP.put(EnterAction.class, ENTER);
        ACTION_CLAZZ_TYPE_MAP.put(IncludeAction.class, INCLUDE);
        ACTION_CLAZZ_TYPE_MAP.put(MoveAction.class, MOVE);
        ACTION_CLAZZ_TYPE_MAP.put(OpenAction.class, OPEN);
        ACTION_CLAZZ_TYPE_MAP.put(SelectAction.class, SELECT);
        ACTION_CLAZZ_TYPE_MAP.put(WaitAction.class, WAIT);
        ACTION_CLAZZ_TYPE_MAP.put(DefineAction.class, STORE);
        ACTION_CLAZZ_TYPE_MAP.put(AlertAction.class, ALERT);

        ACTION_NAME_TYPE_MAP.put(CLICK.getName(), CLICK);
        ACTION_NAME_TYPE_MAP.put(ENSURE.getName(), ENSURE);
        ACTION_NAME_TYPE_MAP.put(ENTER.getName(), ENTER);
        ACTION_NAME_TYPE_MAP.put(INCLUDE.getName(), INCLUDE);
        ACTION_NAME_TYPE_MAP.put(MOVE.getName(), MOVE);
        ACTION_NAME_TYPE_MAP.put(OPEN.getName(), OPEN);
        ACTION_NAME_TYPE_MAP.put(SELECT.getName(), SELECT);
        ACTION_NAME_TYPE_MAP.put(WAIT.getName(), WAIT);
        ACTION_NAME_TYPE_MAP.put(STORE.getName(), STORE);
        ACTION_NAME_TYPE_MAP.put(ALERT.getName(), ALERT);
    }

    private final String name;

    private final Class<? extends Action> clazz;

    private CriterionType defaultCriteriaType;

    private ActionType(String name, CriterionType defaultCriteriaType,
            Class<? extends Action> clazz){
        this.name = name;
        this.defaultCriteriaType = defaultCriteriaType;
        this.clazz = clazz;
    }

    public CriterionType getDefaultCriteriaType() {
        return defaultCriteriaType;
    }

    public String getName() {
        return name;
    }

    public Class<? extends Action> getClazz() {
        return clazz;
    }

    public static ActionType findByName(String name){
        return ACTION_NAME_TYPE_MAP.get(name);
    }

    public static ActionType findByClazz(Class<? extends Action> clazz){
        return ACTION_CLAZZ_TYPE_MAP.get(clazz);
    }

    public static boolean isExplicit(Class<? extends Action> clazz){
        return EXPLICIT_ACTION_TYPES.contains(findByClazz(clazz));
    }

    public static boolean isImplicit(Class<? extends Action> clazz){
        return !isExplicit(clazz);
    }

    @Override
    public String toString(){
    	return getName();
    }
}
