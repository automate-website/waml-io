package website.automate.waml.io.model.step;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import website.automate.waml.io.report.StepReport;

@JsonPropertyOrder({"when", "unless", "timeout", "invert", "register", "report"})
public interface Step {

    String getWhen();

    String getUnless();

    String getRegister();

    String getTimeout();

    String getInvert();

    StepReport getReport();

    String getMeta();

    @JsonIgnore
    String getName();
}
