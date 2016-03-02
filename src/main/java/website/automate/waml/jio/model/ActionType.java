package website.automate.waml.jio.model;

public enum ActionType {
    
    CLICK("click", CriterionType.SELECTOR),
    ENSURE("ensure", CriterionType.SELECTOR),
    ENTER("enter", CriterionType.INPUT),
    INCLUDE("include", CriterionType.SCENARIO),
    MOVE("move", CriterionType.SELECTOR),
    OPEN("open", CriterionType.URL),
    SELECT("select", CriterionType.SELECTOR),
    WAIT("wait", CriterionType.TIME),
    STORE("store", CriterionType.VALUE);
    
    private final String name;
    
    private CriterionType defaultCriteriaType;
    
    private ActionType(String name, CriterionType defaultCriteriaType){
        this.name = name;
        this.defaultCriteriaType = defaultCriteriaType;
    }
    
    public CriterionType getDefaultCriteriaType() {
        return defaultCriteriaType;
    }
    
    public String getName() {
        return name;
    }
    
    public static ActionType findByName(String name){
        for(ActionType actionType : values()){
            if(actionType.getName().equals(name)){
                return actionType;
            }
        }
        return null;
    }
}
