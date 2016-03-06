package website.automate.waml.io.model;

import website.automate.waml.io.model.action.Action;
import website.automate.waml.io.model.action.ClickAction;
import website.automate.waml.io.model.action.EnsureAction;
import website.automate.waml.io.model.action.EnterAction;
import website.automate.waml.io.model.action.IncludeAction;
import website.automate.waml.io.model.action.MoveAction;
import website.automate.waml.io.model.action.OpenAction;
import website.automate.waml.io.model.action.SelectAction;
import website.automate.waml.io.model.action.StoreAction;
import website.automate.waml.io.model.action.WaitAction;

public enum ActionType {
    
    CLICK("click", CriterionType.SELECTOR, ClickAction.class),
    ENSURE("ensure", CriterionType.SELECTOR, EnsureAction.class),
    ENTER("enter", CriterionType.INPUT, EnterAction.class),
    INCLUDE("include", CriterionType.SCENARIO, IncludeAction.class),
    MOVE("move", CriterionType.SELECTOR, MoveAction.class),
    OPEN("open", CriterionType.URL, OpenAction.class),
    SELECT("select", CriterionType.SELECTOR, SelectAction.class),
    WAIT("wait", CriterionType.TIME, WaitAction.class),
    STORE("store", CriterionType.VALUE, StoreAction.class);

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
        for(ActionType actionType : values()){
            if(actionType.getName().equals(name)){
                return actionType;
            }
        }
        return null;
    }
    
    public static ActionType findByClazz(Class<? extends Action> clazz){
        for(ActionType actionType : values()){
            if(actionType.getClazz().equals(clazz)){
                return actionType;
            }
        }
        return null;
    }
}
