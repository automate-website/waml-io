package website.automate.waml.io.model.action;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ParentCriteria {

    private String selector;
    
    private String text;
    
    private String value;
    
    @JsonCreator
    public ParentCriteria(String selector){
      this.selector = selector;
    }
    
    @JsonCreator
    public ParentCriteria(@JsonProperty("selector") String selector, @JsonProperty("text") String text,
        @JsonProperty("value") String value){
      this(selector);
      this.text = text;
      this.value = value;
    }
    
    public String getSelector() {
        return selector;
    }

    public void setSelector(String selector) {
        this.selector = selector;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    @JsonIgnore
    public boolean canBeShortNotated(){
      return text == null &&
          value == null;
    }
    
    @JsonIgnore
    public String getDefaultCriterionValue(){
      return selector;
    }
}
