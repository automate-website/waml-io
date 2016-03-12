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
    
    public CriterionValue(Boolean value){
        this.value = value;
    }
    
    @Override
    public String toString(){
        return value.toString();
    }
    
    public Boolean toBoolean(){
        return Boolean.parseBoolean(toString());
    }
    
    public Long toLong(){
        return Long.parseLong(value.toString());
    }
    
    public Integer toInteger(){
        return Integer.parseInt(value.toString());
    }
    
    public Double toDouble(){
        return Double.parseDouble(value.toString());
    }
    
    public Object getValue() {
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
        } else if (!obj.toString().equals(other.toString()))
            return false;
        return true;
    }
}
