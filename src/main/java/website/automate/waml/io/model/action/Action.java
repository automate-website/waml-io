package website.automate.waml.io.model.action;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import website.automate.waml.io.report.ActionReport;

@JsonPropertyOrder({"when", "unless", "timeout", "invert", "register", "report"})
public interface Action {

    String getWhen();

    String getUnless();

    String getRegister();

    String getTimeout();

    String getInvert();

    ActionReport getReport();

    String getMeta();

    @JsonIgnore
    String getName();
}
