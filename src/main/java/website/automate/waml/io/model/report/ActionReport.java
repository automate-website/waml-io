package website.automate.waml.io.model.report;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import website.automate.waml.io.model.main.action.Action;

import java.util.List;

@JsonPropertyOrder({
    "step", "status", "message", "time", "path", "log"
})
public class ActionReport {

    private String path;

    private String message;

    private Double time = 0.0;

    private ExecutionStatus status;

    @JsonUnwrapped
    private Action step;

    @JsonProperty("log")
    private List<LogEntry> logEntries;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Double getTime() {
        return time;
    }

    @JsonSetter
    public void setTime(Double time) {
        this.time = time;
    }

    public void setTime(Long startTimeInMillis) {
        this.time = (System.currentTimeMillis() - startTimeInMillis) / 1000.0;
    }

    public ExecutionStatus getStatus() {
        return status;
    }

    public void setStatus(ExecutionStatus status) {
        this.status = status;
    }

    public List<LogEntry> getLogEntries() {
        return logEntries;
    }

    public void setLogEntries(List<LogEntry> logEntries) {
        this.logEntries = logEntries;
    }

    public Action getStep() {
        return step;
    }

    public void setStep(Action step) {
        this.step = step;
    }

}
