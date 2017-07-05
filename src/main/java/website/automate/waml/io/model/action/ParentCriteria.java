package website.automate.waml.io.model.action;

import static website.automate.waml.io.model.CriterionNames.FRAME;
import static website.automate.waml.io.model.CriterionNames.SELECTOR;
import static website.automate.waml.io.model.CriterionNames.TEXT;
import static website.automate.waml.io.model.CriterionNames.VALUE;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({FRAME, SELECTOR, TEXT, VALUE})
public class ParentCriteria {

    private String selector;
    
    private String text;
    
    private String value;
    
    private String frame;
    
    public ParentCriteria(){
      super();
    }
    
    @JsonCreator
    public ParentCriteria(String selector){
      this();
      this.selector = selector;
    }
    
    @JsonCreator
    public ParentCriteria(@JsonProperty("selector") String selector, @JsonProperty("text") String text,
        @JsonProperty("value") String value, @JsonProperty("frame") String frame){
      this(selector);
      this.text = text;
      this.value = value;
      this.frame = frame;
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
          value == null &&
          frame == null;
    }
    
    @JsonIgnore
    public String getDefaultCriterionValue(){
      return selector;
    }
    
    public String getFrame() {
      return frame;
    }
  
    public void setFrame(String frame) {
      this.frame = frame;
    }
}
