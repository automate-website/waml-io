package website.automate.waml.io.model.action;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"when", "invert", "register", "timeout"})
public interface Action {

  String getWhen();

  String getRegister();

  String getTimeout();

  String getInvert();
}
