package website.automate.waml.io.model.step;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import website.automate.waml.io.report.StepReport;

@JsonPropertyOrder({"when", "unless", "timeout", "invert", "register"})
public interface Step {

  String getWhen();
  
  String getUnless();

  String getRegister();

  String getTimeout();

  String getInvert();

  StepReport getReport();
  
  @JsonIgnore
  String getName();
}
