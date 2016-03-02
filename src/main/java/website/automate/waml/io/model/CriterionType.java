package website.automate.waml.io.model;

import static java.util.Arrays.asList;

import java.util.List;

public enum CriterionType {
    CLEAR("clear"),
    IF("if"),
    UNLESS("unless"),
    SELECTOR("selector"),
    SCENARIO("scenario"),
    TEXT("text"),
    TIME("time"),
    TIMEOUT("timeout"),
    URL("url"),
    VALUE("value"),
    INPUT("input"),
    PARENT("parent"),
    ABSENT("absent");

    public static final List<CriterionType> FILTER_CRITERIA_TYPES = asList(SELECTOR, TEXT, VALUE);
    
    private final String name;
    
    private CriterionType(String name){
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public static CriterionType findByName(String name){
        for(CriterionType criteriaType : values()){
            if(criteriaType.getName().equals(name)){
                return criteriaType;
            }
        }
        return null;
    }
}
