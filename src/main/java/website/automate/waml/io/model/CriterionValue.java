package website.automate.waml.io.model;

import java.util.Map;
import java.util.Objects;

public class CriterionValue {

    private Object value;
    
    public static CriterionValue of(Object value){
        return new CriterionValue(value);
    }
    
    public CriterionValue(int value){
        this.value = value;
    }
    
    public CriterionValue(String value){
        this.value = value;
    }
    
    public CriterionValue(Object value){
        this.value = value;
    }
    
    public String asString(){
        return value.toString();
    }
    
    public Boolean asBoolean(){
        return Boolean.parseBoolean(asString());
    }
    
    public Long asLong(){
        return Long.parseLong(value.toString());
    }
    
    public Integer asInteger(){
        return Integer.class.cast(value);
    }
    
    public Double asDouble(){
        return Double.class.cast(value);
    }
    
    public Object asObject(){
        return value;
    }
    
    @SuppressWarnings("unchecked")
    public Map<String, CriterionValue> asMap(){
        return (Map<String, CriterionValue>)value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CriterionValue other = (CriterionValue) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
}
