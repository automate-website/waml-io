package website.automate.waml.io.model.action;

import static website.automate.waml.io.model.CriterionNames.*;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({IF, UNLESS, SELECTOR, TIME, SCENARIO, URL, TEXT, VALUE, FACTS, INPUT, TIMEOUT,
    STORE, META})
public interface Action {

  String getWhen();
  
  String getRegister();
  
  String getTimeout();
  
  String getInvert();
}
