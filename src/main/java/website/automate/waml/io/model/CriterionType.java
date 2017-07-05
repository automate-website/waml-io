package website.automate.waml.io.model;

import static java.util.Arrays.asList;

import java.util.List;

public enum CriterionType {
    
    CLEAR(CriterionNames.CLEAR),
    IF(CriterionNames.IF),
    UNLESS(CriterionNames.UNLESS),
    SELECTOR(CriterionNames.SELECTOR),
    SCENARIO(CriterionNames.SCENARIO),
    TEXT(CriterionNames.TEXT),
    TIME(CriterionNames.TIME),
    TIMEOUT(CriterionNames.TIMEOUT),
    URL(CriterionNames.URL),
    VALUE(CriterionNames.VALUE),
    INPUT(CriterionNames.INPUT),
    PARENT(CriterionNames.PARENT),
    ABSENT(CriterionNames.ABSENT),
    FACTS(CriterionNames.FACTS);
    
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
