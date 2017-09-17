package website.automate.waml.io.model.step;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"when", "unless", "invert", "timeout", "register"})
public interface Step {

  String getWhen();
  
  String getUnless();

  String getRegister();

  String getTimeout();

  String getInvert();
}
